;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use OccasionalCycle)
(use eRS)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Door)
(use ForwardCounter)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm220 0
)

(local
	local0
	local1
	local2
	local3 = 20
	local4 = 1
	local5 = 1
)

(instance rm220 of FPRoom
	(properties
		noun 39
		picture 220
		horizon 40
		north 300
		east 230
		south 400
		west 210
	)

	(method (init)
		(if (IsFlag 59)
			(self setRegions: 90) ; streetRgn
		)
		(if (== gCurPuzzle 22)
			(self setRegions: 91) ; rowdyRgn
		)
		(gEgo init: setScale: Scaler 100 50 175 95 normalize:)
		(switch gPrevRoomNum
			(west
				(if (< (gEgo y:) 109)
					(gEgo y: 109)
				)
				(= style 12)
				(gGame handsOn:)
			)
			(east
				(= style 11)
				(gGame handsOn:)
			)
			(235
				(= style 11)
				(gGame handsOn:)
			)
			(north
				(= style 100)
				(gEgo x: 285 y: 46)
			)
			(south
				(= style 100)
				(gEgo x: 250)
				(gGame handsOn:)
			)
			(550
				(= style 10)
				(gEgo x: 280 y: 160)
				(self setScript: sAfterLeverBros)
			)
			(680
				(gGame handsOn:)
			)
			(690
				(gEgo edgeHit: 0)
				(= style 100)
			)
			(else
				(= style 100)
				(gEgo x: 160 y: 160)
				(gGame handsOn:)
			)
		)
		(if (and (!= gCurPuzzle 22) (< gCurPuzzle 23) (not (IsFlag 1)))
			(cond
				((> gAct 1)
					(gGameMusic1 number: 690 flags: 1 loop: -1 play: setVol: 80)
				)
				((and (!= gCurPuzzle 24) (!= gCurPuzzle 14))
					(gGameMusic1 number: 221 flags: 1 loop: -1 play:)
				)
			)
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 141 10 142 37 167 207 167 211 189 0 189
					yourself:
				)
		)
		(if (< gCurPuzzle 6)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 119 312 119 305 94 295 94 290 67 303 67 286 3 267 3 277 29 272 48 232 48 214 100 198 100 198 84 160 84 161 88 194 88 194 111 78 111 66 98 50 106 0 109
						yourself:
					)
			)
			(horse
				init:
				approachVerbs: 2 ; Talk
				setCycle: OccasionalCycle 1 45 200 2 8
			)
			(smithy
				init:
				approachVerbs: 4 2 1 ; Do, Talk, Look
				setScale: -1 gEgo
				setScript: sMakeHorseshoe
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 119 312 119 305 94 295 94 290 67 303 67 286 3 267 3 277 29 272 48 232 48 214 100 198 100 198 84 160 84 161 88 194 88 194 111 78 111 82 92 7 89 7 95 53 96 50 106 0 109
						yourself:
					)
			)
			(if
				(and
					(not (gEgo has: 48)) ; Rope
					(not (gEgo has: 29)) ; Lasso
					(not (IsFlag 22))
					(< gCurPuzzle 14)
				)
				(rope init: stopUpd: approachVerbs: 4) ; Do
			)
			(if (and (not (gEgo has: 30)) (not (IsFlag 56))) ; Leather_Strap
				(strap init: stopUpd: approachVerbs: 4) ; Do
			)
		)
		(if (== gAct 1)
			(coals init: approachVerbs: 4 setCycle: Fwd setPri: 7) ; Do
		)
		(if (and (not (IsFlag 53)) (== global141 gCurRoomNum) (== gAct 3))
			(horsePlop init: approachVerbs: 4) ; Do
			(gCurRoom
				addObstacle:
					(= local0
						((Polygon new:)
							type: PBarredAccess
							init: 131 126 131 135 97 135 97 126
							yourself:
						)
					)
			)
		)
		(if (and (>= gCurPuzzle 8) (<= gCurPuzzle 9))
			(horse1
				init:
				cycleSpeed: 10
				setCycle: OccasionalCycle 1 30 120 1 4
				setScript: sHorseStuff
				approachVerbs: 65 ; Paper_Sack
			)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 82 114 188 114 188 125 171 125 171 144 136 144 136 125 82 125
						yourself:
					)
			)
			(LoadMany rsSOUND 2116)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 82 114 188 114 188 125 82 125
						yourself:
					)
			)
		)
		(bulletHole init:)
		(sidewalk init: setOnMeCheck: 1 8192)
		(hay init: setOnMeCheck: 1 16384)
		(anvilFtr init: approachVerbs: 4 setOnMeCheck: 1 1024) ; Do
		(bankDoor init:)
		(if (and (!= gCurPuzzle 23) (!= gCurPuzzle 24))
			(rugMan init: hide: setPri: 0 setScript: sRandomShaker)
		)
		(wagon init: approachVerbs: 4 3 setOnMeCheck: 1 4096) ; Do, ???
		(firepit init: approachVerbs: 4 setOnMeCheck: 1 2048) ; Do
		(smithyDoor init:)
		(blacksmith init: approachVerbs: 4 setOnMeCheck: 1 4) ; Do
		(fence init: approachVerbs: 4 setOnMeCheck: 1 128) ; Do
		(saddle init: approachVerbs: 4 setOnMeCheck: 1 16) ; Do
		(corral init: approachVerbs: 4 setOnMeCheck: 1 8) ; Do
		(balanceStreet init: setOnMeCheck: 1 512)
		(bank init: approachVerbs: 4 setOnMeCheck: 1 2) ; Do
		(mainStreet init: setOnMeCheck: 1 256)
		(trough init: approachVerbs: 4 setOnMeCheck: 1 32) ; Do
		(rail init: approachVerbs: 4 setOnMeCheck: 1 64) ; Do
		(if (== gCurPuzzle 23)
			(lever4 stopUpd: init:)
			(self setScript: sBadBros)
		)
		(if (IsFlag 52)
			(dummyCredits init: setScript: (ScriptID 32 0)) ; sOpeningCredits
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(super doit:)
		(if
			(and
				(== gAct 1)
				(== (mod (gGameMusic1 number:) 1000) 221)
				(not (-- local3))
			)
			(cond
				((< (= temp0 (GetDistance (gEgo x:) (gEgo y:) 46 94)) 0)
					(= temp0 0)
				)
				((> temp0 300)
					(= temp0 300)
				)
			)
			(= temp2 (- 80 (/ temp0 4)))
			(gGameMusic1
				send: 2 7 temp2
				send: 4 7 temp2
				send: 5 7 temp2
				send: 6 7 temp2
				send: 9 7 temp2
				send: 15 7 temp2
			)
			(cond
				((< (= temp1 (GetDistance (gEgo x:) (gEgo y:) 205 97)) 0)
					(= temp1 0)
				)
				((> temp1 300)
					(= temp1 300)
				)
			)
			(= temp3 (- 80 (/ temp1 4)))
			(gGameMusic1 send: 7 7 temp3 send: 10 7 temp3 send: 14 7 temp3)
			(= local1 (Max temp2 temp3))
			(gGameMusic1 send: 3 7 local1 send: 11 7 local1 send: 13 7 local1)
			(= local3 20)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (== newRoomNumber 230) (OneOf gCurPuzzle 8 9 20 22))
			(= newRoomNumber 235)
		)
		(if (and (!= newRoomNumber 690) (!= gCurPuzzle 24) (!= gCurPuzzle 14))
			(gGameMusic1 fade: 0 30 12 1)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(DisposeScript 32)
		(super dispose:)
	)
)

(instance sHorseStuff of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local4 (== (horse1 loop:) 3) (== (horse1 cel:) 4))
			(= local4 0)
			(horseSound number: 2116 play: horse1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (Random 0 3)
					(0
						(client setLoop: 0)
					)
					(1
						(client setLoop: 1)
					)
					(2
						(client setLoop: 3)
					)
					(3
						(client setLoop: 2)
					)
				)
				(client setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(if (and (== (Random 5 10) 8) (!= (client loop:) 3))
					(horseSound number: 2114 play: horse1)
				)
				(= seconds (Random 3 10))
			)
			(2
				(client setCycle: End self)
				(self changeState: 0)
			)
		)
	)
)

(instance sMakeHorseshoe of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (not local5) (!= (smithy cel:) 0))
				(= local5 1)
			)
			((and local5 (== (smithy cel:) 0))
				(smithieSound number: 2225 play:)
				(= local5 0)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: 0 setCycle: Fwd)
				(= seconds (Random 2 15))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(= ticks 90)
			)
			(4
				(client setCycle: Beg self)
			)
			(5
				(self changeState: 0)
			)
		)
	)
)

(instance sRandomShaker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 100))
			)
			(1
				(shakeSound play:)
				(client show: setLoop: 1 cel: 0 setCycle: ForwardCounter 5 self)
			)
			(2
				(shakeSound stop:)
				(client setLoop: 0 cel: (client lastCel:) setCycle: Beg self)
			)
			(3
				(client cel: 0 hide:)
				(self changeState: 0)
			)
		)
	)
)

(instance sBadBros of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc0_9 550)
				(gGameMusic1 number: 144 loop: -1 play:)
				(gGameMusic2 number: 234 loop: 1 play:)
				(= local2 (gEgo moveSpeed:))
				(gEgo setSpeed: 7 setMotion: PolyPath 248 174 self)
			)
			(1
				(= seconds 5)
			)
			(2
				(lever4 setMotion: PolyPath 275 139 self)
			)
			(3
				(lever4 setCycle: 0 view: 223 setLoop: 0 setCel: 0 stopUpd:)
				(UnLoad 128 820)
				(lever1 stopUpd: init:)
				(= seconds 8)
			)
			(4
				(gEgo setHeading: 180 self)
			)
			(5
				(= cycles 2)
			)
			(6
				(gMessager say: 41 0 0 0 self) ; "Hey, knock off the sound effects already!"
			)
			(7
				(gEgo setHeading: 0)
				(gGameMusic2 stop:)
				(= seconds 3)
			)
			(8
				(gMessager say: 24 0 0 1 self) ; "What's that rotten smell? Oh, no! It can't be! You recognize that smell from your old days as a lawman... More dangerous than Jesse James... Meaner than Johnny Ringo... Deadlier than William Muny... (More fun at cocktail parties than Rooster Cogburn!) ...it's the legendary Lever Brothers!"
			)
			(9
				(= seconds 3)
			)
			(10
				(gMessager say: 24 0 0 2 self) ; "Dummy msg."
			)
			(11
				(gEgo heading: 355 setHeading: 270 self)
			)
			(12
				(= cycles 2)
			)
			(13
				(lever1 setMotion: PolyPath 77 154 self)
			)
			(14
				(gMessager say: 24 0 0 3 self) ; "Dummy msg."
			)
			(15
				(lever1 setMotion: PolyPath 195 175 self)
			)
			(16
				(= cycles 2)
			)
			(17
				(lever1 setCycle: 0 view: 223 setLoop: 1 setCel: 0 stopUpd:)
				(UnLoad 128 817)
				(= cycles 3)
			)
			(18
				(gMessager say: 24 0 0 4 self) ; "Dummy msg."
			)
			(19
				(lever3 stopUpd: init:)
				(= seconds 3)
			)
			(20
				(gMessager say: 24 0 0 5 self) ; "Dummy msg."
			)
			(21
				(gEgo setHeading: 90 self)
			)
			(22
				(= cycles 2)
			)
			(23
				(lever3 setMotion: PolyPath 300 174 self)
			)
			(24
				(= cycles 2)
			)
			(25
				(lever3 setCycle: 0 view: 223 setLoop: 2 setCel: 0 stopUpd:)
				(UnLoad 128 819)
				(= cycles 3)
			)
			(26
				(gMessager say: 24 0 0 6 self) ; "Dummy msg."
			)
			(27
				(lever2 stopUpd: init:)
				(= seconds 3)
			)
			(28
				(gMessager say: 24 0 0 7 self) ; "Dummy msg."
			)
			(29
				(gEgo setHeading: 180 self)
			)
			(30
				(= cycles 2)
			)
			(31
				(lever2 setMotion: PolyPath 220 182 self)
			)
			(32
				(lever2 setLoop: 3 setCel: 3)
				(= cycles 2)
			)
			(33
				(lever2 setCycle: 0 view: 223 setLoop: 3 setCel: 0 stopUpd:)
				(UnLoad 128 818)
				(= cycles 3)
			)
			(34
				(gMessager say: 24 0 0 8 12 self) ; "Dummy msg."
			)
			(35
				(gEgo setSpeed: local2)
				(gCurRoom newRoom: 550)
				(self dispose:)
			)
		)
	)
)

(instance sAfterLeverBros of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 30 0 0 1 self) ; "With his refurbished shootin' skills, Freddy wuz able to blast the Lever Brothers to smithereens! Now, with those varmints outta the way, Freddy'd figured that wuz the end of the story... that somehow the Lever Brothers wuz responsible for ever'thang that'd bin goin' on in town."
			)
			(2
				(gMessager say: 30 0 0 2 self) ; "But Freddy wuz WRONG! The Lever Brothers had been hired fer the task of gittin' rid of Freddy, by whomever'd hired the cowhands... and whomever wuz in cahoots with Sheriff Shift and P.H. Balance! And no sooner had Freddy's guns stopped smokin', than he heard a familiar twang and a few chords o' someone's theme music."
			)
			(3
				(gGameMusic1 number: 724 loop: 1 play:)
				(= seconds 3)
			)
			(4
				(gMessager say: 30 0 0 3 self) ; "What was that? Could it be? Nah. What would he be doing way out here, in the middle of nowhere? You haven't heard that chord in years, and yet, here it is again, strangely recognizable after all this time.... In your heart, you know it must be him. And, yet..."
			)
			(5
				(gEgo setHeading: 270 self)
			)
			(6
				(= cycles 2)
			)
			(7
				(kenny
					init:
					setScale: -1 gEgo
					setCycle: StopWalk -1
					setStep: 6 3
					setSpeed: 10
					setMotion: MoveTo 60 160 self
				)
			)
			(8
				(kenny stopUpd:)
				(= cycles 3)
			)
			(9
				(gMessager say: 30 0 0 4 5 self) ; "How did he find you? Will he be fooled by your disguise? Does he still eat paste?"
			)
			(10
				(gCurRoom newRoom: 560)
				(self dispose:)
			)
		)
	)
)

(instance sEndPuz of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(gTimers delete: (ScriptID 0 13) (ScriptID 0 14)) ; deathTimer, gasMaskTimer
				(= cycles 1)
			)
			(1
				(gCast eachElementDo: #dispose)
				(gCurRoom style: 100 drawPic: 780)
				(gGame points: 20 152 self)
				(gEgo put: 21 put: 13 put: 20) ; Gas_Mask, Deflatulizer, Filled_Sack
			)
			(2
				(gMessager say: 1 29 0 0 self 18) ; "You carefully pour the Deflatulizer into the horse's water trough. The horses greedily lap up the dee-lish- and nu-trish- medicated trough water."
			)
			(3
				(= gCurPuzzle 10)
				(gCurRoom newRoom: 250)
				((ScriptID 0 13) setReal: (ScriptID 0 13) 0 15) ; deathTimer, deathTimer
				(self dispose:)
			)
		)
	)
)

(instance horse1 of Prop
	(properties
		x 147
		y 127
		noun 1
		approachX 153
		approachY 151
		view 115
		loop 2
		priority 8
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; Paper_Sack
				(cond
					((== gCurPuzzle 8)
						(gMessager say: noun 0 4 0 0 18) ; "Whew-ee! You can't. The aroma is simply too overpowering. You don't dare touch the horse without some way to protect yourself from the stench."
					)
					((and (== (self loop:) 3) (not (gEgo has: 20))) ; Filled_Sack
						(gCurRoom setScript: sDoBag)
					)
					(else
						(gMessager say: noun 65 2 0 0 18) ; "A really terrifically disgusting idea! Unfortunately, the horse's tail momentarily blocks your access."
					)
				)
			)
			(64 ; Filled_Sack
				(gMessager say: noun 64 0 0 0 18) ; "(SCOTTY LIKE) She can't take any more, Cap'n! I'm afraid she's gonna BLOW!"
			)
			(1 ; Look
				(if (== (self loop:) 3)
					(gMessager say: noun 1 1 0 0 18) ; "The horse's tail is fluttering in the breeze! (And what a breeze that is!)"
				else
					(gMessager say: noun 1 0 0 0 18) ; "Somebody's poor horse seems to be dispelling huge quantities of a noxious methane compound."
				)
			)
			(4 ; Do
				(gMessager say: noun 4 0 0 0 18) ; "Nice horsey! (You'd BETTER be nice to this horsey. It has the power to cloud men's minds!)"
			)
			(29 ; Deflatulizer
				(gCurRoom setScript: sEndPuz)
			)
			(else
				(gMessager say: noun theVerb 0 0 0 18)
			)
		)
	)

	(method (cue)
		(super cue:)
		(= local4 1)
	)
)

(instance sDoBag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 41) ; Paper_Sack
				(gEgo get: -1 20) ; Filled_Sack
				(if (IsFlag 151)
					(= cycles 1)
				else
					(gGame points: 6 151 self)
				)
			)
			(1
				(gMessager say: 1 65 0 0 0 18) ; "In what may well be the most revolting idea you've ever had, you hold the brown paper sack up to the horse's anal sphincter and wait. With a reverberating "bbbrrraaatt," the horse reponds, inflating your bag a foul sample of "gas." You quickly twist the bag shut to lock in freshness."
				(self dispose:)
			)
		)
	)
)

(instance horsePlop of Prop
	(properties
		x 114
		y 129
		noun 40
		approachX 105
		approachY 135
		view 129
		loop 2
		signal 16384
		cycleSpeed 10
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetPlop)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance sGetPlop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 128)
					(= cycles 1)
				else
					(gGame points: 1 128 self)
				)
			)
			(1
				(gEgo get: 23 horsePlop) ; Horse_Plop
				(SetFlag 53)
				((gCurRoom obstacles:) delete: local0)
				(local0 dispose:)
				(horsePlop dispose:)
				(self dispose:)
			)
		)
	)
)

(instance rugMan of Prop
	(properties
		x 225
		y 53
		z 30
		noun 38
		view 222
		detailLevel 2
	)
)

(instance smithy of Prop
	(properties
		x 43
		y 97
		noun 14
		approachX 52
		approachY 102
		view 221
		cycleSpeed 12
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(83 ; Incorrect_Med2
				(gMessager say: noun 11) ; "Whut the Sam Hill y'expeck me to do with that medicine, Pharkas? I'm a strong, beefy kinda guy, I don't need no wuss medication!"
			)
			(13 ; Med_2
				(gMessager say: noun 11) ; "Whut the Sam Hill y'expeck me to do with that medicine, Pharkas? I'm a strong, beefy kinda guy, I don't need no wuss medication!"
			)
			(18 ; Med_3
				(gMessager say: noun 11) ; "Whut the Sam Hill y'expeck me to do with that medicine, Pharkas? I'm a strong, beefy kinda guy, I don't need no wuss medication!"
			)
			(12 ; Helen_s_Rx
				(gMessager say: noun 10) ; "I don' know nuttin' 'bout writin', Pharkas. That's more in your depar'ment."
			)
			(14 ; Madame_s_Rx
				(gMessager say: noun 10) ; "I don' know nuttin' 'bout writin', Pharkas. That's more in your depar'ment."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(super cue:)
		(= local5 1)
	)
)

(instance coals of Prop
	(properties
		y 95
		noun 29
		approachX 1
		approachY 93
		view 220
		loop 2
		signal 16384
		detailLevel 2
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 (if (== gAct 1) 1 else 2))
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb temp0)
			)
			(4 ; Do
				(gMessager say: noun theVerb temp0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance kenny of Actor
	(properties
		x -10
		y 160
		yStep 3
		view 810
		xStep 6
	)
)

(instance lever1 of Actor
	(properties
		x -10
		y 154
		view 817
		scaleSignal 4
	)

	(method (init)
		(super init:)
		(self setScale: Scaler 100 50 175 95 setCycle: StopWalk -1 setStep: 6 3)
	)
)

(instance lever2 of Actor
	(properties
		x 110
		y 220
		view 818
		scaleSignal 4
	)

	(method (init)
		(super init:)
		(self setScale: Scaler 100 50 175 95 setCycle: StopWalk -1 setStep: 6 3)
	)
)

(instance lever3 of Actor
	(properties
		x 330
		y 154
		view 819
		scaleSignal 4
	)

	(method (init)
		(super init:)
		(self setScale: Scaler 100 50 175 95 setCycle: StopWalk -1 setStep: 6 3)
	)
)

(instance lever4 of Actor
	(properties
		x 259
		y 68
		view 820
		scaleSignal 4
	)

	(method (init)
		(super init:)
		(self setScale: Scaler 100 50 175 95 setCycle: StopWalk -1 setStep: 6 1)
	)
)

(instance horse of Prop
	(properties
		x 45
		y 55
		noun 34
		approachX 44
		approachY 113
		view 220
		loop 6
		cycleSpeed 30
		detailLevel 2
	)
)

(instance dummyCredits of Prop
	(properties
		x -10
		y -10
		view 996
	)
)

(instance rope of View
	(properties
		x 4
		y 90
		z 41
		noun 27
		approachX 21
		approachY 93
		view 220
		loop 4
		priority 5
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetRope)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sGetRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 1 0 self)
			)
			(1
				(gEgo get: 48 rope 3 rope) ; Rope
				(self dispose:)
			)
		)
	)
)

(instance strap of View
	(properties
		x 19
		y 91
		z 40
		noun 33
		approachX 21
		approachY 93
		view 220
		loop 3
		priority 5
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetStrap)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sGetStrap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 1 0 self)
			)
			(1
				(gEgo get: 30 strap 3 strap) ; Leather_Strap
				(self dispose:)
			)
		)
	)
)

(instance smithyDoor of View
	(properties
		x 30
		y 86
		noun 28
		view 220
		loop 1
	)

	(method (init)
		(= cel (if (< gCurPuzzle 6) 0 else 1))
		(super init:)
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 (if (== gAct 1) 1 else 2))
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb temp0)
			)
			(4 ; Do
				(gMessager say: noun theVerb temp0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bulletHole of Feature
	(properties
		x 161
		y 80
		noun 25
		nsTop 77
		nsLeft 160
		nsBottom 83
		nsRight 163
		sightAngle 40
		approachX 161
		approachY 80
	)
)

(instance sidewalk of Feature
	(properties
		x 161
		y 80
		noun 32
		sightAngle 40
		approachX 161
		approachY 80
	)
)

(instance hay of Feature
	(properties
		x 161
		y 80
		noun 37
		sightAngle 40
		approachX 161
		approachY 80
	)
)

(instance wagon of Feature
	(properties
		x 256
		y 45
		noun 31
		approachX 254
		approachY 53
	)
)

(instance anvilFtr of Feature
	(properties
		x 7
		y 95
		noun 36
	)
)

(instance firepit of Feature
	(properties
		x 7
		y 95
		noun 29
		approachX 6
		approachY 93
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 (if (== gAct 1) 1 else 2))
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb temp0)
			)
			(4 ; Do
				(if (or (gEgo has: 5) (IsFlag 17)) ; Charcoal
					(gMessager say: noun theVerb 3) ; "You've already taken the really great charcoal hunks."
				else
					(gMessager say: noun theVerb temp0)
					(if (== temp0 2)
						(gCurRoom setScript: sGetCharcoal)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sGetCharcoal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 1 0 self)
			)
			(1
				(gMessager say: 29 4 2) ; "Digging through Smithie's formerly white-hot forge, you find an unused hunk of charcoal which you decide may well be of use to you. So you keep it."
				(gEgo get: -1 5) ; Charcoal
				(self dispose:)
			)
		)
	)
)

(instance blacksmith of Feature
	(properties
		x 50
		y 46
		noun 26
		sightAngle 40
		approachX 53
		approachY 102
		approachDist 63
	)

	(method (doVerb theVerb &tmp temp0)
		(= temp0 (if (< gCurPuzzle 6) 1 else 2))
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb temp0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fence of Feature
	(properties
		x 97
		y 161
		noun 21
		sightAngle 40
		approachX 72
		approachY 151
		approachDist 34
	)
)

(instance saddle of Feature
	(properties
		x 97
		y 161
		noun 18
		sightAngle 40
		approachX 72
		approachY 151
		approachDist 34
	)
)

(instance corral of Feature
	(properties
		x 97
		y 161
		noun 17
		sightAngle 40
		approachX 72
		approachY 151
		approachDist 34
	)
)

(instance balanceStreet of Feature
	(properties
		x 269
		y 74
		noun 22
		sightAngle 40
	)
)

(instance bank of Feature
	(properties
		x 153
		y 52
		noun 16
		sightAngle 40
		approachX 177
		approachY 112
		approachDist 69
	)
)

(instance mainStreet of Feature
	(properties
		x 97
		y 61
		noun 23
		sightAngle 40
	)
)

(instance trough of Feature
	(properties
		x 100
		y 125
		noun 19
		sightAngle 40
		approachX 129
		approachY 135
		approachDist 36
	)
)

(instance rail of Feature
	(properties
		x 143
		y 117
		noun 20
		sightAngle 40
		approachX 167
		approachY 120
		approachDist 32
	)
)

(instance bankDoor of Door
	(properties
		x 190
		y 93
		noun 16
		approachX 204
		approachY 100
		view 220
		cel 2
		entranceTo 690
		openSnd 2146
		closeSnd 2147
		openVerb 4
		moveToX 171
		moveToY 84
		enterType 0
		exitType 0
	)

	(method (init)
		(super init:)
		(= locked (if (and (< gCurPuzzle 20) (not (IsFlag 1))) 0 else 1))
		(= lockedCase (if (IsFlag 1) 4 else 5))
	)
)

(instance horseSound of FPSound
	(properties
		flags 1
	)
)

(instance smithieSound of FPSound
	(properties
		flags 1
	)
)

(instance shakeSound of FPSound
	(properties
		flags 1
		number 2222
		loop -1
	)
)

