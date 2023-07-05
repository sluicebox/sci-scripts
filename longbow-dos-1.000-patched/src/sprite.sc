;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 185)
(include sci.sh)
(use Main)
(use n013)
(use n221)
(use n228)
(use n231)
(use n233)
(use n241)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use FlipPoly)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	sprite 0
	runFerIt 1
	spriteCaught 2
	bag 3
	dumpSprite 4
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	[local10 5] = [1185 4 1 2 0]
	[local15 6] = [1185 6 1 2 2 0]
	[local21 5] = [1185 9 1 2 0]
	[local26 5] = [1185 15 1 1 0]
	[local31 9] = [186 0 2 4 22 24 19 16 26]
	[local40 8] = [-1 0 0 0 0 0 0 0]
)

(instance sprite of Actor
	(properties
		yStep 5
		view 185
		signal 16384
		xStep 9
	)

	(method (dispose)
		(self setScript: 0)
		(super dispose:)
	)

	(method (cue)
		((ScriptID 220 0) setScript: 0) ; forest
		(self dispose:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if local1
					(Say 1185 0 0) ; "'Tis a wood sprite."
				else
					(= local1 1)
					(gEgo setScript: lookSprite)
				)
			)
			(10 ; Longbow
				((ScriptID 220 0) setScript: skewerSprite) ; forest
			)
			(4 ; Inventory
				(if
					(and
						(== invItem 4) ; net
						(> gMouseY (gCurRoom horizon:))
						(not (gEgo script:))
					)
					(gEgo setScript: (ScriptID 181 1) gMouseX gMouseY) ; tossIt
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance funnySprite of PicView
	(properties)

	(method (init)
		(self
			view: (sprite view:)
			loop: (sprite loop:)
			cel: (sprite cel:)
			x: (sprite x:)
			y: (sprite y:)
		)
		(super init:)
	)
)

(instance bag of View
	(properties
		view 771
		loop 3
		cel 7
		signal 16384
	)

	(method (init)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init:
						(+ (bag x:) 11)
						(+ (bag y:) 5)
						(- (bag x:) 13)
						(+ (bag y:) 5)
						(- (bag x:) 21)
						(- (bag y:) 1)
						(- (bag x:) 11)
						(- (bag y:) 13)
						(+ (bag x:) 13)
						(- (bag y:) 13)
						(+ (bag x:) 21)
						(- (bag y:) 1)
					yourself:
				)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 178)
					(Say 1185 11 0) ; "I've not forgotten what happened last time I touched a sprite's `gift'."
				else
					(gEgo setScript: bagLook)
				)
			)
			(3 ; Do
				(gEgo setScript: easterEgg)
			)
			(10 ; Longbow
				(Say 1185 12 0) ; "That might not be wise."
			)
			(4 ; Inventory
				(gEgo setScript: easterEgg)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance extraNet of Prop
	(properties
		view 188
		loop 4
		signal 16384
	)

	(method (init)
		(self posn: (sprite x:) (+ (sprite y:) 4))
		(super init:)
	)
)

(instance flash of View
	(properties
		view 245
		loop 1
		cel 5
		signal 16384
	)

	(method (init)
		(if (not (gEgo loop:))
			(self posn: (- (gEgo x:) 13) (gEgo y:))
		else
			(self posn: (+ (gEgo x:) 5) (gEgo y:))
		)
		(super init:)
	)
)

(instance runFerIt of Script
	(properties)

	(method (doit &tmp [temp0 4])
		(cond
			(local3
				(= local3 0)
				(if (== (gEgo script:) 0)
					(HandsOn)
				)
				(if
					(OneOf
						gForestRoomNum
						19
						21
						23
						35
						50
						52
						65
						68
						82
						83
						85
						86
						89
						115
						121
						131
						133
						151
						154
					)
					(if (== (gCurRoom picture:) 230)
						(proc233_0)
					else
						(proc228_0)
					)
				else
					(switch (gCurRoom picture:)
						(220
							(proc221_0)
						)
						(230
							(proc231_0)
						)
						(240
							(proc241_0)
						)
					)
				)
				(if
					(and
						(not
							(OneOf
								gForestRoomNum
								19
								21
								23
								35
								50
								52
								65
								68
								82
								83
								85
								86
								89
								115
								121
								131
								133
								151
								154
							)
						)
						(OneOf
							gForestRoomNum
							21
							36
							37
							38
							50
							56
							67
							75
							98
							99
							103
							115
							119
							135
							167
						)
					)
					(FlipPoly)
				)
			)
			(
				(and
					(< (sprite distanceTo: gEgo) 35)
					(not (> (sprite x:) 319))
					(not (< (sprite x:) 1))
					(not local2)
				)
				(= local2 1)
				(HandsOff)
				(gEgo setMotion: 0 ignoreActors: 1)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init:
								(+ (gEgo x:) 20)
								(gEgo y:)
								(+ (gEgo x:) 12)
								(+ (gEgo y:) 8)
								(- (gEgo x:) 12)
								(+ (gEgo y:) 8)
								(- (gEgo x:) 20)
								(gEgo y:)
								(- (gEgo x:) 12)
								(- (gEgo y:) 6)
								(+ (gEgo x:) 12)
								(- (gEgo y:) 6)
							yourself:
						)
				)
			)
			(
				(and
					(or
						(> (sprite distanceTo: gEgo) 30)
						(> (sprite x:) 319)
						(< (sprite x:) 1)
					)
					local2
				)
				(= local2 0)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
				)
				(gCurRoom obstacles: 0)
				(gEgo ignoreActors: 0)
				(= local3 1)
			)
			(
				(and
					(or (== (sprite loop:) 4) (== (sprite loop:) 5))
					(== (sprite cel:) 3)
				)
				(if (== (sprite loop:) 4)
					(sprite setLoop: 0)
				else
					(sprite setLoop: 1)
				)
				(sprite setCycle: Walk)
				(= local0 (Random 10 25))
			)
			((not local0))
			((-- local0))
			((== (sprite loop:) 0)
				(sprite setLoop: 4 cel: 0)
			)
			((== (sprite loop:) 2)
				(sprite setLoop: 5 cel: 0)
			)
			(else
				(= local0 (Random 10 25))
			)
		)
		(super doit:)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(LoadMany rsVIEW 185 188)
				(gEgo actions: noPuzzleBox)
				(SetFlag 37)
				(gSFX number: 901 loop: -1 play:)
				(= local0 (Random 10 25))
				(if (= local9 (Random 0 1))
					(sprite setLoop: 0)
					(= temp0 330)
					(= temp1 -10)
				else
					(sprite setLoop: 1)
					(= temp0 -10)
					(= temp1 330)
				)
				(sprite
					view: 185
					posn: temp1 (Random 80 180)
					setCycle: Walk
					init:
					setMotion: PolyPath temp0 (Random 100 200) self
				)
			)
			(1
				(if (IsFlag 104)
					(ClearFlag 104)
				)
				(gSFX stop:)
				(ClearFlag 37)
				(if (IsFlag 218)
					((ScriptID 181 1) cue:) ; tossIt
				)
				(sprite dispose:)
				(= ticks 6)
			)
			(2
				(dumpSprite doit:)
			)
		)
	)
)

(instance spriteCaught of Script
	(properties)

	(method (dispose)
		(HandsOn)
		(super dispose:)
	)

	(method (doit)
		(cond
			((and ((ScriptID 220 0) script:) (not local4)) 0) ; forest
			(local4
				(switch local8
					(1
						(if (<= (sprite y:) 83)
							(self cue:)
						)
					)
					(4
						(if
							(or
								(>= (sprite x:) 319)
								(and
									(> (- (sprite x:) 100) (gEgo x:))
									(> (sprite x:) (gEgo x:))
								)
							)
							(self cue:)
						)
					)
					(3
						(if
							(or
								(>= (sprite y:) 189)
								(and
									(> (- (sprite y:) 50) (gEgo x:))
									(> (sprite y:) (gEgo y:))
								)
							)
							(self cue:)
						)
					)
					(else
						(if
							(or
								(<= (sprite x:) 0)
								(and
									(< (- (sprite x:) 100) (gEgo x:))
									(< (sprite x:) (gEgo x:))
								)
							)
							(self cue:)
						)
					)
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(sprite
					setCycle: Walk
					setMotion: MoveTo global104 (- global105 10) self
				)
			)
			(1
				(Face gEgo sprite)
				(sprite
					setCycle: 0
					setMotion: 0
					setPri: (- ((ScriptID 181 2) priority:) 1) ; theNet
					view: 188
					loop: 0
					cel: 2
				)
				(= ticks 24)
			)
			(2
				(sprite loop: 3 cel: 8)
				((ScriptID 181 2) ; theNet
					view: 188
					loop: 5
					cel: 0
					posn: (sprite x:) (sprite y:)
				)
				(SetScore 10)
				(extraNet init:)
				(= ticks 18)
			)
			(3
				(Converse @local10 3 @local31 self) ; "At last! Pixie, grant my wish. I wish--."
			)
			(4
				(Converse @local15 2 @local31 self) ; "What do you mean? You can't grant wishes?!"
			)
			(5
				(Converse @local21 3 @local31 self) ; "Very well. Go!."
			)
			(6
				((ScriptID 181 2) setCel: 2) ; theNet
				(= ticks 12)
			)
			(7
				((ScriptID 181 2) setCycle: End self) ; theNet
				(extraNet setCycle: End self)
			)
			(8
				(if (> (gEgo y:) 180)
					(gEgo setMotion: PolyPath (gEgo x:) 165)
				else
					(self cue:)
				)
			)
			(9
				((ScriptID 181 2) dispose: delete:) ; theNet
				(extraNet dispose:)
				(gEgo ignoreActors: 1)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init:
								(+ (gEgo x:) 32)
								(gEgo y:)
								(+ (gEgo x:) 23)
								(+ (gEgo y:) 7)
								(- (gEgo x:) 28)
								(+ (gEgo y:) 7)
								(- (gEgo x:) 32)
								(gEgo y:)
								(- (gEgo x:) 28)
								(- (gEgo y:) 9)
								(+ (gEgo x:) 23)
								(- (gEgo y:) 9)
							yourself:
						)
				)
				(cond
					(
						(or
							(== gForestRoomNum 18)
							(== gForestRoomNum 19)
							(== gForestRoomNum 20)
							(== gForestRoomNum 21)
							(== gForestRoomNum 22)
							(== gForestRoomNum 23)
							(== gForestRoomNum 33)
							(== gForestRoomNum 34)
							(== gForestRoomNum 35)
							(== gForestRoomNum 36)
							(== gForestRoomNum 37)
							(== gForestRoomNum 38)
							(== gForestRoomNum 39)
							(== gForestRoomNum 50)
							(== gForestRoomNum 51)
							(== gForestRoomNum 52)
							(== gForestRoomNum 53)
							(== gForestRoomNum 54)
							(== gForestRoomNum 67)
							(== gForestRoomNum 68)
							(== gForestRoomNum 69)
						)
						(sprite setLoop: 2)
						(= local8 3)
						(= local6 (sprite x:))
						(= local7 240)
						(= local5 2)
					)
					(
						(or
							(== gForestRoomNum 49)
							(== gForestRoomNum 65)
							(== gForestRoomNum 66)
							(== gForestRoomNum 82)
							(== gForestRoomNum 83)
							(== gForestRoomNum 97)
							(== gForestRoomNum 98)
						)
						(sprite setLoop: 0)
						(= local8 4)
						(= local6 340)
						(= local7 (sprite y:))
						(= local5 0)
					)
					(
						(or
							(== gForestRoomNum 99)
							(== gForestRoomNum 100)
							(== gForestRoomNum 101)
							(== gForestRoomNum 102)
							(== gForestRoomNum 114)
							(== gForestRoomNum 115)
							(== gForestRoomNum 116)
							(== gForestRoomNum 117)
							(== gForestRoomNum 118)
							(== gForestRoomNum 130)
							(== gForestRoomNum 131)
							(== gForestRoomNum 132)
							(== gForestRoomNum 133)
							(== gForestRoomNum 134)
							(== gForestRoomNum 135)
							(== gForestRoomNum 150)
							(== gForestRoomNum 166)
						)
						(sprite setLoop: 3)
						(= local8 1)
						(cond
							((== (gCurRoom picture:) 230)
								(if 21
									36
									37
									38
									50
									56
									67
									75
									98
									99
									103
									115
									119
									135
									167
									(= local6 139)
								else
									(= local6 180)
								)
							)
							(21
								36
								37
								38
								50
								56
								67
								75
								98
								99
								103
								115
								119
								135
								167
								(= local6 100)
							)
							(else
								(= local6 219)
							)
						)
						(= local7 75)
					)
					(else
						(sprite setLoop: 1)
						(= local8 2)
						(= local6 -20)
						(= local7 (sprite y:))
						(= local5 1)
					)
				)
				(sprite
					view: 185
					signal: (| (sprite signal:) $2000)
					setPri: -1
					setCycle: Walk
					setMotion: PolyPath local6 local7 sprite
				)
				(= local4 1)
			)
			(10
				(gEgo setMotion: PolyPath local6 (sprite y:) self)
				(= local4 0)
				(gSFX fade: 0 30 8 0)
			)
		)
	)
)

(instance skewerSprite of Script
	(properties)

	(method (changeState newState param2)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 159)
				(sprite setMotion: 0 setCycle: 0 view: 188 setLoop: 2 setCel: 3)
				(= ticks 6)
			)
			(1
				(gEgo setMotion: 0)
				(cond
					(
						(or
							(<=
								(= param2
									(GetAngle
										(gEgo x:)
										(gEgo y:)
										(sprite x:)
										(sprite y:)
									)
								)
								20
							)
							(> param2 340)
						)
						(gEgo setLoop: 3)
					)
					((<= param2 80)
						(gEgo setLoop: 6)
					)
					((<= param2 100)
						(gEgo setLoop: 0)
					)
					((<= param2 160)
						(gEgo setLoop: 4)
					)
					((<= param2 200)
						(gEgo setLoop: 2)
					)
					((<= param2 260)
						(gEgo setLoop: 5)
					)
					((<= param2 280)
						(gEgo setLoop: 1)
					)
					((<= param2 340)
						(gEgo setLoop: 7)
					)
				)
				(gEgo view: 4 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo view: 5 setCel: 0 setCycle: End self)
			)
			(3
				(gSFX number: 906 loop: 1 play:)
				(= ticks 6)
			)
			(4
				(bag posn: (sprite x:) (sprite y:) init:)
				(sprite dispose:)
				(= ticks 20)
			)
			(5
				(gSFX number: 213 loop: 1 play:)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance easterEgg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (gEgo x:) (bag x:))
					(gEgo
						setMotion: PolyPath (- (bag x:) 12) (+ (bag y:) 10) self
					)
				else
					(gEgo
						setMotion: PolyPath (+ (bag x:) 8) (+ (bag y:) 10) self
					)
				)
			)
			(1
				(gEgo
					view: 7
					setCel: 0
					setLoop: (if (< (gEgo x:) (bag x:)) 1 else 0)
					setCycle: CT 4 1 self
				)
			)
			(2
				(gEgo hide:)
				(SetFlag 178)
				(ClearFlag 159)
				(bag hide:)
				(flash init:)
				(gSFX number: 216 loop: 1 play:)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
				)
				(gCurRoom obstacles: 0)
				(= ticks 6)
			)
			(3
				(if
					(OneOf
						gForestRoomNum
						19
						21
						23
						35
						50
						52
						65
						68
						82
						83
						85
						86
						89
						115
						121
						131
						133
						151
						154
					)
					(if (== (gCurRoom curPic:) 230)
						(proc233_0)
					else
						(proc228_0)
					)
				else
					(switch (gCurRoom curPic:)
						(220
							(proc221_0)
						)
						(230
							(proc231_0)
						)
						(240
							(proc241_0)
						)
					)
				)
				(if
					(and
						(not
							(OneOf
								gForestRoomNum
								19
								21
								23
								35
								50
								52
								65
								68
								82
								83
								85
								86
								89
								115
								121
								131
								133
								151
								154
							)
						)
						(OneOf
							gForestRoomNum
							21
							36
							37
							38
							50
							56
							67
							75
							98
							99
							103
							115
							119
							135
							167
						)
					)
					(FlipPoly)
				)
				(SetFlag 179)
				(gEgo actions: egoShrimp)
				(gTheIconBar disable: 5 4 6 7)
				(flash dispose:)
				(NormalEgo 2 67 67)
				(cond
					((> (gEgo y:) 188)
						(if (< (gEgo x:) (bag x:))
							(gEgo posn: (+ (gEgo x:) 3) 188)
						else
							(gEgo posn: (- (gEgo x:) 10) 188)
						)
					)
					((< (gEgo x:) (bag x:))
						(gEgo posn: (+ (gEgo x:) 3) (gEgo y:))
					)
					(else
						(gEgo posn: (- (gEgo x:) 10) (gEgo y:))
					)
				)
				(gEgo setCycle: Walk setStep: 6 4 show:)
				(bag dispose:)
				(= ticks 24)
			)
			(4
				(Converse 1 @local26 @local40 0 self) ; "'Od's Blood! The forest has grown gigantic!"
			)
			(5
				(HandsOn)
				(gTheIconBar disable: 5 4 6 7)
				(self dispose:)
			)
		)
	)
)

(instance bagLook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Say 1185 13 self) ; "The sprite and my arrow have vanished."
			)
			(1
				(Say 1185 14 self) ; "In their place is a large bag that looks to be filled with something. Perhaps gold or gems!"
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lookSprite of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say 1185 1 self) ; "'Tis a wood sprite, one of the little tree pixies that inhabit Sherwood."
			)
			(1
				(Say 1185 2 self) ; "Legend says that a captured wood sprite must grant anything the captor wishes."
			)
			(2
				(Say 1185 3 self) ; "I've tried for many years and I've never caught one yet."
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance egoShrimp of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(2 ; Look
					(Say 1185 17 1) ; "It is a humbling thing to see the forest from a rabbit's eye view."
					1
				)
				(3 ; Do
					(Say 1185 18 1) ; "I'm not feeling entirely myself right now."
					1
				)
			)
		)
	)
)

(instance noPuzzleBox of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(return
			(if (and (== theVerb 4) (== invItem 12)) ; Inventory, puzzleBox
				(Say 1185 19 1) ; "There goes one of those bloody sprites. I cannot concentrate upon the puzzle box with such a distraction around."
				1
			)
		)
	)
)

(instance dumpSprite of Code
	(properties)

	(method (doit)
		(if (gCast contains: sprite)
			(gAddToPics add: funnySprite)
			(funnySprite init:)
			(gAddToPics doit:)
		)
		(gSFX stop:)
		((ScriptID 220 0) setScript: 0 cue:) ; forest
		(gEgo setScript: 0)
		(if (gCast contains: sprite)
			(sprite setScript: 0 dispose: delete:)
		)
		(if (gCast contains: bag)
			(bag dispose: delete:)
		)
		(LoadMany 0 181 185)
	)
)

