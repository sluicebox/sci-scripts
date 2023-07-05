;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use n013)
(use n121)
(use Wat)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use MoveFwd)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	jew 0
	jewScript 1
)

(local
	[local0 9] = [-1 {The Jeweler} 15 0 0 0 0 0 0]
	[local9 9] = [135 0 2 4 14 36 14 27 15]
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	[local26 10] = [1026 0 1 2 1 2 1 2 2 0]
	[local36 4] = [1026 7 1 0]
	[local40 5] = [1026 10 2 1 0]
	[local45 7] = [1026 12 1 2 1 2 0]
	[local52 7] = [1026 16 1 2 1 2 0]
	[local59 5] = [1026 20 1 2 0]
	[local64 5] = [1026 22 1 2 0]
	[local69 14] = [1026 24 1 2 1 2 2 1 2 2 1 2 2 0]
	[local83 6] = [1026 35 1 2 2 0]
	[local89 6] = [1026 38 1 2 2 0]
	[local95 7] = [1026 41 2 2 1 2 0]
	[local102 5] = [1026 45 1 2 0]
	[local107 5] = [1026 47 1 2 0]
	[local112 5] = [1026 49 1 2 0]
	[local117 4] = [1026 51 1 0]
	[local121 5] = [1026 52 1 2 0]
	[local126 4] = [1026 54 1 0]
	[local130 4] = [1026 71 1 0]
	[local134 7] = [1026 72 1 2 1 2 0]
	[local141 8] = [1026 55 1 2 1 2 1 0]
	[local149 9] = [1026 60 2 2 1 2 1 2 0]
	[local158 4] = [1026 66 1 0]
	[local162 4] = [1026 67 1 0]
	[local166 5] = [1026 68 2 1 0]
	[local171 4] = [1026 70 1 0]
	[local175 5] = [1026 77 1 2 0]
	[local180 6] = [1026 79 1 2 1 0]
	[local186 13] = [1026 82 1 1 1 2 2 1 2 1 2 1 0]
	[local199 9] = [1026 92 2 2 1 2 1 1 0]
	[local208 4] = [1026 98 1 0]
	[local212 6] = [1026 99 2 2 1 0]
	[local218 9] = [1026 102 1 2 2 2 1 2 0]
	[local227 6] = [1026 108 1 2 1 0]
	[local233 11] = [1026 111 1 2 2 2 1 1 2 1 0]
	[local244 6] = [1026 119 2 1 2 0]
	[local250 6] = [1026 122 1 2 1 0]
	[local256 5] = [1026 125 1 2 0]
	[local261 6] = [1026 127 1 1 2 0]
	[local267 7] = [1026 130 1 2 1 2 0]
	[local274 9] = [1026 134 1 2 1 1 2 1 0]
	[local283 12] = [1026 140 2 2 1 2 2 1 1 3 3 0]
)

(procedure (localproc_0)
	(if local22
		(Converse 1 @local36 @local9 3) ; "Please put your ring away. I don't care to make the trade you want."
	else
		(= local22 1)
		(Converse @local26 1 @local9) ; "Would you trade your clothes for this ring?"
	)
)

(instance jew of Actor
	(properties
		description {the Jeweler}
		view 134
		signal 10240
	)

	(method (init)
		(gSFX number: 125 loop: -1 play:)
		(= local18 (* (- 4 gHowFast) 10))
		(super init:)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			((and (== (gEgo edgeHit:) 1) (not (Wat script:)))
				(Wat setScript: (Wat theTimer:))
			)
			(global199
				(if (>= (++ local20) 5)
					(= local20 1)
					(= global199 0)
					(Converse @local40 3 @local9) ; "What's wrong with you? Are you afflicted with St. Vitus's Dance?"
				)
			)
			((and (not local18) (not mover) (== loop 4))
				(= temp1 (GetAngle x y (gEgo x:) (gEgo y:)))
				(if (> (= temp0 (Abs (- temp1 heading))) 30)
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
				(= local18 (* (- 4 gHowFast) 10))
			)
			(local18
				(-- local18)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1026 8) ; "He has a sour face but a fine set of clothes."
			)
			(5 ; Talk
				(if (Wat charFirstTalk:)
					(Converse @local64 1 @local9) ; "I want the truth from you, for I can tell you're hiding something."
				else
					(Wat charFirstTalk: 1)
					(gEgo setScript: talkScript)
				)
			)
			(10 ; Longbow
				(gEgo setScript: threat)
			)
			(4 ; Inventory
				(if (OneOf invItem 0 2 14 18 10 4 1 16 12) ; bucks, halfHeart, amethyst, waterRing, fireRing, net, horn, fulkScroll, puzzleBox
					(gEgo setScript: approachJeweler 0 invItem)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(3 ; Do
				(gEgo setScript: jewSearch)
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
		(Wat weMeetAgain: (+ (Wat weMeetAgain:) 1))
		(super dispose:)
		(self delete:)
		(DisposeScript 26)
	)
)

(instance jewScript of Script
	(properties)

	(method (dispose)
		(gEgo actions: egoActions)
		(HandsOn)
		(gTheIconBar disable: 5)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 7)
				(Wat setScript: 0)
				(if (Wat weMeetAgain:)
					(client setScript: repeatEncounter)
				else
					(if (not (gCast contains: jew))
						(jew init:)
					)
					(jew
						posn: 235 50
						setCycle: Walk
						setMotion: MoveTo 205 70 self
					)
				)
			)
			(1
				(jew ignoreActors: 1 setLoop: 4 cel: 5)
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
				(self setScript: firstMeet self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance repeatEncounter of TScript
	(properties)

	(method (dispose)
		(HandsOn)
		(gTheIconBar disable: 5)
		(gEgo actions: egoActions)
		(super dispose:)
	)

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
				(if (== (Wat weMeetAgain:) 1)
					(Converse @local95 3 @local9 self 0) ; "Oh, bloody day. Not you again."
				else
					(Converse @local112 3 @local9 self) ; "Well, here we are again."
				)
			)
			(2
				(if (== (Wat weMeetAgain:) 1)
					(Converse @local102 1 @local9 self 0) ; "I hear no horn."
				else
					(self dispose:)
				)
			)
			(3
				(Converse @local107 3 @local9 self 1) ; "Hahaha! Jeweler, you're truly a rascal of the highest order."
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance approachJeweler of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (!= (gEgo x:) local24) (!= (gEgo y:) local25))
					(= local24 (- (jew x:) 20))
					(= local25 (+ (jew y:) 10))
					(gEgo setMotion: PolyPath local24 local25 self)
				else
					(self cue:)
				)
			)
			(1
				(if (!= (gEgo loop:) 6)
					(Face gEgo jew self)
				else
					(self cue:)
				)
			)
			(2
				(= ticks 12)
			)
			(3
				(switch register
					(999 0)
					(1
						(Converse 1 @local117 @local9 3) ; "I deal with stones, not horn."
					)
					(0
						(if (gMoney doit:)
							(gMoney put:)
							(if local19
								(Converse 1 @local126 @local9 3) ; "That's not enough to be worth the inconvenience of losing my fine clothes."
							else
								(= local19 1)
								(Converse @local121 1 @local9) ; "Would this sway you to a trade -- your clothes and possessions for this money, plus a new suit of Lincoln green."
							)
						)
					)
					(2
						(Converse @local141 1 @local9) ; "I've a mind to trade this emerald and a new suit of Lincoln green for your clothes and possessions."
					)
					(14
						(if local21
							(Converse 1 @local158 @local9 3) ; "I'm not interested in the trade."
						else
							(= local21 1)
							(Converse @local149 1 @local9) ; "Rather a rough piece of amethyst. Wouldn't cut all that well."
						)
					)
					(12
						(Converse 1 @local162 @local9 3) ; "I've seen such boxes. Bloody nuisance they are, if you ask me."
					)
					(10
						(localproc_0)
					)
					(18
						(localproc_0)
					)
					(16
						(if local23
							(Converse 1 @local171 @local9 3) ; "I told you that I cannot read."
						else
							(Converse @local166 1 @local9) ; "I cannot read. What is this?"
							(= local23 1)
						)
					)
					(4
						(Converse @local175 1 @local9) ; "Would you trade your clothes for this golden net?"
					)
				)
				(if (== register 2)
					(client setScript: spentEmerald)
				else
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance spentEmerald of TScript
	(properties)

	(method (dispose)
		(SetIcon 0)
		(gSFX fade:)
		(super dispose:)
		(jew dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: (ScriptID 5 1) self) ; blowinIt
			)
			(1
				(gSFX number: 127 loop: -1 play:)
				(= ticks 60)
			)
			(2
				(gEgo put: 2) ; halfHeart
				(jew loop: 2 cel: 0 posn: 188 50 cycleSpeed: 12)
				(= gDisguiseNum 2) ; jewler (no rouge)
				(gInventory eachElementDo: #perform (ScriptID 125 3)) ; putStuff
				(NormalEgo)
				(gEgo get: 7 8 loop: 7 cel: 0 posn: 219 70) ; jewels
				(gEgoHead posn: 219 70 cel: 1)
				(ScriptID 23) ; Tuck
				(ScriptID 20) ; Will
				((ScriptID 23) view: 155 loop: 1 posn: 265 75 init:) ; Tuck
				((ScriptID 20) view: 161 loop: 1 posn: 250 95 init:) ; Will
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803 -32762)
				(= ticks 120)
			)
			(3
				(gCurRoom drawPic: 120 -32761)
				(proc121_0)
				(gCast eachElementDo: #show)
				(= ticks 18)
			)
			(4
				(jew cycleSpeed: 24 setCycle: End)
				(= ticks 240)
			)
			(5
				(= notKilled 1)
				(Converse 2 @local212 4 2 @local0 2 self) ; "You've kept your word right enough. I'll make you another gift."
			)
			(6
				(= ticks 30)
			)
			(7
				(Converse 2 @local218 4 2 @local0 2 self) ; "These are magnificent jewels! They must be worth more than my single emerald."
			)
			(8
				(Converse @local227 4 14 self) ; "Will, Tuck, escort our friend to the north."
			)
			(9
				(SetScore -200)
				(gCurRoom drawPic: 803 -32762)
				(NormalEgo 2)
				(gEgo posn: 175 90)
				(gEgoHead posn: 175 90 cel: 6)
				((ScriptID 20) dispose:) ; Will
				(jew z: 1000)
				((ScriptID 23) dispose:) ; Tuck
				(gCast eachElementDo: #hide)
				(= seconds 3)
			)
			(10
				(gCurRoom drawPic: 120 -32761)
				(SetFlag 152)
				(SetFlag 113)
				(proc121_0)
				(proc125_2)
				(NormalEgo)
				(gCast eachElementDo: #show)
				(= ticks 60)
			)
			(11
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance jewSearch of Script
	(properties)

	(method (dispose)
		(if (Wat secondSearch:)
			(gSFX fade:)
		)
		(super dispose:)
		(if (Wat secondSearch:)
			(jew dispose:)
		else
			(Wat secondSearch: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self setScript: approachJeweler self 999)
			)
			(1
				(HandsOff)
				(= local24 (- (jew x:) 17))
				(= local25 (+ (jew y:) 3))
				(gEgo setMotion: MoveTo local24 local25 self)
			)
			(2
				(gGame setSpeed: global141)
				(gEgo view: 7 setLoop: 6 setCel: 0 setCycle: CT 2 1 self)
			)
			(3
				(jew setLoop: 1 setCel: 1 setCycle: End)
				(gEgo setCycle: CT 5 1 self)
			)
			(4
				(if (Wat secondSearch:)
					(Converse @local244 1 @local9 self) ; "Not again. Look, just TAKE the money and let me be on my way."
				else
					(self cue:)
				)
			)
			(5
				(gEgo setCycle: End)
				(= seconds 2)
			)
			(6
				(jew loop: 4 cel: 5)
				(= ticks 12)
			)
			(7
				(if (Wat secondSearch:)
					(Converse @local250 1 @local9 self) ; "I see why you kept this well hidden. What magnificent jewels!"
				else
					(Converse @local233 1 @local9 self) ; "This is all you have? Five pennies?"
				)
			)
			(8
				(NormalEgo 6)
				(gGame setSpeed: global157)
				(gEgo
					setCycle: Rev
					setLoop: (gEgo loop:)
					setMotion:
						MoveFwd
						(if (Wat secondSearch:) -12 else -24)
						self
				)
			)
			(9
				(NormalEgo 6)
				(= ticks 30)
			)
			(10
				(if (Wat secondSearch:)
					(Converse @local256 1 @local9 self 0) ; "But tell me truly now, what plans did you have in Nottingham?"
				else
					(NormalEgo)
					(HandsOn)
					(gTheIconBar disable: 5)
					(self dispose:)
				)
			)
			(11
				(Converse @local261 3 @local9 self 0) ; "Then I'll see that you profit and save you the journey besides."
			)
			(12
				(Converse @local267 1 @local9 self 0) ; "You try my patience. Will you come willingly, or must I--"
			)
			(13
				(Converse @local274 3 @local9 self) ; "Then you meant to swindle the Sheriff's wife all along."
			)
			(14
				(self setScript: (ScriptID 5 1) self) ; blowinIt
			)
			(15
				(= seconds 2)
			)
			(16
				(jew loop: 2 cel: 0 cycleSpeed: 18 posn: 188 50)
				(= gDisguiseNum 2) ; jewler (no rouge)
				(gInventory eachElementDo: #perform (ScriptID 125 3)) ; putStuff
				(NormalEgo)
				(gEgo get: 7 8 loop: 7 cel: 0 posn: 219 70) ; jewels
				(gEgoHead posn: 219 70 cel: 1)
				(ScriptID 23) ; Tuck
				(ScriptID 19) ; John
				((ScriptID 19) view: 152 loop: 1 posn: 265 75 init:) ; John
				((ScriptID 23) view: 155 loop: 1 posn: 250 95 init:) ; Tuck
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803 -32762)
				(= seconds 3)
			)
			(17
				(gCurRoom drawPic: 120 -32761)
				(proc121_0)
				(gCast eachElementDo: #show)
				(= seconds 2)
			)
			(18
				(jew setCycle: CT (- (jew lastCel:) 1) 1)
				(= seconds 3)
			)
			(19
				(jew cel: (jew lastCel:))
				(= ticks 18)
			)
			(20
				(Converse 3 @local283 4 2 @local0 2 13 3 self) ; "This pouch holds more than enough to cover my losses."
				(gSFX number: 128 loop: -1 play:)
			)
			(21
				(gCurRoom drawPic: 803 -32762)
				(NormalEgo 2)
				(gEgo posn: 175 90)
				(gEgoHead posn: 175 90 cel: 6)
				((ScriptID 19) dispose:) ; John
				((ScriptID 23) dispose:) ; Tuck
				(gCast eachElementDo: #hide)
				(= seconds 3)
			)
			(22
				(gCurRoom drawPic: 120 -32761)
				(SetFlag 152)
				(SetFlag 113)
				(proc125_2)
				(NormalEgo)
				(gCast eachElementDo: #show)
				(SetScore 100)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tryHorn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global111 (gEgo loop:))
				(gEgo
					view: 10
					setLoop: (if (OneOf (gEgo loop:) 2 4 0 6) 0 else 1)
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 3 1 self
				)
			)
			(1
				(Converse 1 @local130 @local9 3 self) ; "Aye, go ahead. Not man enough to deal with me yourself. I had no idea I was so terrifying."
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(Wat blewHorn: 1)
				(gEgo cycleSpeed: 6)
				(NormalEgo global111)
				(= ticks 18)
			)
			(4
				(Converse @local134 1 @local9 self) ; "You call me a coward?"
			)
			(5
				(HandsOn)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance threat of Script
	(properties)

	(method (doit)
		(if (and (== ((ScriptID 23) cel:) 4) (not (spankSound handle:))) ; Tuck
			(spankSound play:)
		)
		(super doit:)
	)

	(method (dispose)
		(gSFX fade:)
		(spankSound dispose:)
		(SetFlag 113)
		(proc125_2)
		((ScriptID 19) dispose:) ; John
		((ScriptID 23) dispose:) ; Tuck
		(gGame setSpeed: register)
		(super dispose:)
		(jew dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetIcon 0)
				(HandsOff)
				(= register (gGame egoMoveSpeed:))
				(gGame setSpeed: global141)
				(threatSound init:)
				(if (< (gEgo distanceTo: jew) 30)
					(gEgo
						setHeading:
							(mod
								(+
									(GetAngle
										(gEgo x:)
										(gEgo y:)
										(jew x:)
										(jew y:)
									)
									180
								)
								360
							)
							self
					)
				else
					(self cue:)
				)
			)
			(1
				(if (< (gEgo distanceTo: jew) 30)
					(gEgo setMotion: MoveFwd 30 self)
				else
					(self cue:)
				)
			)
			(2
				(Face gEgo jew self)
			)
			(3
				(gEgo view: 4 setCel: 0 setCycle: End self)
			)
			(4
				(threatSound play:)
				(= ticks 48)
			)
			(5
				(Converse @local180 2 @local9 self) ; "I'll have your clothes and all you possess--NOW!"
			)
			(6
				(gSFX number: 127 loop: -1 play:)
				(ScriptID 23) ; Tuck
				(ScriptID 19) ; John
				(LoadMany rsVIEW 152 155 168)
				(jew view: 134 setLoop: 3 setCel: 0 posn: 90 150)
				(= gDisguiseNum 2) ; jewler (no rouge)
				(gInventory eachElementDo: #perform (ScriptID 125 3)) ; putStuff
				(gEgo get: 7 8 loop: 6 cel: 0 posn: 64 167) ; jewels
				(gEgoHead posn: 64 167 cel: 2)
				(NormalEgo)
				((ScriptID 19) ; John
					view: 152
					loop: 2
					ignoreActors: 1
					posn: 108 139
					init:
				)
				((ScriptID 23) ; Tuck
					view: 168
					loop: 1
					cel: 1
					ignoreActors: 1
					posn: 125 146
					init:
				)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 803 -32762)
				(= seconds 3)
			)
			(7
				(threatSound stop: dispose:)
				(gCurRoom drawPic: 120 -32761)
				(proc121_0)
				(gCast eachElementDo: #show)
				(= ticks 120)
			)
			(8
				(Converse 2 @local186 4 0 @local0 0 self) ; "What have we here? I feel a bulge in the lining of this cape and what do I pull forth...?"
			)
			(9
				(= ticks 60)
			)
			(10
				((ScriptID 23) cel: 2) ; Tuck
				(= ticks 6)
			)
			(11
				((ScriptID 23) setCycle: CT 1 1 self) ; Tuck
			)
			(12
				(= ticks 18)
			)
			(13
				(Converse 2 @local199 4 0 @local0 0 self) ; "Wait! The truth then!"
			)
			(14
				(= ticks 60)
			)
			(15
				(gEgo setMotion: MoveTo 0 250)
				(= ticks 120)
			)
			(16
				(jew setCycle: End)
				(= ticks 90)
			)
			(17
				(Converse 1 @local208 @local0 0 self) ; "Someday you'll hang, Robin Hood, and I'll rejoice at the foot of the gallows."
			)
			(18
				(jew setCycle: Beg self)
			)
			(19
				(= ticks 12)
			)
			(20
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
		(return
			(switch theVerb
				(3 ; Do
					(if (and (IsFlag 34) local20)
						(Say 1026 9) ; "I've already tested the Hand Code upon this man, and he clearly knows nothing of it."
					)
				)
				(4 ; Inventory
					(if (== invItem 1) ; horn
						(if (Wat blewHorn:)
							(Say 1026 76) ; "If I cannot deal with this sharp-tongued rascal myself, I don't deserve the title of outlaw."
						else
							(gEgo setScript: tryHorn)
							1
						)
					)
				)
			)
		)
	)
)

(instance talkScript of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Converse @local45 1 @local9 self 0) ; "You say you're a jeweler, yet you carry no wares, no samples of your work. How is this?"
			)
			(1
				(Converse @local52 1 @local9 self 0) ; "Without money?"
			)
			(2
				(Converse @local59 1 @local9 self 1) ; "My friend, if I meant you harm, you wouldn't be talking to me in this fashion right now."
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance firstMeet of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Converse @local69 3 @local9 self 0) ; "Greetings, merchant. What brings you through Sherwood Forest?"
			)
			(1
				(Converse @local83 1 @local9 self 0) ; "I haven't asked for--"
			)
			(2
				(Converse @local89 3 @local9 self 1) ; "Hold onto your pennies for now. First, I would know more of your business and why you travel to Nottingham."
			)
			(3
				(self dispose:)
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

(instance spankSound of Sound
	(properties
		flags 1
		number 153
	)
)

