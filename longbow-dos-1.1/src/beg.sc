;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
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
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	beg 0
	begScript 1
)

(local
	[local0 9] = [131 0 2 4 26 42 23 27 14]
	[local9 9] = [-1 {The Beggar} 14 0 0 0 0 0 0]
	local18 = 10
	local19
	local20
	local21
	local22
	local23
	[local24 13] = [1025 0 1 2 2 1 2 1 2 1 2 2 0]
	[local37 4] = [1025 10 1 0]
	[local41 6] = [1025 11 1 2 2 0]
	[local47 4] = [1025 14 1 0]
	[local51 8] = [1025 16 1 2 2 1 2 0]
	[local59 6] = [1025 21 1 2 2 0]
	[local65 4] = [1025 24 1 0]
	[local69 4] = [1025 25 1 0]
	[local73 5] = [1025 26 1 1 0]
	[local78 4] = [1025 28 1 0]
	[local82 4] = [1025 29 1 0]
	[local86 5] = [1025 30 1 2 0]
	[local91 4] = [1025 32 1 0]
	[local95 4] = [1025 33 1 0]
	[local99 6] = [1025 34 2 2 1 0]
	[local105 11] = [1025 37 1 2 3 2 1 1 1 1 0]
	[local116 6] = [1025 45 2 1 2 0]
	[local122 5] = [1025 49 2 1 0]
	[local127 6] = [1025 51 2 1 2 0]
	[local133 7] = [1025 54 1 2 1 2 0]
	[local140 7] = [1025 58 2 1 1 1 0]
	[local147 9] = [1025 62 3 1 2 1 4 1 0]
)

(instance beg of Actor
	(properties
		view 130
		signal 10240
	)

	(method (init)
		(gSFX number: 125 loop: -1 play:)
		(super init:)
	)

	(method (doit &tmp temp0 temp1)
		(= temp1 (GetAngle x y (gEgo x:) (gEgo y:)))
		(= temp0 (Abs (- temp1 heading)))
		(cond
			((and (not local18) (not mover) (not local19) (> temp0 30))
				(= cel
					(cond
						((>= temp1 338) 3)
						((>= temp1 293) 7)
						((>= temp1 248) 1)
						((>= temp1 203) 5)
						((>= temp1 158) 2)
						((>= temp1 113) 4)
						((>= temp1 68) 0)
						((>= temp1 23) 6)
						(else 3)
					)
				)
			)
			((and (== (gEgo edgeHit:) 1) (not (Wat script:)))
				(Wat setScript: (Wat theTimer:))
			)
			(local18
				(-- local18)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem &tmp temp0)
		(switch theVerb
			(2 ; Look
				(SayModeless 1025 15) ; "His tattered rags, filthy face, wretched hump and stumbling walk are the marks of a man who knows the begging trade well."
			)
			(5 ; Talk
				(cond
					((Wat offRoad:)
						(if local21
							(Converse 1 @local47 @local0 3) ; "I'll not move until I know what y'want."
						else
							(= local21 1)
							(Converse @local41 3 @local0) ; "Why do you hesitate? I'm no longer in your way."
						)
					)
					((Wat charFirstTalk:)
						(Converse 1 @local37 @local0 3) ; "I beg you, let me be on my way and reach the town before night falls."
					)
					(else
						(Wat charFirstTalk: 1)
						(Converse @local24 1 @local0) ; "You're not a small man. Your clothes would fit me well enough."
					)
				)
			)
			(10 ; Longbow
				(gEgo setScript: threat)
			)
			(4 ; Inventory
				(cond
					((OneOf invItem 1 2 3) ; horn, halfHeart, slipper
						(gEgo setScript: approachBeggar 0 invItem)
					)
					((== invItem 0) ; bucks
						(SetIcon 0)
						(if (gMoney doit:)
							(gEgo setScript: approachBeggar 0 invItem)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(gEgo setScript: beggarDo)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gSFX fade: 0 30 8 1)
		(gCurRoom notify:)
		(self setCycle: 0 setMotion: 0)
		(Wat weMeetAgain: 1)
		(super dispose:)
		(self delete:)
		(DisposeScript 25)
	)
)

(instance begScript of Script
	(properties)

	(method (dispose)
		(gTheIconBar disable: 5)
		(super dispose:)
	)

	(method (init)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Wat setScript: 0)
				(if (Wat weMeetAgain:)
					(client setScript: repeatEncounter)
				else
					(if (not (gCast contains: beg))
						(beg init:)
					)
					(beg
						posn: 235 50
						setCycle: Walk
						setMotion: MoveTo 205 70 self
					)
				)
			)
			(1
				(beg setLoop: 2 cel: 5 ignoreActors: 1)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 225 58 226 77 204 82 182 77 182 58 205 52
							yourself:
						)
				)
				(NormalEgo)
				(= ticks 18)
			)
			(2
				(Converse @local51 3 @local0 self 0) ; "Merry morning to you. Where are you bound?"
			)
			(3
				(Converse @local59 1 @local0 self) ; "And if I demanded a toll of you to pass along this road?"
			)
			(4
				(HandsOn)
				(gCurRoom horizon: 30)
				(gEgo actions: egoActions)
				(self dispose:)
			)
		)
	)
)

(instance repeatEncounter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 225 58 226 77 204 82 182 77 182 58 205 52
							yourself:
						)
				)
				(Converse 1 @local65 @local0 3 self) ; "Ah, sir, I beg you, let me pass in peace. I must reach the town before night falls."
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 5)
				(gCurRoom horizon: 30)
				(gEgo actions: egoActions)
				(self dispose:)
			)
		)
	)
)

(instance approachBeggar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo distanceTo: beg) 15)
					(if (or (== register 0) (== register 2))
						(gEgo
							setMotion:
								PolyPath
								(- (beg x:) 23)
								(- (beg y:) 3)
								self
						)
					else
						(gEgo
							setMotion:
								PolyPath
								(- (beg x:) 15)
								(+ (beg y:) 5)
								self
						)
					)
				else
					(++ state)
					(self cue:)
				)
			)
			(1
				(Face gEgo beg self)
				(if (or (== register 0) (== register 2))
					(= local19 1)
					(beg setCel: 7)
				)
			)
			(2
				(= ticks 12)
			)
			(3
				(switch register
					(1
						(Converse 1 @local69 @local0 3) ; "Your pardon, sir, but that's not of much use to a beggar."
						(self dispose:)
					)
					(0
						(= local20 1)
						(gEgo setScript: buyClothes)
					)
					(2
						(gEgo put: 2) ; halfHeart
						(gEgo setScript: buyClothes)
					)
					(3
						(Converse 1 @local73 @local0 3) ; "I've been given many things, but never something as odd as this."
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance buyClothes of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(beg dispose:)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= register (gEgo cycleSpeed:))
				(gGame setSpeed: global141)
				(Load rsVIEW 7)
				(HandsOff)
				(gEgo view: 7 setLoop: 4 setCel: 0 setCycle: End self)
			)
			(1
				(= ticks 30)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(NormalEgo)
				(= ticks 60)
			)
			(4
				(if local20
					(Converse 1 @local78 @local0 3 self) ; "Much obliged, sir, much obliged. May the Lord grant you a high seat in heaven."
				else
					(Converse 1 @local82 @local0 3 self) ; "Sir...this is...it's...I can hardly think. You've made me a rich man!"
				)
			)
			(5
				(Converse 2 @local86 3 0 @local0 3 self) ; "Not so quickly, my friend. For my price, I want you to give me those clothes you wear."
			)
			(6
				(if local20
					(Converse 1 @local91 3 0 self) ; "Worry not about my reasons. Will you be content with that money and an extra purse and a new set of clothes besides?"
				else
					(Converse 1 @local95 3 0 self) ; "Worry not about my reasons. Will you be content with that gem and an extra purse and a new set of clothes besides?"
				)
			)
			(7
				(Converse 2 @local99 3 0 @local0 3 self) ; "Sir! I would be more than content!"
			)
			(8
				(gEgo
					setMotion:
						PolyPath
						(if (== (Wat travelDir:) 3) 140 else 205)
						(if (== (Wat travelDir:) 3) 115 else 75)
						self
				)
				(beg setCel: 5)
			)
			(9
				(beg stopUpd:)
				(self setScript: (ScriptID 5 1) self) ; blowinIt
			)
			(10
				(Face gEgo beg self)
			)
			(11
				(= ticks 12)
			)
			(12
				(gEgo stopUpd:)
				(self setScript: (ScriptID 125 1) self) ; merryMenEntrance
			)
			(13
				(Converse 3 @local105 3 0 @local0 3 2 0 self) ; "Men, give this jolly fellow a new suit of clothes and a purse of pennies, enough to see him well on his way back north."
			)
			(14
				(gSFX number: 128 loop: -1 play:)
				(gCurRoom drawPic: 803 -32762)
				(beg view: 130 setLoop: 1 posn: 190 77)
				(= gDisguiseNum 1) ; beggar
				(gInventory eachElementDo: #perform (ScriptID 125 3)) ; putStuff
				(gEgo loop: 4 cel: 0 posn: 170 64)
				(NormalEgo)
				(gCast eachElementDo: #hide)
				(= ticks 60)
			)
			(15
				((ScriptID 23) dispose:) ; Tuck
				((ScriptID 20) dispose:) ; Will
				((ScriptID 19) loop: 1 posn: 229 71) ; John
				(gCurRoom drawPic: 120 -32761)
				(gCast eachElementDo: #show)
				(proc121_0)
				(= ticks 12)
			)
			(16
				(Converse @local116 7 13 self) ; "Faith! You make a fine beggar, Robin. As twisted and wretched as ever I've seen!"
			)
			(17
				(gEgo setMotion: MoveTo 0 240)
				(beg setCycle: Walk setMotion: MoveTo 270 -2 self)
				((ScriptID 19) ignoreHorizon: 1 setMotion: MoveTo 300 -2 self) ; John
			)
			(18 0)
			(19
				(SetFlag 151)
				(SetFlag 54)
				(proc125_2)
				(gGame setSpeed: register)
				(SetIcon 0)
				(= ticks 12)
			)
			(20
				(if local20
					(SetScore 100)
				else
					(SetScore -200)
				)
				((ScriptID 19) dispose:) ; John
				(self dispose:)
			)
		)
	)
)

(instance beggarDo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local22
					(Say 1025 48) ; "There's a strong man beneath those rags, I perceive. He might well box my ear or worse if I lay hands upon him."
					(self dispose:)
				else
					(= local22 1)
					(HandsOff)
					(gEgo setMotion: PChase beg 25 self)
				)
			)
			(1
				(Converse @local122 3 @local0 self) ; "Take care, sir, take care! I may be bent and dirty, but I've a strong arm and hard fist and I'll fight like a badger if you try to lay hands upon me."
			)
			(2
				(= ticks 30)
			)
			(3
				(gEgo
					setCycle: Rev
					setLoop: (gEgo loop:)
					setHeading: (mod (+ (gEgo heading:) 180) 360)
					setMotion: MoveFwd 25 self
				)
			)
			(4
				(NormalEgo)
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance getWill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if
					(if (== (Wat travelDir:) 3)
						(and (< 125 (gEgo x:) 155) (< 105 (gEgo y:) 125))
					else
						(and (< 190 (gEgo x:) 230) (< 65 (gEgo y:) 85))
					)
					(self cue:)
				else
					(gEgo
						setMotion:
							PolyPath
							(if (== (Wat travelDir:) 3) 140 else 205)
							(if (== (Wat travelDir:) 3) 115 else 75)
							self
					)
				)
			)
			(1
				(Face gEgo beg self)
			)
			(2
				(self setScript: (ScriptID 5 1) self) ; blowinIt
				(Wat blewHorn: 1)
			)
			(3
				(ScriptID 20) ; Will
				(LoadMany rsVIEW 160 161 162)
				(= ticks 60)
			)
			(4
				((ScriptID 20) ; Will
					posn: 335 120
					init:
					setCycle: StopWalk 161
					setMotion: MoveTo 270 120 self
				)
				(Face gEgo (ScriptID 20)) ; Will
			)
			(5
				(= ticks 12)
			)
			(6
				(Converse @local127 3 14 self) ; "What's this?"
			)
			(7
				((ScriptID 20) setMotion: MoveTo 335 120 self) ; Will
			)
			(8
				(Face gEgo beg self)
			)
			(9
				(HandsOn)
				(gTheIconBar disable: 5)
				((ScriptID 20) dispose:) ; Will
				(self dispose:)
			)
		)
	)
)

(instance threat of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(beg dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (gEgo cycleSpeed:))
				(gGame setSpeed: global141)
				(HandsOff)
				(cond
					((<= (gEgo y:) 50)
						(gEgo setMotion: PolyPath 175 95 self)
					)
					((< (gEgo distanceTo: beg) 30)
						(gEgo
							setHeading:
								(mod
									(+
										(GetAngle
											(gEgo x:)
											(gEgo y:)
											(beg x:)
											(beg y:)
										)
										180
									)
									360
								)
								self
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(if (< (gEgo distanceTo: beg) 30)
					(gEgo setMotion: MoveFwd 30 self)
				else
					(self cue:)
				)
			)
			(2
				(Face gEgo beg self)
			)
			(3
				(= ticks 12)
			)
			(4
				(gEgo view: 4 setCycle: End self)
				(threatSound init: play:)
			)
			(5
				(= ticks 48)
			)
			(6
				(Converse @local133 2 @local0 self) ; "I've a mind to have those rags you wear. Will you give them to me, or will I add a new hole over your heart?"
			)
			(7
				(= ticks 60)
			)
			(8
				(threatSound stop: dispose:)
				(gEgo setCycle: Beg self)
			)
			(9
				(= ticks 12)
			)
			(10
				(beg stopUpd:)
				(self setScript: (ScriptID 5 1) self) ; blowinIt
			)
			(11
				(if
					(if (== (Wat travelDir:) 3)
						(and (< 125 (gEgo x:) 155) (< 105 (gEgo y:) 125))
					else
						(and (< 190 (gEgo x:) 230) (< 65 (gEgo y:) 85))
					)
					(self cue:)
				else
					(gEgo
						setMotion:
							PolyPath
							(if (== (Wat travelDir:) 3) 140 else 205)
							(if (== (Wat travelDir:) 3) 115 else 75)
							self
					)
				)
			)
			(12
				(= ticks 12)
			)
			(13
				(gEgo stopUpd:)
				(self setScript: (ScriptID 125 1) self) ; merryMenEntrance
			)
			(14
				((ScriptID 19) setMotion: PChase gEgo 30 self) ; John
			)
			(15
				(Converse @local140 3 13 self) ; "What passes with yonder traveller? He fair quivers with rage."
			)
			(16
				(gSFX number: 127 loop: -1 play:)
				(beg view: 130 posn: 158 81 setLoop: 1)
				(= gDisguiseNum 1) ; beggar
				(gInventory eachElementDo: #perform (ScriptID 125 3)) ; putStuff
				(gEgo loop: 1 posn: 191 79)
				(NormalEgo)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803 -32762)
				(= ticks 60)
			)
			(17
				((ScriptID 20) dispose:) ; Will
				((ScriptID 19) loop: 1 posn: 214 60) ; John
				((ScriptID 23) loop: 0 posn: 138 76) ; Tuck
				(gCurRoom drawPic: 120 -32761)
				(gCast eachElementDo: #show)
				(proc121_0)
				(= ticks 12)
			)
			(18
				(Converse 4 @local147 7 0 @local9 3 13 2 15 1 self) ; "Faith, Robin! You look exactly like the beggar now, hump and all."
			)
			(19
				(beg setCycle: Walk setMotion: MoveTo 270 -2 self)
				(gEgo setMotion: MoveTo 0 240 self)
				((ScriptID 19) ignoreHorizon: 1 setMotion: MoveTo 300 -2 self) ; John
				((ScriptID 23) ignoreHorizon: 1 setMotion: MoveTo 245 -2 self) ; Tuck
			)
			(20)
			(21)
			(22)
			(23
				(SetFlag 54)
				((ScriptID 19) dispose:) ; John
				((ScriptID 23) dispose:) ; Tuck
				(proc125_2)
				(NormalEgo)
				(gGame setSpeed: register)
				(SetIcon 0)
				(= ticks 12)
			)
			(24
				(HandsOn)
				(SetScore -100)
				(if (== (Wat section:) 9)
					(gCurRoom newRoom: 100)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance egoActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(if (and (== theVerb 4) (== invItem 1)) ; Inventory, horn
			1
			(if (Wat blewHorn:)
				(Say 1025 68) ; "I'll not have Will think I cannot deal with a mere beggarman by myself."
			else
				(gEgo setScript: getWill)
			)
		)
	)
)

(instance threatSound of Sound
	(properties
		flags 1
		number 900
		loop -1
	)
)

