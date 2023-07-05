;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use n013)
(use n121)
(use Wat)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PChase)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use Rev)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	theMan 0
	poach 1
	shootist 2
	poachScript 3
)

(local
	[local0 9] = [-1 {Hodge} 19 0 0 0 0 0 0]
	[local9 9] = [-1 {Poacher} 6 0 0 0 0 0 0]
	[local18 9] = [-1 {Roger} 19 0 0 0 0 0 0]
	local27
	local28
	local29
	local30
	local31
	local32
	local33
	[local34 6] = [1008 0 1 2 3 0]
	[local40 11] = [1008 3 2 2 1 2 1 2 1 2 0]
	[local51 5] = [1008 11 1 2 0]
	[local56 4] = [1008 13 1 0]
	[local60 12] = [1008 14 1 2 1 2 1 2 2 3 2 0]
	[local72 12] = [1008 32 1 2 1 1 2 1 2 2 1 0]
	[local84 7] = [1008 41 1 2 1 2 0]
	[local91 4] = [1008 45 1 0]
	[local95 4] = [1008 31 1 0]
	[local99 4] = [1008 46 1 0]
	[local103 4] = [1008 47 1 0]
	[local107 4] = [1008 60 1 0]
	[local111 4] = [1008 49 1 0]
	[local115 5] = [1008 50 1 2 0]
	[local120 5] = [1008 52 2 1 0]
	[local125 4] = [1008 54 1 0]
	[local129 6] = [1008 24 2 1 2 0]
	[local135 4] = [1008 23 1 0]
	[local139 6] = [1008 55 2 1 3 0]
	[local145 5] = [1008 58 2 1 0]
	[local150 4] = [1008 27 1 0]
	[local154 6] = [1008 61 1 1 2 0]
	[local160 7] = [1008 64 2 1 3 2 0]
	[local167 4] = [1008 68 1 0]
	[local171 5] = [1008 69 2 1 0]
	[local176 9] = [1008 71 1 3 2 2 1 2 0]
	[local185 5] = [1008 84 1 2 0]
	[local190 5] = [1008 86 1 2 0]
	[local195 7] = [1008 88 1 2 2 2 0]
	[local202 4] = [1008 77 1 0]
	[local206 5] = [1008 78 1 2 0]
	[local211 9] = [1008 80 1 2 0 1008 48 1 0]
	[local220 11] = [1008 95 1 2 1 2 1 1 2 2 0]
	[local231 5] = [1008 103 1 1 0]
	[local236 8] = [1008 105 1 2 2 1 2 0]
)

(instance theMan of Actor
	(properties
		x 215
		y 60
		view 113
		loop 2
		cel 1
		signal 30720
	)

	(method (doit)
		(cond
			((or script (gEgo script:) (gCurRoom script:)))
			(
				(and
					(not (& (theMan signal:) $0020))
					(not local31)
					(gEgo mover:)
					(closePoly onMe: gEgo)
				)
				(= local31 1)
				(gEgo setScript: getBack)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(if (& (theMan signal:) $0020)
			((ScriptID 120 2) doVerb: theVerb &rest) ; theStreet
		else
			(switch theVerb
				(2 ; Look
					(Say 1008 28 1) ; "What a foul brute this man is. Just the sort the Sheriff prefers in his service."
				)
				(3 ; Do
					(HandsOff)
					(gEgo setMotion: PChase theMan 30)
				)
				(10 ; Longbow
					(gEgo setScript: flunkyKilled)
				)
				(5 ; Talk
					(cond
						((Wat offRoad:)
							(if local33
								(Converse 1 @local91 @local0 2) ; "What's it to be, outlaw? Death by my sword, death by hanging--or will you run off and hide in a hole somewhere?"
							else
								(= local33 1)
								(Converse 2 @local84 2 2 @local0 3) ; "I've stepped aside. The way is clear."
							)
						)
						((Wat charFirstTalk:)
							(Converse 1 @local91 @local0 2) ; "What's it to be, outlaw? Death by my sword, death by hanging--or will you run off and hide in a hole somewhere?"
						)
						(else
							(Wat charFirstTalk: 1)
							(Converse 3 @local72 2 2 @local0 3 @local9 2) ; "Release your prisoner."
						)
					)
				)
				(4 ; Inventory
					(switch invItem
						(0 ; bucks
							(if (Wat gaveManBucks:)
								(Say 1008 92 1) ; "I'll not waste my breath offering him money again."
								0
							else
								(Wat gaveManBucks: 1)
								(gEgo setScript: buckTalk)
							)
						)
						(2 ; halfHeart
							(if (Wat offeredEmerald:)
								(Say 1008 110 1) ; "I said he wouldn't see the stone again and he won't."
							else
								(Wat offeredEmerald: 1)
								(gEgo setScript: offerEmerald)
							)
						)
						(else
							(HandsOff)
							(gEgo setMotion: PChase theMan 30)
						)
					)
				)
			)
		)
	)
)

(instance poach of Actor
	(properties
		x 226
		y 68
		view 113
		cel 2
		signal 30720
	)

	(method (init)
		(gSFX number: 126 loop: -1 play:)
		(super init:)
	)

	(method (dispose)
		(gSFX fade: 0 30 8 1)
		(gTheIconBar enable: 0)
		(gCurRoom notify:)
		(self setCycle: 0 setMotion: 0)
		(if (not (& (theMan signal:) $0020))
			(theMan setCycle: 0 setMotion: 0 dispose:)
		)
		(if (gFeatures contains: closePoly)
			(closePoly dispose:)
		)
		(if (Wat whichChar:)
			(Wat weMeetAgain: (+ (Wat weMeetAgain:) 1))
		)
		(if (== (Wat poachStatus:) 3)
			(gEgo setScript: 0)
			(proc125_2)
			(User canControl: 1)
		)
		(super dispose:)
		(self delete:)
		(if (not (& (theMan signal:) $0020))
			(theMan delete:)
		else
			(gFeatures delete: theMan)
		)
		(gTheIconBar enable: 5)
		(if (!= (Wat poachStatus:) 2)
			(DisposeScript 8)
		)
	)

	(method (doVerb theVerb invItem)
		(if (& (poach signal:) $0020)
			((ScriptID 120 2) doVerb: theVerb &rest) ; theStreet
		else
			(switch theVerb
				(2 ; Look
					(if (== (Wat poachStatus:) 0)
						(Say 1008 29 1) ; "He's but a simple peasant, driven to hunt in the King's forest or watch his family starve."
					else
						(Say 1008 30 1) ; "The joy of deliverance in this man's face makes my life as an outlaw worthwhile."
					)
				)
				(3 ; Do
					(if (== (Wat poachStatus:) 0)
						(HandsOff)
						(gEgo setMotion: PChase theMan 30)
					else
						(Converse 1 @local95 @local9 3) ; "You've done more than enough for me already."
					)
				)
				(5 ; Talk
					(if (== (Wat poachStatus:) 0)
						(gEgo setScript: iTrustYou)
					else
						(Converse 1 @local107 @local9 3) ; "By the Virgin, I can't wait to tell my friends how I was rescued by Robin Hood!"
					)
				)
				(10 ; Longbow
					(if (!= (Wat poachStatus:) 2)
						(Say 1008 113 1) ; "I've no desire to kill this peasant."
					)
				)
				(4 ; Inventory
					(if (== (Wat poachStatus:) 3)
						(switch invItem
							(0 ; bucks
								(cond
									(local27
										(Say 1008 93) ; "I've no need to try that again."
									)
									((gMoney doit:)
										(= local27 1)
										(gEgo
											setScript: givePoacherBucks 0 0
										)
									)
									(else
										(super doVerb: theVerb &rest)
									)
								)
							)
							(2 ; halfHeart
								(if local28
									(Say 1008 93 1) ; "I've no need to try that again."
								else
									(= local28 1)
									(gEgo setScript: givePoacherBucks 0 2)
								)
							)
							(else
								(super doVerb: theVerb &rest)
							)
						)
					else
						(HandsOff)
						(gEgo setMotion: PChase theMan 30)
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance shootist of Prop
	(properties
		view 393
		cel 4
	)
)

(instance closePoly of Feature
	(properties)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 164 97 116 60 212 40 269 64 269 89
				yourself:
			)
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(cond
			(((ScriptID 120 3) onMe: self) ; eastSide
				((ScriptID 120 3) doVerb: theVerb) ; eastSide
			)
			(((ScriptID 120 4) onMe: self) ; westSide
				((ScriptID 120 4) doVerb: theVerb) ; westSide
			)
			(else
				((ScriptID 120 2) doVerb: theVerb) ; theStreet
			)
		)
	)
)

(instance poachScript of Script
	(properties)

	(method (dispose)
		(gTheIconBar disable: 5)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Wat setScript: 0)
				(closePoly init:)
				(gEgo actions: egoActions stopUpd:)
				(if (Wat weMeetAgain:)
					(client setScript: repeatEncounter)
				else
					(theMan init: setCycle: CT 6 1 self)
				)
			)
			(1
				(theMan cel: 7 stopUpd:)
				(poach
					init:
					setCycle: Walk
					setStep: 6 4
					setMotion: MoveTo 224 75 self
				)
				(= ticks 6)
			)
			(2
				(theMan
					view: 752
					loop: 1
					cel: 5
					x: 207
					y: 66
					setPri: 3
					forceUpd:
				)
			)
			(3
				(poach loop: 4 cel: 0 setStep: 3 2 posn: 205 74 stopUpd:)
				(= ticks 6)
			)
			(4
				(Converse 3 @local34 2 2 @local0 3 @local9 2 self) ; "Hold. I would know why this man is bound?"
			)
			(5
				(theMan cel: 0 forceUpd:)
				(= ticks 12)
			)
			(6
				(theMan cel: 1 forceUpd:)
				(poach cel: 1 forceUpd:)
				(= ticks 12)
			)
			(7
				(theMan setCycle: CT 5 -1 self)
				(poach cel: 0)
			)
			(8
				(Converse 2 @local40 2 2 @local0 3 self) ; "Shut up, you! Or I'll kill you now and save myself a lot of trouble."
			)
			(9
				(NormalEgo)
				(gEgo setMotion: 0 setScript: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance repeatEncounter of Script
	(properties)

	(method (dispose)
		(gTheIconBar disable: 5)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo actions: egoActions)
				(if (> (Wat weMeetAgain:) 1)
					(Converse 1 @local56 2 2 self) ; "Halt where you are or--"
				else
					(Converse 2 @local51 2 2 @local0 3 self) ; "I haven't finished with you."
				)
			)
			(2
				(if (> (Wat weMeetAgain:) 1)
					(client setScript: lastChance)
				else
					(NormalEgo)
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance lastChance of Script
	(properties)

	(method (dispose)
		(shootSound dispose:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(shootist setCycle: CT 2 1 self)
			)
			(1
				(shootSound number: 906 play:)
				(shootist setCycle: CT 4 1 self)
				(gEgo view: 792 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(shootSound number: 907 play:)
				(theMan view: 752 loop: 0 cel: 0)
				(= ticks 60)
			)
			(3)
			(4
				(Converse 3 @local60 @local18 2 @local0 3 @local9 2 self) ; "I got him! It's a good thing I came up the road to find you."
			)
			(5
				(gSFX stop:)
				(EgoDead)
			)
		)
	)
)

(instance getBack of Script
	(properties)

	(method (dispose)
		(gTheIconBar disable: 5)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(Face gEgo theMan self)
			)
			(1
				(if (== (++ local32) 3)
					(client setScript: poacherKilled)
				else
					(Converse 2 @local129 2 2 @local0 3 self) ; "Come any closer and I'll kill this man on the spot."
				)
			)
			(2
				(gEgo
					setLoop: (gEgo loop:)
					setCycle: Rev
					setMotion: MoveFwd -25 self
				)
			)
			(3
				(= local31 0)
				(NormalEgo)
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance getYerMen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (< gHowFast 1))
				(HandsOff)
				(LoadMany rsVIEW 151 152 160 161 154 155)
				(ScriptID 19) ; John
				(ScriptID 23) ; Tuck
				(ScriptID 20) ; Will
				(theMan stopUpd:)
				(poach stopUpd:)
				(self setScript: (ScriptID 5 1) self) ; blowinIt
			)
			(1
				(Wat blewHorn: 1)
				(Converse 1 @local167 @local0 3 self) ; "Did I not say you were a coward? You're so scared of me, you must call for help."
			)
			(2
				(DisposeScript 5)
				(gEgo setMotion: MoveTo 140 115 self)
			)
			(3
				(Face gEgo theMan self)
			)
			(4
				(= ticks 12)
			)
			(5
				(if register
					(gCurRoom drawPic: 803 -32759)
					(gCast eachElementDo: #hide)
					(= ticks 30)
				else
					(gEgo stopUpd:)
					(self setScript: (ScriptID 125 1) self) ; merryMenEntrance
				)
			)
			(6
				(if register
					((ScriptID 20) loop: 2 posn: 185 50 init: stopUpd:) ; Will
					((ScriptID 19) ; John
						loop: 0
						posn: 95 70
						setCycle: StopWalk 152
						init:
					)
					((ScriptID 23) loop: 1 posn: 240 125 init: stopUpd:) ; Tuck
					(gCast eachElementDo: #show)
					(gCurRoom drawPic: 120 -32759)
					(proc121_0)
					(= ticks 12)
				else
					(= ticks 30)
				)
			)
			(7
				(Face gEgo (ScriptID 19)) ; John
				((ScriptID 19) setMotion: PChase gEgo 40 self) ; John
			)
			(8
				(= ticks 30)
			)
			(9
				(Converse 2 @local171 3 2 13 3 self) ; "I see you've one of the Sheriff's churls at bay. And most unhappy he looks."
			)
			(10
				(Converse 3 @local176 1 2 13 3 @local0 2 self) ; "But he calls me a coward in sending for you."
			)
			(11
				(if register
					((ScriptID 19) dispose:) ; John
					((ScriptID 20) dispose:) ; Will
					((ScriptID 23) dispose:) ; Tuck
					(gCurRoom drawPic: 803 -32759)
					(gCast eachElementDo: #hide)
					(= ticks 30)
				else
					(gEgo stopUpd:)
					((ScriptID 19) ; John
						setMotion: PolyPath -25 (- ((ScriptID 19) y:) 15) self ; John
					)
					((ScriptID 20) ; Will
						setMotion: MoveTo 335 (- ((ScriptID 20) y:) 10) self ; Will
					)
					((ScriptID 23) ; Tuck
						setMotion: MoveTo 335 ((ScriptID 23) y:) self ; Tuck
					)
				)
			)
			(12
				(if register
					(gCast eachElementDo: #show)
					(gCurRoom drawPic: 120 -32759)
					(proc121_0)
					(= ticks 12)
				)
			)
			(13
				(= ticks 6)
			)
			(14
				(Face gEgo theMan self)
			)
			(15
				((ScriptID 19) dispose:) ; John
				((ScriptID 20) dispose:) ; Will
				((ScriptID 23) dispose:) ; Tuck
				(theMan startUpd:)
				(poach startUpd:)
				(= local30 1)
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance poacherKilled of Script
	(properties)

	(method (dispose)
		(screamSound dispose:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMan cycleSpeed: 12 setCycle: CT 1 1 self)
			)
			(1
				(theMan setCycle: CT 3 1 self)
				(poach cycleSpeed: 12 setCycle: CT 2 1)
			)
			(2
				(screamSound play:)
				(Converse 1 @local135 @local9 1 self) ; "Gunnhggh!"
			)
			(3
				(theMan setCycle: End)
				(poach setCycle: End self)
				(Wat poachStatus: 2)
			)
			(4
				(poach addToPic:)
				(SetScore -100)
				(Converse 1 @local150 2 2 self) ; "You gutless, murdering scoundrel!"
			)
			(5
				(client setScript: flunkyKilled)
			)
		)
	)
)

(instance flunkyKilled of Script
	(properties)

	(method (dispose)
		(shootSound dispose:)
		(if (& (poach signal:) $0020)
			(gSFX fade: 0 30 8 1)
		)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (gGame egoMoveSpeed:))
				(HandsOff)
				(Face gEgo theMan self)
			)
			(1
				(gGame setSpeed: (/ global141 2))
				(gEgo view: 4 cel: 0 setCycle: End self)
			)
			(2
				(gEgo view: 5 cel: 0 setCycle: End self)
				(theMan cel: 1)
			)
			(3
				(shootSound play:)
				(if (not (& (poach signal:) $0020))
					(poach view: 745 loop: 0 cel: 0)
				)
				(= ticks (/ (gEgo distanceTo: theMan) 4))
			)
			(4
				(gSFX stop:)
				(shootSound number: 907 play:)
				(gGame setSpeed: register)
				(theMan loop: 2 cel: 0 x: (+ (theMan x:) 3) setCycle: End self)
				(if (not (& (poach signal:) $0020))
					(poach setCycle: End)
				)
			)
			(5
				(theMan addToPic:)
				(NormalEgo)
				(= ticks 60)
			)
			(6
				(gSFX
					number: (if (== (Wat poachStatus:) 2) 127 else 128)
					loop: -1
					play:
				)
				(if (== (Wat poachStatus:) 2)
					(SetFlag 153)
					(self setScript: (ScriptID 5 1) self) ; blowinIt
				else
					(poach setCycle: Beg)
					(ClearFlag 153)
					(Wat poachStatus: 1)
					(client setScript: savedThePoacher)
				)
			)
			(7
				(gEgo setMotion: MoveTo 140 115 self)
			)
			(8
				(DisposeScript 5)
				(Face gEgo theMan self)
			)
			(9
				(= ticks 12)
			)
			(10
				(self setScript: (ScriptID 125 1) self) ; merryMenEntrance
			)
			(11
				(= local29 1)
				(Face gEgo (ScriptID 19) self) ; John
			)
			(12
				(= ticks 12)
			)
			(13
				(Converse 3 @local139 2 0 13 2 14 3 self) ; "What happened, Robin?"
			)
			(14
				(Converse 2 @local145 1 0 13 2 self) ; "We'll see to the bodies, Robin. At least the man's death has been repaid in kind."
			)
			(15
				(= ticks 60)
			)
			(16
				(gCurRoom drawPic: 803 -32761)
				(gEgo loop: 4 cel: 0 posn: 160 95)
				(gEgoHead cel: 7 posn: 120 125)
				(NormalEgo)
				(gCast eachElementDo: #hide)
				(= ticks 120)
			)
			(17
				(if (IsFlag 48)
					(SetIcon 0)
					(self dispose:)
					(gCurRoom newRoom: 160)
				else
					((ScriptID 19) dispose:) ; John
					((ScriptID 23) dispose:) ; Tuck
					((ScriptID 20) dispose:) ; Will
					(= local30 1)
					(gCast eachElementDo: #show)
					(gCurRoom drawPic: 120 -32761)
					(proc121_0)
					(= ticks 12)
				)
			)
			(18
				(proc125_2)
				(HandsOn)
				(SetIcon 0)
				(self dispose:)
				(poach dispose:)
			)
		)
	)
)

(instance savedThePoacher of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (gGame egoMoveSpeed:))
				(Converse 1 @local111 @local9 3 self) ; "By the Virgin, that was masterly shooting!"
			)
			(1
				(gEgo setMotion: MoveTo (poach x:) (+ (poach y:) 4) self)
			)
			(2
				(gEgo setHeading: 90 self)
			)
			(3
				(gEgo view: 7 loop: 6 cel: 0 cycleSpeed: 18 setCycle: Fwd)
				(= ticks 60)
			)
			(4
				(Converse 2 @local115 3 2 @local9 3 self) ; "Hold still, fellow. I'll have you untied in a thrice."
				(SetScore 100)
			)
			(5
				(gGame setSpeed: register)
				(NormalEgo)
				(poach view: 113 loop: 1 x: (+ (poach x:) 19))
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 45) (gEgo y:) self
				)
			)
			(6
				(Face gEgo poach self)
			)
			(7
				(Converse 2 @local120 1 2 @local9 3 self) ; "I thank you heartily. Is it safe to return for my deer?"
			)
			(8
				(poach stopUpd:)
				(gEgo setMotion: MoveTo 140 115 self)
			)
			(9
				(self setScript: (ScriptID 5 1) self) ; blowinIt
			)
			(10
				(= ticks 12)
			)
			(11
				(DisposeScript 5)
				(gEgo stopUpd:)
				(self setScript: (ScriptID 125 1) self) ; merryMenEntrance
			)
			(12
				(= local29 1)
				(gEgo setMotion: 0)
				(Face gEgo (ScriptID 20) self) ; Will
			)
			(13
				(= cycles 5)
			)
			(14
				(Converse 2 @local154 3 2 13 3 self) ; "Lads, this fellow's had a lucky day, saved from a poacher's fate."
			)
			(15
				(Converse 3 @local160 1 2 13 3 15 2 self) ; "But what of this other carrion?"
			)
			(16
				(= ticks 60)
			)
			(17
				(gAddToPics eachElementDo: #dispose release:)
				(gCurRoom drawPic: 803 -32761)
				(poach view: 113 posn: 190 105)
				(gEgo loop: 4 cel: 0 posn: 160 95)
				(gEgoHead cel: 7 posn: 120 125)
				(NormalEgo)
				(gCast eachElementDo: #hide)
				(= ticks 120)
			)
			(18
				(closePoly dispose:)
				((ScriptID 19) dispose:) ; John
				((ScriptID 23) dispose:) ; Tuck
				((ScriptID 20) dispose:) ; Will
				(= local30 1)
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 120 -32761)
				(proc121_0)
				(= ticks 12)
			)
			(19
				(Converse 1 @local125 @local9 3 self) ; "Thank you again. I can't wait to tell my wife!"
			)
			(20
				(Wat poachStatus: 3)
				(SetFlag 174)
				(poach setLoop: 3 setCycle: Walk setMotion: MoveTo 20 240 self)
				(HandsOn)
				(SetIcon 1)
				(User canControl: 0)
				(gTheIconBar disable: 0 5)
			)
			(21
				(User canControl: 1)
				(gTheIconBar enable:)
				(if (IsFlag 48)
					(SetIcon 0)
					(self dispose:)
					(gCurRoom newRoom: 160)
				else
					(HandsOff)
					(if (gCurRoom script:)
						(gCurRoom setScript: 0)
					)
					(Say 1008 112 self) ; "He's broken into a run and plunges into the forest, no doubt to take a shortcut home."
				)
			)
			(22
				(HandsOn)
				(proc125_2)
				(self dispose:)
				(SetIcon 0)
				(poach dispose:)
			)
		)
	)
)

(instance offerEmerald of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 130 100 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo
					view: 7
					loop: 4
					cel: 0
					cycleSpeed: 12
					setCycle: CT 4 1 self
				)
			)
			(3
				(Converse 2 @local220 1 2 @local0 3 self 0) ; "Can you see this? It is an emerald."
			)
			(4
				(Converse 1 @local231 2 2 self 1) ; "Your arrogance is unbounded."
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(NormalEgo 6)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance buckTalk of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Converse 2 @local185 1 2 @local0 3 self) ; "How much silver will it take to buy this man's freedom?"
			)
			(1
				(Converse 2 @local190 3 2 @local0 3 self) ; "And what is the Wolf's Head upon me these days?"
			)
			(2
				(Converse 2 @local195 1 2 @local0 3 self) ; "That's a fair bit of gold, but I can match the offer."
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance givePoacherBucks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 7)
				(poach setLoop: 1 setMotion: 0)
				(HandsOff)
				(Converse 1 @local202 3 0 self) ; "One more thing."
			)
			(1
				(if (!= register 2)
					(SetScore 50)
				)
				(gEgo
					setMotion: MoveTo (- (poach x:) 22) (+ (poach y:) 3) self
				)
			)
			(2
				(gEgo setHeading: 135 self)
			)
			(3
				(gGame setSpeed: global141)
				(gEgo view: 7 loop: 4 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(if (== register 2)
					(Converse 2 @local236 1 0 @local9 1 self) ; "I wonder if this emerald would aid you."
				else
					(Converse 2 @local206 3 0 @local9 1 self) ; "Take this money to forestall another trip into the forest."
				)
			)
			(5
				(Converse 2 @local211 1 0 @local9 1 self) ; "I'll do what I can to change that."
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(NormalEgo)
				(gGame setSpeed: global157)
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 25) (gEgo y:) self
				)
			)
			(8
				(poach setLoop: 3 setMotion: MoveTo 20 240 self)
				(if (> (gEgo y:) 188)
					(gEgo setMotion: MoveTo (+ (gEgo x:) 20) 178 self)
				else
					(self cue:)
				)
				(HandsOn)
				(User canControl: 0)
				(gTheIconBar disable: 0 5)
				(SetIcon 1)
			)
			(9
				(gEgo setHeading: 225)
			)
			(10
				(Say 1008 112 self) ; "He's broken into a run and plunges into the forest, no doubt to take a shortcut home."
			)
			(11
				(self dispose:)
				(if (IsFlag 48)
					(gCurRoom newRoom: 160)
				else
					(HandsOn)
					(SetIcon 0)
					(poach dispose:)
				)
			)
		)
	)
)

(instance iTrustYou of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse 1 @local99 @local9 3 self) ; "I trust you, Robin Hood. Do what you must."
			)
			(1
				(theMan cel: 0)
				(= ticks 12)
			)
			(2
				(theMan cel: 1)
				(poach cel: 1)
				(= ticks 12)
			)
			(3
				(theMan setCycle: CT 5 -1 self)
				(poach cel: 0)
			)
			(4
				(Converse 1 @local103 @local0 3 self) ; "Shut up!"
			)
			(5
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance egoActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(and
				(== theVerb 4) ; Inventory
				(== invItem 1) ; horn
				(cond
					((or local30 (Wat blewHorn:))
						(switch (Wat poachStatus:)
							(0
								(Say 1008 82 1) ; "I need no help from my men to deal with this base cur."
								1
							)
							(else
								(Say 1008 83 1) ; "My men are busy with the burial. I'll not disturb them."
								1
							)
						)
					)
					((== (Wat poachStatus:) 1)
						(Say 1008 94 1) ; "My men are busy elsewhere."
					)
					((and (not local29) (== (Wat poachStatus:) 0))
						(gEgo setScript: getYerMen)
					)
				)
			)
		)
	)
)

(instance shootSound of Sound
	(properties
		flags 1
		number 906
	)
)

(instance screamSound of Sound
	(properties
		flags 1
		number 932
	)
)

