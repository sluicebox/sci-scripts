;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 490)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use ProjClient)
(use TargActor)
(use Flame)
(use Full)
(use n095)
(use Interface)
(use LoadMany)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm490 0
)

(local
	I
	[str 100]
	[candles 6]
	[candleX 6] = [118 114 83 53 50 84]
	[candleY 6] = [107 98 93 98 107 114]
	[flame 6]
	[flmX 6] = [117 113 82 52 49 83]
	[flmY 6] = [96 87 82 87 96 103]
	candleTimer
	[FdeltaX 4] = [-4 0 2 0]
	[FdeltaY 4] = [10 13 17 18]
	rollodex
	tightFree
	inRoom
	ditherTimer
	ditherCount
	slideCount
	throwWhat
	theProj
	theX
	theY
	egoDucked
	avisHit
	scrambled
	avisTimer
	spellBroke
	stepCount
)

(procedure (makeAFlame)
	((= [flame I] (aFlame new:))
		x: [flmX I]
		y: [flmY I]
		init:
	)
	(++ I)
)

(procedure (setArcLevel)
	(switch gArcadeLevel
		(1
			(= avisTimer 150)
		)
		(2
			(= avisTimer 120)
		)
		(3
			(= avisTimer 60)
		)
	)
)

(instance toPillar of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 491 loop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(if (== stepCount 2)
					(gEgo cel: 4 posn: (+ (gEgo x:) 5) (- (gEgo y:) 1))
				else
					(gEgo cel: 4 posn: (+ (gEgo x:) 5) (gEgo y:))
				)
				(if (== stepCount 2)
					(= stepCount 0)
				else
					(++ stepCount)
				)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance fromPillar of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 491 loop: 0 cel: 4)
				(= cycles 1)
			)
			(1
				(gEgo cel: 3)
				(= cycles 1)
			)
			(2
				(gEgo cel: 2)
				(= cycles 1)
			)
			(3
				(gEgo cel: 1)
				(= cycles 1)
			)
			(4
				(if (== stepCount 2)
					(gEgo cel: 0 posn: (- (gEgo x:) 5) (+ (gEgo y:) 1))
				else
					(gEgo cel: 0 posn: (- (gEgo x:) 5) (gEgo y:))
				)
				(if (== stepCount 2)
					(= stepCount 0)
				else
					(++ stepCount)
				)
				(= cycles 1)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance rm490 of Rm
	(properties
		picture 490
	)

	(method (init)
		(LoadMany rsVIEW 6 8 32 4 9 612 47 501 555 491 495 613 3 490 285 781)
		(Load rsSCRIPT 491)
		(SolvePuzzle 715 5 2)
		(super init:)
		(= gSpellChecker spellCode)
		(iblis init:)
		(for ((= I 0)) (< I 6) ((++ I))
			((= [candles I] (aCandle new:))
				x: [candleX I]
				y: [candleY I]
				init:
				stopUpd:
			)
		)
		(= I 0)
		(makeAFlame)
		(avis init: setCycle: Fwd)
		(NormalEgo)
		(gEgo loop: 1 cel: 0 setPri: 12 posn: 330 160 init:)
		(self setScript: comeIn)
		(gCSound number: 470 loop: -1 playBed:)
	)

	(method (doit)
		(if (and (> (gEgo x:) 316) inRoom (not (gEgo script:)))
			(gEgo setScript: oNoYouDont)
		)
		(if (and (gEgo inRect: 31 126 46 136) (not tightFree))
			(= tightFree 1)
			(gEgo setScript: (ScriptID 491 1)) ; disposeRope
			(gCurRoom setScript: nowWhat)
		)
		(if (and (gEgo inRect: 120 118 140 125) (not scrambled))
			(= scrambled 1)
			(= avisTimer 5)
			(gEgo view: 491 loop: 3 cel: 0)
		)
		(cond
			((not avisTimer))
			((-- avisTimer))
			((not (avis script:))
				(avis setScript: shootEm)
			)
		)
		(cond
			((not ditherTimer))
			((-- ditherTimer))
			((== ditherCount 0)
				(djinniPrint 490 0) ; "Please, Master, we've got to get over there fast."
				(= ditherTimer 50)
				(++ ditherCount)
			)
			((== ditherCount 1)
				(djinniPrint 490 1) ; "Please, Master, we are almost out of time!"
				(= ditherTimer 50)
				(++ ditherCount)
			)
			((== ditherCount 2)
				(djinniPrint 490 2) ; "Don't you have something you can use? We have to stop Iblis from getting free!"
				(++ ditherCount)
			)
			((== ditherCount 3)
				(djinniPrint 490 3) ; "Master, you've got to do something!"
				(= ditherTimer 50)
				(++ ditherCount)
			)
			((== ditherCount 4)
				(djinniPrint 490 4) ; "Do something to knock down that last candle!"
			)
		)
		(cond
			((not candleTimer))
			((-- candleTimer))
			(else
				(avis setScript: fireUp)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 491)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look,look>')
				(cond
					((or (Said '<up') (Said '/sky'))
						(HighPrint 490 5) ; "The night sky is ablaze with stars."
					)
					((or (Said '<down') (Said '/ground,courtyard,roof'))
						(HighPrint 490 6) ; "Everything below you is dark and quiet."
					)
					(
						(or
							(Said
								'search,look,look[<at,around][/room,area][/!*]'
							)
							(Said '/building,city,castle,hill,hill,minaret')
						)
						(HighPrint 490 7) ; "The spectacular moonlit glow of the surrounding mountains and the once-fabulous Palace of Raseir is diminished by the peril of the moment."
					)
					((Said '/chamber,ritual')
						(cond
							(tightFree
								(djinniPrint 490 8) ; "Never mind the sightseeing. Do what you came for."
							)
							((== script avisDead)
								(HighPrint 490 9) ; "You've done it! The evil Wazir is dead!"
							)
							(else
								(HighPrint 490 10) ; "The ritual chamber is the seat of Ad Avis's magical power, and he's using that power for all it's worth right now."
							)
						)
					)
					((Said '/design,floor,pattern,hexagram,rune,star')
						(HighPrint 490 11) ; "It's the symbol of Iblis' power."
					)
					((and (Said '/djinn') (not (gCast contains: stayPufft)))
						(HighPrint 490 12) ; "Who ya gonna call.....?"
					)
				)
			)
			((Said 'hop')
				(djinniPrint 490 13) ; "No, Master. You'd only get yourself killed."
			)
			((Said 'duck')
				(if (and (< (gEgo x:) 200) (< (avis y:) 150))
					(gEgo setScript: duckDown)
				else
					(HighPrint 490 14) ; "Quack!!!"
				)
			)
			((Said '(get[<off])/ring')
				(HighPrint 490 15) ; "You feel a sharp shock."
				(djinniPrint 490 16) ; "Sorry, Master, but we must get Iblis first."
			)
			((Said 'ask,tell/djinn')
				(djinniPrint 490 17) ; "There's no time for questions. You've got to do something."
			)
			((Said 'get,get')
				(HighPrint 490 18) ; "The only thing you can get right now is killed."
			)
			((Said 'tell')
				(djinniPrint 490 19) ; "Quit blubbering and DO something."
			)
			(
				(or
					(Said 'spray,squirt,splash/fire,candle,water,waterbag')
					(Said 'douse,(put<out)/fire,candle')
					(Said 'throw,use/water,waterbag')
				)
				(cond
					((<= gDrinksLeft 0)
						(HighPrint 490 20) ; "You have no water."
					)
					((> (gEgo x:) 200)
						(HighPrint 490 21) ; "Not over here!"
					)
					(else
						(-- gDrinksLeft)
						(HighPrint 490 22) ; "You wet the candle, but that doesn't seem to stop its magic."
					)
				)
			)
			((Said 'use/bellows')
				(cond
					((not (gEgo has: 25)) ; Bellows
						(HighPrint 490 23) ; "You have no bellows."
					)
					((> (gEgo x:) 200)
						(HighPrint 490 21) ; "Not over here!"
					)
					(else
						(HighPrint 490 24) ; "There's not enough air left to blow down the candle. The Elemental is gone."
					)
				)
			)
			((Said 'throw/dagger')
				(= ditherTimer 0)
				(= throwWhat 5)
				(cond
					((bProjectile client:)
						(djinniPrint 490 25) ; "No! duck!!!"
					)
					((not (gEgo has: 5)) ; Dagger
						(HighPrint 490 26) ; "You don't have a throwing dagger."
					)
					((> (gEgo x:) 200)
						(gEgo setScript: wimpThrow)
					)
					(else
						(gEgo setScript: thrower)
					)
				)
			)
			((Said 'throw/boulder')
				(= ditherTimer 0)
				(= throwWhat 4)
				(cond
					((bProjectile client:)
						(djinniPrint 490 25) ; "No! duck!!!"
					)
					((not (gEgo has: 9)) ; Rock
						(HighPrint 490 27) ; "You don't have any rocks to throw."
					)
					((> (gEgo x:) 200)
						(gEgo setScript: wimpThrow)
					)
					(else
						(gEgo setScript: thrower)
					)
				)
			)
			((Said 'throw/dirt')
				(= ditherTimer 0)
				(= throwWhat 6)
				(cond
					((bProjectile client:)
						(djinniPrint 490 25) ; "No! duck!!!"
					)
					((and (not (gEgo has: 52)) (< gClumpsLeft 10)) ; MagicEarth
						(HighPrint 490 28) ; "You have no dirt to throw."
					)
					((> (gEgo x:) 200)
						(gEgo setScript: wimpThrow)
					)
					(else
						(gEgo setScript: thrower)
					)
				)
			)
			((Said 'throw/powder')
				(= ditherTimer 0)
				(= throwWhat 7)
				(cond
					((bProjectile client:)
						(djinniPrint 490 25) ; "No! duck!!!"
					)
					((not (gEgo has: 39)) ; BurningPowder
						(HighPrint 490 29) ; "You have no powder to throw."
					)
					((> (gEgo x:) 200)
						(gEgo setScript: wimpThrow)
					)
					(else
						(gEgo setScript: thrower)
					)
				)
			)
			((Said 'cast,drop,use,throw,climb,climb/rope[<magic]')
				(cond
					((not (gEgo has: 16)) ; Rope
						(event claimed: 0)
					)
					((< (gEgo x:) 200)
						(HighPrint 490 30) ; "That won't work. The spell Ad Avis placed around the ritual chamber stops all magic from getting in."
					)
					(else
						(= ditherTimer 0)
						((ScriptID 491 0) init:) ; it
					)
				)
			)
		)
	)
)

(instance aHead of TargActor
	(properties
		z 38
		noun '/ad,man,wizard,minister'
		description {Ad Avis}
		lookStr {Ad Avis is intent on raising Iblis.}
		view 555
		loop 5
		signal 16384
	)

	(method (cue)
		(super cue: &rest)
		(HighPrint 490 31) ; "You can't get a good shot at Ad Avis from where you are."
		(dagger dispose:)
	)

	(method (hurtMe &tmp moveScript)
		(if (gEgo inRect: 120 118 140 125)
			(if (== avisHit 1)
				(= avisTimer 0)
				(if (not (avis script:))
					(self setScript: avisDead)
				)
			else
				(switch throwWhat
					(4
						(if (== [gInvNum 9] 0) ; Rock
							(= avisTimer 0)
							(HighPrint 490 32 80 {Ad Avis:} 35 myHigh) ; "Ha! You're out of rocks. Now what will you do?"
							(if (not (avis script:))
								(self setScript: avisDead)
							)
						else
							(HighPrint 490 33 80 {Ad Avis:} 35 myHigh) ; "Ouch! I'll get you for that!"
							(++ avisHit)
						)
					)
					(5
						(if (== [gInvNum 5] 0) ; Dagger
							(= avisTimer 0)
							(if (not (avis script:))
								(self setScript: avisDead)
							)
						else
							(self setScript: avisPoked)
							(++ avisHit)
						)
					)
					(6
						(HighPrint 490 34 80 {Ad Avis:} 35 myHigh) ; "Ha! You think to win this campaign by slinging mud?!"
						(HighPrint 490 35 80 {Your Alter-Ego:}) ; "'Ello, my name is Ego Montoya. You spill my water. Prepare to dry!!"
						(HighPrint 490 36) ; "(Well, that was fun, but it didn't seem to have much effect.)"
					)
					(7
						(HighPrint 490 37) ; "The spell on the room prevents the powder from igniting."
					)
				)
			)
		else
			(dagger
				init:
				illegalBits: 0
				ignoreActors:
				posn: 189 86
				yStep: 10
				xStep: 3
				setPri: 6
				setLoop:
					(switch throwWhat
						(4 4)
						(5 5)
						(6 4)
						(7 4)
					)
				setCycle: Fwd
				setMotion: MoveTo 283 191 self
			)
			(return 0)
		)
	)
)

(instance flash of Prop
	(properties
		view 32
		loop 7
		signal 16384
	)
)

(instance smoke of Prop
	(properties
		x 88
		y 89
		view 781
		signal 16384
		cycleSpeed 3
	)
)

(instance nife of Actor
	(properties
		yStep 8
		view 9
		loop 5
		signal 2048
		illegalBits 0
		xStep 8
	)
)

(instance avis of TargActor
	(properties
		x 147
		y 114
		noun '/ad,man,wizard,minister'
		description {Ad Avis}
		lookStr {Ad Avis is intent on raising Iblis.}
		view 495
		loop 2
		cycleSpeed 1
	)

	(method (hurtMe)
		(aHead hurtMe:)
	)
)

(instance stayPufft of Actor
	(properties
		x 178
		y 115
		noun '/djinn'
		description {the ghost}
		lookStr {Do you mind if I'm smoke?}
		view 612
		loop 6
		cel 5
		priority 8
		signal 16400
		illegalBits 0
	)
)

(instance aCandle of TargActor
	(properties
		noun '/candle'
		description {the ritual candle}
		lookStr {The candles are a crucial part of the Iblis ritual.}
		view 490
	)

	(method (hurtMe &tmp whichCandle)
		(for ((= whichCandle 0)) (< whichCandle I) ((++ whichCandle))
			(if (== [candles whichCandle] self)
				(HighPrint 490 38) ; "It's already lit! You can't seem to knock it over!"
				(return 0)
			)
		)
		(if (not spellBroke)
			(self setScript: knockCandle)
		else
			(HighPrint 490 39) ; "The spell is already broken. You don't need to knock over any more candles."
		)
		(return 1)
	)
)

(instance dagger of Actor
	(properties
		yStep 8
		view 9
		loop 5
		signal 16384
		xStep 8
	)
)

(instance aFlame of Flame
	(properties
		view 490
		loop 1
		signal 16384
	)
)

(instance iblis of View
	(properties
		x 84
		y 102
		noun '/statue,iblis'
		description {the statue of Iblis}
		lookStr {It's the statue that has held Iblis for a Thousand Years and a Year.}
		view 613
		signal 16384
	)
)

(instance fireUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(avis loop: 0 cel: 0 cycleSpeed: 0 setCycle: Full 1 self)
			)
			(2
				(makeAFlame)
				(avis loop: 4 cel: 0 cycleSpeed: 1 setCycle: Fwd)
				(= cycles 4)
			)
			(3
				(avis loop: 2 cycleSpeed: 1 setCycle: Fwd)
				(switch gArcadeLevel
					(1
						(= candleTimer 290)
					)
					(2
						(= candleTimer 240)
					)
					(3
						(= candleTimer 220)
					)
				)
				(if (< I 6)
					(cond
						((and (!= (gEgo view:) 285) (== I 2))
							(djinniPrint 490 40) ; "A Candle!! Iblis will get free!!"
						)
						((== I 5)
							(djinniPrint 490 41) ; "There's only one candle left!! Do something!"
						)
						((!= (gEgo view:) 285)
							(djinniPrint 490 42) ; "Another candle! Iblis will be loose!!"
						)
					)
				)
				(= cycles 2)
			)
			(4
				(if (== I 6)
					(avis setScript: overAndOut)
					(gCurRoom setScript: 0)
					(self dispose:)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance dashing of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= rollodex 0)
				(gCurRoom setScript: 0)
				(gEgo view: 6 setLoop: 2 illegalBits: 0 setPri: 14 cel: 0)
				(= cycles 3)
			)
			(1
				(gEgo
					cel: (+ (gEgo cel:) 1)
					x: (+ (gEgo x:) [FdeltaX rollodex])
					y: (+ (gEgo y:) [FdeltaY rollodex])
				)
				(++ rollodex)
				(= cycles 1)
			)
			(2
				(if (< rollodex 5)
					(self changeState: 1)
				else
					(= rollodex 0)
					(self cue:)
				)
			)
			(3
				(gEgo hide:)
				(= cycles 1)
			)
			(4
				(HighPrint 490 43 80 {You fell for it!}) ; "The Djinni did his best to warn you. You are about to become road nachos. Let's hope you saved your game recently."
				(gCurRoom newRoom: 790)
			)
		)
	)
)

(instance comeIn of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setPri: 13 setMotion: MoveTo 305 160 self)
			)
			(1
				(djinniPrint 490 44) ; "There! Over there. Iblis is in the center of the ritual chamber. When the last candle is lit, Iblis will be loose. Let's go get him!"
				(= cycles 4)
			)
			(2
				(= inRoom 1)
				(= ditherTimer 50)
				(avis setScript: fireUp)
				(self dispose:)
			)
		)
	)
)

(instance oNoYouDont of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 305 160 self)
			)
			(1
				(djinniPrint 490 45) ; "No, no, Master. Iblis is the OTHER way. Let's go!!"
				(self dispose:)
			)
		)
	)
)

(instance knockCandle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= spellBroke 1)
				(= candleTimer 0)
				(avis setScript: 0)
				(client posn: (+ (client x:) 4) (client y:))
				(= cycles 2)
			)
			(1
				(if (< slideCount 6)
					(++ slideCount)
					(self changeState: 0)
				else
					(gCurRoom setScript: allOver)
					(avis setScript: avisBattle)
					(self dispose:)
				)
			)
		)
	)
)

(instance wimpThrow of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 9
					loop: 3
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(1
				(NormalEgo)
				(gEgo setPri: 12 loop: 7)
				(dagger
					posn: 279 127
					init:
					setLoop:
						(switch throwWhat
							(4 4)
							(5 5)
							(6 4)
							(7 4)
						)
					setCycle: Fwd
					setMotion: MoveTo 254 119 self
				)
			)
			(2
				(dagger setMotion: MoveTo 225 120 self)
			)
			(3
				(dagger setMotion: MoveTo 192 142 self)
			)
			(4
				(dagger setMotion: MoveTo 169 172 self)
			)
			(5
				(dagger setMotion: MoveTo 164 194 self)
			)
			(6
				(cond
					((== throwWhat 4)
						(gEgo use: 9) ; Rock
					)
					((== throwWhat 5)
						(gEgo use: 5) ; Dagger
					)
					((== throwWhat 6)
						(if (gEgo has: 52) ; MagicEarth
							(gEgo use: 52) ; MagicEarth
						else
							(-= gClumpsLeft 10)
						)
					)
					((== throwWhat 7)
						(gEgo use: 39) ; BurningPowder
					)
				)
				(dagger dispose:)
				(HighPrint 490 46) ; "The distance is too far for an accurate throw."
				(self dispose:)
			)
		)
	)
)

(instance allOver of Script
	(properties)

	(method (init)
		(super init: &rest)
		(DontMove 1)
		(gDirectionHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(gMouseDownHandler delete: self)
		(DontTalk 0)
		(DontMove 0)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp theAngle)
		(if (super handleEvent: event)
			(return 1)
		)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'throw')
						(if (not scrambled)
							(djinniPrint 490 47) ; "Not now, get to the pillar."
							(event claimed: 1)
						else
							(event claimed: 0)
						)
					)
				)
			)
			(evMOUSEBUTTON
				(if (!= (gEgo script:) dashing)
					(cond
						(
							(or
								(<
									(= theAngle
										(GetAngle
											(gEgo x:)
											(gEgo y:)
											(event x:)
											(event y:)
										)
									)
									45
								)
								(> theAngle 315)
							)
							(if (and (not scrambled) (not egoDucked))
								(djinniPrint 490 48) ; "I warned yooooouuuu!"
								(flash
									posn: (gEgo x:) (- (gEgo y:) 24)
									init:
									setPri: (+ (gEgo priority:) 1)
									setCycle: End
								)
								(gEgo setScript: dashing)
								(avis setScript: 0)
								(self dispose:)
							)
						)
						((< 135 theAngle 225)
							(if (not (gEgo script:))
								(gEgo setScript: duckDown)
							)
						)
						((< 225 theAngle 315)
							(if (and (not (gEgo script:)) (not scrambled))
								(gEgo setScript: fromPillar)
							)
						)
						(
							(and
								(< 45 theAngle 135)
								(not (gEgo script:))
								(not scrambled)
							)
							(gEgo setScript: toPillar)
						)
					)
				)
			)
			($0040 ; direction
				(event claimed: 1)
				(switch (event message:)
					(JOY_UP
						(if (and (not scrambled) (not egoDucked))
							(djinniPrint 490 48) ; "I warned yooooouuuu!"
							(flash
								posn: (gEgo x:) (- (gEgo y:) 24)
								init:
								setPri: (+ (gEgo priority:) 1)
								setCycle: End
							)
							(gEgo setScript: dashing)
							(avis setScript: 0)
							(self dispose:)
						)
					)
					(JOY_DOWN
						(if (not (gEgo script:))
							(gEgo setScript: duckDown)
						)
					)
					(JOY_LEFT
						(if (and (not (gEgo script:)) (not scrambled))
							(gEgo setScript: fromPillar)
						)
					)
					(JOY_DOWNLEFT
						(if (and (not (gEgo script:)) (not scrambled))
							(gEgo setScript: fromPillar)
						)
					)
					(JOY_RIGHT
						(if (and (not (gEgo script:)) (not scrambled))
							(gEgo setScript: toPillar)
						)
					)
					(JOY_UPRIGHT
						(if (and (not (gEgo script:)) (not scrambled))
							(gEgo setScript: toPillar)
						)
					)
				)
			)
		)
	)
)

(instance myHigh of TopWindow
	(properties)
)

(instance avisBattle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(myHigh color: 13 back: 0)
				(Print 490 49 #title {Ad Avis:} #window myHigh) ; "NO!! After 70 years, No!"
				(for ((= I 0)) (< I 6) ((++ I))
					([candles I] signal: -32735)
					(InitAddToPics [candles I])
				)
				(for ((= I 0)) (< I 6) ((++ I))
					([candles I] dispose:)
				)
				(= cycles 2)
			)
			(1
				(avis
					view: 555
					loop: 1
					cel: 0
					posn: (+ (avis x:) 13) (- (avis y:) 2)
					setCycle: End self
				)
			)
			(2
				(avis loop: 3)
				(aHead posn: (avis x:) (avis y:) init: setCycle: End)
				(HighPrint 490 50 80 {Ad Avis:} 35 myHigh) ; "YOU!!!"
				(= cycles 2)
			)
			(3
				(djinniPrint 490 51) ; "I think you made him angry, Master. Better duck!"
				(switch gArcadeLevel
					(1
						(= seconds 5)
					)
					(2
						(= seconds 3)
					)
					(3
						(= seconds 2)
					)
				)
			)
			(4
				(avis setCycle: End self)
			)
			(5
				(bProjectile
					type: 25
					xStart: (- (avis x:) 20)
					yStart: (- (avis y:) 36)
					x:
						(if egoDucked
							(- (gEgo x:) 20)
						else
							(gEgo x:)
						)
					y: (- (gEgo y:) 35)
				)
				(self setScript: bProjectile self)
			)
			(6
				(avis setCycle: Beg)
				(if (not egoDucked)
					(gEgo setScript: dashing)
					(avis setScript: 0)
				else
					(self cue:)
				)
			)
			(7
				(djinniPrint 490 52) ; "Missed us! Let's get him, Master! Go over to the other pillar where you can get back at that wicked old human."
				(= cycles 2)
			)
			(8
				(avis setScript: scurry)
				(self dispose:)
			)
		)
	)
)

(instance scurry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(avis cel: 2 setCycle: Beg self)
			)
			(2
				(djinniPrint 490 53) ; "Better steer clear, boss. This one is big."
				(switch gArcadeLevel
					(1
						(= seconds 5)
					)
					(2
						(= seconds 3)
					)
					(3
						(= seconds 2)
					)
				)
			)
			(3
				(avis setCycle: End self)
			)
			(4
				(bProjectile
					type: 25
					xStart: (- (avis x:) 20)
					yStart: (- (avis y:) 36)
					x:
						(if egoDucked
							(- (gEgo x:) 20)
						else
							(gEgo x:)
						)
					y: (- (gEgo y:) 35)
				)
				(self setScript: bProjectile self)
			)
			(5
				(avis setCycle: Beg)
				(if (not egoDucked)
					(gEgo setScript: dashing)
				)
				(setArcLevel)
				(self dispose:)
			)
		)
	)
)

(instance nowWhat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SolvePuzzle 716 3 2)
				(= cycles 2)
			)
			(1
				(djinniPrint 490 54) ; "Careful, Master. There is some sort of spell between the pillars. It won't let any magic or anything alive get through from outside. Even so, somehow we've got to stop the last candle from being lit."
				(= ditherTimer 50)
				(= ditherCount 3)
				(= cycles 2)
			)
			(2
				(gEgo
					view: 491
					loop: 2
					cel: 0
					posn: 39 128
					signal: 16384
					cycleSpeed: 2
					setMotion: 0
					setPri: 11
					setCycle: End self
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance thrower of ProjClient
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not spellBroke)
					(avis setScript: 0)
				)
				(gEgo loop: 3 cel: 0)
				(cond
					((== throwWhat 4)
						(= type 4)
					)
					((== throwWhat 5)
						(= type 5)
					)
					((or (== throwWhat 7) (== throwWhat 6))
						(= type 1)
					)
				)
				(self setScript: (AimSpell new:) self type)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(= theX (+ (gEgo x:) 12))
				(= theY (- (gEgo y:) 37))
				(aProjectile
					type: type
					xStart: theX
					yStart: theY
					x: x
					y: y
				)
				(self setScript: aProjectile self)
				(cond
					((== throwWhat 4)
						(gEgo use: 9) ; Rock
					)
					((== throwWhat 5)
						(gEgo use: 5) ; Dagger
					)
					((== throwWhat 6)
						(if (gEgo has: 52) ; MagicEarth
							(gEgo use: 52) ; MagicEarth
						else
							(-= gClumpsLeft 10)
						)
					)
					((== throwWhat 7)
						(gEgo use: 39) ; BurningPowder
					)
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance aProjectile of Projectile
	(properties)
)

(instance bProjectile of Projectile
	(properties)
)

(instance overAndOut of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(djinniPrint 490 55) ; "We're too late!! Look!!"
				(cond
					((== (gEgo view:) 285)
						(gCurRoom setScript: 0)
						(gEgo setScript: dashing)
					)
					((< (gEgo x:) 200)
						(gEgo
							loop: 4
							cel: 1
							posn: (- (gEgo x:) 6) (+ (gEgo y:) 8)
						)
					)
					(else
						(gEgo view: 47 loop: 1 cel: 0 setCycle: End)
					)
				)
				(= cycles 2)
			)
			(1
				(smoke init: setCycle: End self)
				(ShakeScreen 10 ssLEFTRIGHT)
				(if (< (gEgo x:) 200)
					(gEgo
						loop: 4
						cel: 2
						posn: (+ (gEgo x:) 19) (+ (gEgo y:) 13)
					)
				)
			)
			(2
				(smoke loop: 1 cel: 0 cycleSpeed: 3 setCycle: End self)
				(ShakeScreen 3 ssFULL_SHAKE)
				(if (< (gEgo x:) 200)
					(gEgo
						loop: 4
						cel: 1
						posn: (+ (gEgo x:) 8) (+ (gEgo y:) 8)
					)
				)
			)
			(3
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 2)
				(= cycles 6)
			)
			(4
				(Print 490 56 #title {Shake, Rattle and Roll!}) ; "The buildings start to collapse as Iblis rises up. You frantically hold on to the edge, but it crumbles in your hands, and you start to fall. Your only consolation is the look of surprise on Ad Avis's face as the roof collapses on him."
				(gCurRoom newRoom: 790)
			)
		)
	)
)

(instance duckDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 47 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(= egoDucked 1)
				(switch gArcadeLevel
					(1
						(= seconds 7)
					)
					(2
						(= seconds 5)
					)
					(3
						(= seconds 4)
					)
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(= egoDucked 0)
				(gEgo view: 491 loop: (if (not scrambled) 0 else 3) cel: 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance shootEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HighPrint 490 57 80 {Ad Avis:} 35 myHigh) ; "I shall destroy you!"
				(switch gArcadeLevel
					(1
						(= seconds 5)
					)
					(2
						(= seconds 3)
					)
					(3
						(= seconds 2)
					)
				)
			)
			(1
				(avis setCycle: End self)
			)
			(2
				(bProjectile
					type: 25
					xStart: (- (avis x:) 20)
					yStart: (- (avis y:) 36)
					x:
						(if egoDucked
							(- (gEgo x:) 20)
						else
							(gEgo x:)
						)
					y: (- (gEgo y:) 35)
				)
				(self setScript: bProjectile self)
			)
			(3
				(avis setCycle: Beg)
				(if (not egoDucked)
					(gEgo setScript: dashing)
				)
				(setArcLevel)
				(self dispose:)
			)
		)
	)
)

(instance avisDead of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SolvePuzzle 714 20 2)
				(aHead hide:)
				(self setScript: avisBack self)
			)
			(1
				(= cycles 1)
			)
			(2
				(= cycles 1)
			)
			(3
				(djinniPrint 490 58) ; "Yeah! We did it!"
				(= cycles 2)
			)
			(4
				(djinniPrint 490 59) ; "The spell on the room is broken now, Master. We can go in."
				(= cycles 2)
			)
			(5
				(gEgo
					view: 491
					loop: 0
					cel: 1
					posn: (- (gEgo x:) 7) (+ (gEgo y:) 2)
				)
				(= cycles 1)
			)
			(6
				(gEgo cel: 0)
				(= cycles 1)
			)
			(7
				(gEgo
					view: 0
					loop: 7
					cel: 0
					posn: (- (gEgo x:) 4) (+ (gEgo y:) 3)
				)
				(= cycles 1)
			)
			(8
				(gEgo
					view: 3
					loop: 3
					cel: 3
					setPri: 8
					posn: (- (gEgo x:) 7) (gEgo y:)
				)
				(= cycles 1)
			)
			(9
				(gEgo cel: 4 posn: (gEgo x:) (+ (gEgo y:) 4))
				(= cycles 2)
			)
			(10
				(gEgo posn: (- (gEgo x:) 2) (+ (gEgo y:) 2) cel: 5)
				(= cycles 2)
			)
			(11
				(gEgo view: 0 loop: 3)
				(= cycles 1)
			)
			(12
				(djinniPrint 490 60) ; "Thank You, Master. Now I can take Iblis back to his tomb where he will be safe for another Thousand Years and a Year."
				(= cycles 2)
			)
			(13
				(stayPufft
					loop: 1
					cel: 0
					posn: 117 102
					init:
					setCycle: End self
				)
			)
			(14
				(stayPufft
					setLoop: 3
					cycleSpeed: 1
					xStep: 1
					yStep: 1
					setCycle: Walk
					setMotion: MoveTo 107 99 self
				)
			)
			(15
				(stayPufft cycleSpeed: 1 setCycle: Fwd)
				(= seconds 2)
			)
			(16
				(stayPufft setLoop: 6 cel: 0 setCycle: End self)
				(iblis dispose:)
			)
			(17
				(stayPufft hide:)
				(= seconds 3)
			)
			(18
				(stayPufft show: setCycle: Beg self)
			)
			(19
				(stayPufft view: 612 setLoop: 3 cycleSpeed: 1 setCycle: Fwd)
				(= seconds 3)
			)
			(20
				(CenterPrint 490 61 35 aWin) ; "I knew I would remember it. The real prophecy is..."
				(= cycles 2)
			)
			(21
				(CenterPrint 490 62 80 {Djinni:} 70 315) ; "One thousand years and a year,  so shall Iblis be caught, In the tombstones of the City,  where he and I once fought. Until moonlight has been captured,  twixt Scorpion and Drake, Then comes a Hero from the North,  and ancient powers wake."
				(= cycles 2)
			)
			(22
				(CenterPrint 490 63 80 {Djinni:} 70 315 35 aWin) ; "Led and followed by a Dark one,  guide to deceit and despair, Passing through the Door unopened,  barrier that yields to none, By my name of Suleiman,  so shall this be done!"
				(= cycles 2)
			)
			(23
				(CenterPrint 490 64 80 {Djinni:} 70 315 35 aWin) ; "Come at last onto betrayal,  and to 'He who waits behind', Seek ye then to capture Iblis,  'ere he rises unconfined. Else shall come the night eternal,  darkness overshadows light, Unless a hero seeks the darkness  and restores the wrongs to right."
				(= seconds 3)
			)
			(24
				(stayPufft setLoop: 6 cel: 0 setCycle: End self)
			)
			(25
				(stayPufft hide:)
				(= seconds 4)
			)
			(26
				(djinniPrint 490 65) ; "Bye, Bye, Master. It's been fun!"
				(= cycles 2)
			)
			(27
				(gCurRoom newRoom: 820) ; rmEndCartoon
			)
		)
	)
)

(instance avisPoked of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aHead hide:)
				(avis view: 509 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(avis
					view: 555
					loop: 3
					cel: 0
					posn: (+ (avis x:) 6) (- (avis y:) 2)
				)
				(aHead posn: (avis x:) (avis y:) show:)
				(nife
					posn: (+ (avis x:) 22) (- (avis y:) 42)
					init:
					setLoop: 5
					setCycle: Fwd
					setMotion: MoveTo 216 66 self
				)
			)
			(2
				(nife setLoop: 5 setCycle: Fwd setMotion: MoveTo 245 73 self)
			)
			(3
				(nife setLoop: 5 setCycle: Fwd setMotion: MoveTo 263 99 self)
			)
			(4
				(HighPrint 490 66 80 {Ad Avis:} 35 myHigh 25 4 103) ; "Is that the best you can do, little man??"
				(nife setLoop: 5 setCycle: Fwd setMotion: MoveTo 271 134 self)
			)
			(5
				(nife setLoop: 5 setCycle: Fwd setMotion: MoveTo 272 190 self)
			)
			(6
				(nife dispose:)
				(self dispose:)
			)
		)
	)
)

(instance avisBack of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSound number: 821 playBed:)
				(avis
					view: 509
					loop: 0
					cel: 0
					posn: (+ (avis x:) 3) (- (avis y:) 1)
					setCycle: End self
				)
			)
			(1
				(avis loop: 1 cel: 1 posn: (+ (avis x:) 4) (- (avis y:) 2))
				(= cycles 3)
			)
			(2
				(avis cel: 2 posn: (+ (avis x:) 5) (avis y:))
				(= cycles 3)
			)
			(3
				(avis cel: 3 posn: (+ (avis x:) 12) (+ (avis y:) 1))
				(= cycles 2)
			)
			(4
				(avis cel: 4 setPri: 6 posn: (+ (avis x:) 15) (+ (avis y:) 12))
				(= cycles 2)
			)
			(5
				(avis cel: 5 posn: (+ (avis x:) 12) (+ (avis y:) 16))
				(= cycles 1)
			)
			(6
				(avis cel: 6 posn: (+ (avis x:) 3) (+ (avis y:) 20))
				(= cycles 1)
			)
			(7
				(avis
					setCycle: Fwd
					setLoop: 1
					yStep: 10
					setMotion: MoveTo (avis x:) 230 self
				)
			)
			(8
				(avis hide:)
				(self dispose:)
			)
		)
	)
)

(instance aWin of SysWindow
	(properties
		back 13
	)
)

(instance spellCode of Code
	(properties)

	(method (doit spellNum)
		(if (OneOf spellNum 1 5 6)
			(return 1)
		else
			(HighPrint 490 67) ; "A magical force makes it impossible to cast spells here."
			(return 0)
		)
	)
)

