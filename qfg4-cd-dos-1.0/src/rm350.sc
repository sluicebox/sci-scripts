;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 350)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use Array)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm350 0
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
	local8 = 4
	local9
	local10
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(if param1
		(if global450
			(for ((= temp0 0)) (< temp0 global450) ((++ temp0))
				(cond
					((OneOf temp0 0 1 6 7)
						(= temp1 0)
					)
					((OneOf temp0 2 3)
						(= temp1 1)
					)
					(else
						(= temp1 2)
					)
				)
				(local2
					at:
						temp0
						((weight new:)
							init:
							cel: temp1
							x: (local3 at: temp0)
							y: (local4 at: temp0)
							setPri: 0
							ignoreActors:
							approachVerbs: 4 ; Do
							yourself:
						)
				)
			)
		)
	else
		(= local7 0)
		(ClearFlag 271)
		((local2 at: (- global450 1)) dispose:)
		((local2 at: (- global450 2)) dispose:)
		(= global450
			(cond
				((< global451 20) 6)
				((< global451 30) 4)
				((< global451 40) 2)
				((< global451 50) 0)
				(else 0)
			)
		)
	)
	(= local8 (- 4 (/ global450 2)))
)

(instance rm350 of GloryRm
	(properties
		picture 350
		east 250
		rightY 162
	)

	(method (init)
		(gEgo normalize: init:)
		(if (== gPrevRoomNum 340)
			(gEgo view: 352 setLoop: 0 1 cel: 10 posn: 248 86 setScale: 0)
		else
			(= local0 272)
			(= local1 161)
			(gEgo posn: 335 162 setScale: 0)
		)
		(= local2 (IDArray new: 8))
		(= local3 (IntArray with: 93 110 101 98 103 93 107 99))
		(= local4 (IntArray with: 133 132 135 138 138 135 128 126))
		(gLongSong number: 350 setLoop: -1 play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 180 319 189 0 189 0 0 319 0 319 145 288 145 275 152 163 147 163 139 147 138 147 142 83 142 83 138 5 146 15 180
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 23 157 58 147 96 147 96 171 23 171
					yourself:
				)
		)
		(if (IsFlag 169)
			(emptyCase init: approachVerbs: 4) ; Do
		else
			(swordCase init: approachVerbs: 4) ; Do
		)
		(if (IsFlag 190)
			(rope init: approachVerbs: 4) ; Do
		)
		(if
			(and
				(!= gHeroType 1) ; Magic User
				(not (IsFlag 525))
				(not (IsFlag 475))
				(not (IsFlag 507))
			)
			(ropeGrapnel init: approachVerbs: 4) ; Do
		)
		(secretDoor init: loop: (if (IsFlag 181) 3 else 2) approachVerbs: 4) ; Do
		(localproc_0 1)
		(stepperRope init: approachVerbs: 4) ; Do
		(weightsOnFloor1 init: approachVerbs: 4) ; Do
		(weightsOnFloor2 init: approachVerbs: 4) ; Do
		(floorHole init: approachVerbs: 4) ; Do
		(floorHole2 init: approachVerbs: 4) ; Do
		(mooseHead init: approachVerbs: 4) ; Do
		(moose2 init: approachVerbs: 4) ; Do
		(wallCrack1 init: approachVerbs: 4) ; Do
		(wallCrack2 init: approachVerbs: 4) ; Do
		(wallCrack3 init: approachVerbs: 4) ; Do
		(bigRing init: approachVerbs: 4) ; Do
		(pulleys init: approachVerbs: 4) ; Do
		(hooks init: approachVerbs: 4) ; Do
		(pen init: approachVerbs: 4) ; Do
		(painting1 init: approachVerbs: 4) ; Do
		(painting2 init: approachVerbs: 4) ; Do
		(desk init: approachVerbs: 4) ; Do
		(book init: approachVerbs: 4) ; Do
		(stepper init: approachVerbs: 4) ; Do
		(ceilingCrack init: approachVerbs: 4) ; Do
		(ewer1 init: approachVerbs: 4) ; Do
		(ewer2 init: approachVerbs: 4) ; Do
		(bookShelf init: approachVerbs: 4) ; Do
		(tableCorner init: approachVerbs: 4) ; Do
		(pillar init: approachVerbs: 4) ; Do
		(ceilingHole init: approachVerbs: 4) ; Do
		(super init: &rest)
		(if (== gPrevRoomNum 340)
			(self setScript: sClimbDown)
		else
			(self setScript: sEnterScr)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(104 ; Sleep all night
				(gMessager say: 23 6 50) ; "The dust is far too thick here for you to sleep without having an asthma attack."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (newRoom)
		(gLongSong fade: 0)
		(super newRoom: &rest)
	)

	(method (dispose)
		(local2 dispose:)
		(local3 dispose:)
		(local4 dispose:)
		(super dispose: &rest)
	)
)

(instance sGetWeights of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 4 setLoop: 0 1 cel: 0 setCycle: End self)
			)
			(1
				(localproc_0 0)
				(gMessager say: 26 4 15 0 self) ; "You pick up two of the metal weights and put one in each of the baskets."
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo local0 local1 self)
			)
			(2
				(if (not (IsFlag 438))
					(gEgo solvePuzzle: 438 6)
				)
				(gEgo normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBustCase of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo trySkill: 0 300) ; strength
				(= cycles 2)
			)
			(1
				(gMessager say: 28 164 6 0 self) ; "You break open the front of the case. Avoiding the broken glass, you pull out the sword. It looks like a fine quality weapon."
			)
			(2
				(gEgo
					view: 31
					loop: 0
					cel: 0
					posn: 175 146
					setCycle: CT 2 1 self
				)
			)
			(3
				(emptyCase view: 350 loop: 1 cel: 0 init: setCycle: End self)
				(gEgo setCycle: CT 1 -1 self)
			)
			(4 0)
			(5
				(gEgo setCycle: CT 2 1 self)
			)
			(6
				(SetFlag 168)
				(SetFlag 169)
				(emptyCase loop: 0 cel: 0)
				(= temp0 (gInventory at: 19)) ; theSword
				(temp0 state: 1 loop: 0 cel: 0)
				(gEgo get: 19) ; theSword
				(temp0 amount: 1)
				(gEgo setCycle: CT 0 -1 self)
			)
			(7
				(gEgo normalize: 6)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThrowRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 68 140 self)
			)
			(1
				(Face gEgo (bigRing x:) (bigRing y:) self)
			)
			(2
				(= cycles 8)
			)
			(3
				(= local6 (gEgo cycleSpeed:))
				(SetFlag 190)
				(gEgo use: 16) ; theGrapnel
				(gEgo
					view: 8
					loop: 0
					cel: 0
					posn: 75 140
					cycleSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(4
				(= cycles 8)
			)
			(5
				(gEgo view: 8 loop: 0 cel: 0 setCycle: End self)
			)
			(6
				(rope
					view: 8
					loop: 6
					cel: 0
					init:
					cycleSpeed: 8
					setCycle: End self
				)
				(gEgo view: 8 loop: 7 cel: 0 setCycle: End self)
			)
			(7 0)
			(8
				(rope approachVerbs: 4) ; Do
				(gEgo posn: 68 140 normalize: 0 cycleSpeed: local6)
				(= local6 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHkPuzzle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 86 0) init: show: dispose:) ; hookBar
				(= cycles 1)
			)
			(1
				(DisposeScript 86)
				(if (IsFlag 181)
					(gGlory handsOff:)
					(secretDoor setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(if (IsFlag 181)
					(secretDoor loop: 3)
					(gGlory handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sClimbBookcase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local6 (gEgo cycleSpeed:))
				(gEgo
					view: 7
					setLoop: 3 1
					cel: 0
					posn: 245 148
					setSpeed: 10
					useSkill: 11 200 ; climbing
					useStamina: 10
					setCycle: Walk
					setMotion: MoveTo 246 97 self
				)
			)
			(1
				(gEgo
					view: 352
					setLoop: -1
					loop: 0
					cel: 0
					posn: 248 86
					setSpeed: local6
					setCycle: End self
				)
			)
			(2
				(gEgo cycleSpeed: local6)
				(gGlory handsOn:)
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance sClimbRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGlory handsOff:)
				(SetFlag 50)
				(= local6 (gEgo cycleSpeed:))
				(gEgo
					view: 7
					loop: 0
					cel: 0
					setPri: 170
					setSpeed: 10
					posn: 139 154
					setCycle: End self
				)
			)
			(1
				1
				(gEgo useSkill: 11 160) ; climbing
				(gEgo useStamina: 10)
				(if (< [gEgoStats 11] 200) ; climbing
					(= state 11)
				)
				(gEgo loop: 1 cel: 0 posn: 139 137 setCycle: End self)
			)
			(2
				2
				(gEgo cel: 0 posn: 139 122 setCycle: End self)
			)
			(3
				3
				(if (and [gEgoStats 9] [gEgoStats 8] (not (IsFlag 181))) ; pick locks, stealth
					(if (IsFlag 170)
						(self changeState: 7)
					else
						(= local9 1)
						(ceilingMark
							init:
							posn: 138 25
							moveSpeed: 0
							setStep: 10 10
							setLoop: 0 1
							setScaler: Scaler 100 5 98 24
							setMotion: MoveTo 65 96 self
						)
					)
				else
					(= cycles 1)
				)
			)
			(4
				4
				(if local9
					(SetFlag 170)
					(gGlory handsOn:)
					(gNarrator y: 10)
					(gMessager say: 24 1 22 0 self) ; "Someone has deliberately scraped these marks into the ceiling."
				else
					(gMessager say: 29 4 46 0 self) ; "Well, that was fun. Now you feel like climbing something even higher... like Mount Tarna."
				)
			)
			(5
				5
				(if local9
					(gNarrator y: -1)
					(gKeyDownHandler addToFront: ceilingMark)
					(gMouseDownHandler addToFront: ceilingMark)
				else
					(= cycles 1)
				)
			)
			(6
				6
				(if local9
					(gGlory handsOff:)
					(gKeyDownHandler delete: ceilingMark)
					(gMouseDownHandler delete: ceilingMark)
					(ceilingMark setMotion: MoveTo 138 25 self)
				else
					(= cycles 1)
				)
			)
			(7
				7
				(if (and local9 (gCast contains: ceilingMark))
					(= local9 0)
					(ceilingMark dispose:)
				)
				(gEgo setCycle: Beg self)
			)
			(8
				8
				(gEgo cel: 5 posn: 139 137 setCycle: Beg self)
			)
			(9
				9
				(gEgo cel: 5 posn: 139 154 setCycle: Beg self)
			)
			(10
				10
				(gEgo loop: 0 cel: 4 setCycle: Beg self)
			)
			(11
				11
				(gEgo normalize: 3 setSpeed: local6)
				(= local6 0)
				(gGlory handsOn:)
				(ClearFlag 50)
				(self dispose:)
			)
			(12
				12
				(= state 7)
				(gMessager say: 29 4 21 0 self) ; "That was good climbing practice, but you haven't quite got it yet. Keep trying."
			)
		)
	)
)

(instance sLookUnderDesk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 157 144 self)
			)
			(1
				(gEgo setHeading: 90 self)
			)
			(2
				(gEgo
					view: 4
					loop: 0
					cel: 0
					posn: 151 144
					setPri: 30
					setCycle: End self
				)
			)
			(3
				(SetFlag 50)
				(deskMark
					init:
					moveSpeed: 0
					setStep: 10 10
					setLoop: 1 1
					setPri: 31
					setScaler: Scaler 5 100 121 2
					setMotion: MoveTo 154 121 self
				)
			)
			(4
				(deskMark setPri: 196 setMotion: MoveTo 65 2 self)
			)
			(5
				(gKeyDownHandler addToFront: deskMark)
				(gMouseDownHandler addToFront: deskMark)
				(gGlory handsOn:)
			)
			(6
				(gGlory handsOff:)
				(gKeyDownHandler delete: deskMark)
				(gMouseDownHandler delete: deskMark)
				(deskMark setMotion: MoveTo 154 121 self)
			)
			(7
				(SetFlag 172)
				(deskMark setPri: 31 setMotion: MoveTo 179 121 self)
			)
			(8
				(gEgo setCycle: Beg self)
			)
			(9
				(deskMark dispose:)
				(gEgo normalize: 0 posn: 157 144)
				(gGlory handsOn:)
				(ClearFlag 50)
				(self dispose:)
			)
		)
	)
)

(instance sStepper of Script
	(properties)

	(method (init)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (OneOf (event type:) evKEYBOARD $0020 evMOUSEBUTTON) (OneOf state 1 3 4)) ; joyUp
			(self changeState: 6)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(gGlory handsOff:)
				(= local6 (gEgo cycleSpeed:))
				(switch gHeroType
					(3 ; Paladin
						(if (not (IsFlag 527))
							(gEgo solvePuzzle: 527 6 8)
						)
					)
					(0 ; Fighter
						(if (not (IsFlag 477))
							(gEgo solvePuzzle: 477 2 1)
						)
					)
				)
				(gEgo setPri: 162 setMotion: MoveTo 50 159 self)
			)
			(1
				1
				(gGlory handsOn:)
				(cond
					((IsFlag 204)
						(= local10 1)
						(gMessager say: 14 4 49 0 self) ; "There's only a certain amount of punishment your body can stand on any given day. Enough pain, enough gain for now; try again tomorrow."
					)
					((IsFlag 271)
						(= local10 1)
						(gMessager say: 14 4 11 0 self) ; "This is a little too easy now. You need to add more weight."
					)
					((>= global451 50)
						(= local10 1)
						(gMessager say: 14 4 10 0 self) ; "You think you've done about as much stair-stepping as your body can handle."
					)
					((< [gEgoStats 18] 65) ; stamina
						(= local10 1)
						(gMessager say: 14 4 12 0 self) ; "Your legs are too stiff and sore to use this right now."
					)
					((< [gEgoStats 0] 200) ; strength
						(= local10 1)
						(gMessager say: 14 4 5 0 self) ; "Hmm, you always thought those stair-stepper things were supposed to go down when you stepped on them. Maybe you'd better take a little weight out of the baskets."
					)
					(
						(and
							(== (/ global451 10) (- 5 (/ global450 2)))
							(not (mod global451 10))
						)
						(= local10 1)
						(SetFlag 271)
						(SetFlag 204)
						(gMessager say: 14 4 49 0 self) ; "There's only a certain amount of punishment your body can stand on any given day. Enough pain, enough gain for now; try again tomorrow."
					)
					(else
						(++ local7)
						(= cycles 1)
					)
				)
			)
			(2
				2
				(if local10
					(= local10 0)
					(self changeState: 6)
				else
					(= cycles 1)
				)
			)
			(3
				3
				(gEgo
					view: 351
					setLoop: 3 1
					cel: 0
					posn: 50 159
					setPri: 160
					setSpeed: local7
					setCycle: Fwd
				)
				(weightsOnFloor1 cycleSpeed: local7 setCycle: Fwd)
				(weightsOnFloor2 cycleSpeed: local7 setCycle: Fwd)
				(stepperRope hide:)
				(= cycles (+ local7 10))
			)
			(4
				4
				(++ global451)
				(gEgo useStamina: (+ (* local7 5) 12))
				(if (< [gEgoStats 0] 400) ; strength
					(++ [gEgoStats 0]) ; strength
				)
				(gEgo setCycle: End self)
			)
			(5
				5
				(self changeState: 1)
			)
			(6
				6
				(gGlory handsOff:)
				(weightsOnFloor1 setCycle: 0)
				(weightsOnFloor2 setCycle: 0)
				(stepperRope show:)
				(gEgo
					normalize: 6
					setPri: 162
					setSpeed: local6
					setMotion: MoveTo 38 171 self
				)
			)
			(7
				7
				(gEgo setPri: -1)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance sGetGrapnel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(switch gHeroType
					(3 ; Paladin
						(gEgo solvePuzzle: 525 2 8)
					)
					(0 ; Fighter
						(gEgo solvePuzzle: 475 2 1)
					)
					(2 ; Thief
						(gEgo solvePuzzle: 507 2 4)
					)
				)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 4
					loop: 1
					cel: 0
					posn: 155 142
					setCycle: End self
				)
			)
			(2
				(ropeGrapnel hide:)
				(gEgo get: 16 setCycle: Beg self) ; theGrapnel
			)
			(3
				(gMessager say: 27 4 17 0 self) ; "You pick up the rope-and-grapnel set and tie it onto your pack."
			)
			(4
				(gEgo normalize: posn: 149 142)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sClimbDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local6 (gEgo cycleSpeed:))
				(gEgo cycleSpeed: 8 setCycle: Beg self)
			)
			(1
				(gEgo
					view: 7
					setLoop: 3 1
					cel: 0
					posn: 246 97
					setSpeed: 10
					setCycle: Walk
					setMotion: MoveTo 245 148 self
				)
			)
			(2
				(gEgo normalize: 3 setSpeed: local6 setHeading: 180 self)
			)
			(3
				(gEgo setMotion: MoveTo 245 160 self)
			)
			(4
				(gEgo cycleSpeed: local6)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance swordTeller of Teller
	(properties
		actionVerb 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 168)
					(gMessager say: 11 1 1) ; "Well, you sure made a mess of that sword case. Now it fits right in with the rest of the room."
					(return 1)
				else
					(gMessager say: 11 1 0) ; "A finely-crafted sword rests within this case, but there doesn't seem to be a door or any way to open the case."
					(return 1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (showCases)
		(super
			showCases:
				1 ; Close Case
				(IsFlag 168)
				8 ; Examine Case
				(IsFlag 168)
				7 ; Examine Case
				(not (IsFlag 168))
				5 ; Force Case Open
				(and
					(not
						(and (gEgo has: 19) (== ((gInventory at: 19) state:) 3)) ; theSword, theSword
					)
					(not
						(and (gEgo has: 19) (== ((gInventory at: 19) state:) 2)) ; theSword, theSword
					)
					(< [gEgoStats 0] 300) ; strength
				)
				6 ; Break Case Open
				(and
					(not
						(and (gEgo has: 19) (== ((gInventory at: 19) state:) 2)) ; theSword, theSword
					)
					(not
						(and (gEgo has: 19) (== ((gInventory at: 19) state:) 3)) ; theSword, theSword
					)
					(not (IsFlag 168))
					(OneOf gHeroType 0 3) ; Fighter, Paladin
				)
				4 ; Pry Case Open
				(and
					(not
						(and (gEgo has: 19) (== ((gInventory at: 19) state:) 2)) ; theSword, theSword
					)
					(not
						(and (gEgo has: 19) (== ((gInventory at: 19) state:) 3)) ; theSword, theSword
					)
					(OneOf gHeroType 2 1) ; Thief, Magic User
				)
				9 ; Open Case
				(and
					(not
						(and (gEgo has: 19) (== ((gInventory at: 19) state:) 3)) ; theSword, theSword
					)
					(not
						(and (gEgo has: 19) (== ((gInventory at: 19) state:) 2)) ; theSword, theSword
					)
					(not (IsFlag 168))
				)
				43 ; Open Case
				(and
					(gEgo has: 19) ; theSword
					(== ((gInventory at: 19) state:) 2) ; theSword
					(not (IsFlag 168))
				)
				47 ; Open Case
				(and
					(gEgo has: 19) ; theSword
					(== ((gInventory at: 19) state:) 3) ; theSword
					(not (IsFlag 168))
				)
		)
	)

	(method (sayMessage)
		(switch iconValue
			(6 ; Break Case Open
				(self clean:)
				(gCurRoom setScript: sBustCase)
			)
			(5 ; Force Case Open
				(gEgo trySkill: 0 300) ; strength
				(super sayMessage: &rest) ; Are you kidding? You have trouble forcing a mayonnaise jar open, let alone a heavy case. You'll need to build up your strength before you can get through this one.
			)
			(9 ; Open Case
				(gEgo trySkill: 0 300) ; strength
				(super sayMessage: &rest) ; The case is totally sealed. You can't find any way to open it.
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance bookTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super
			showCases:
				24 ; Search Under Desk
				(and (IsFlag 170) (not (IsFlag 181)))
				25 ; Sign Logbook
				(not (IsFlag 171))
		)
	)

	(method (sayMessage)
		(switch iconValue
			(24 ; Search Under Desk
				(self clean:)
				(gCurRoom setScript: sLookUnderDesk)
			)
			(25 ; Sign Logbook
				(SetFlag 171)
				(gEgo solvePuzzle: 439 2)
				(super sayMessage: &rest) ; You sign your name into the Adventurers' Logbook with a flourish; it's almost become a habit by now.
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance shelfTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super
			showCases:
				27 ; Climb Bookshelf
				(IsFlag 172)
				37 ; Read "Essential Exercise" Again
				(IsFlag 173)
				36 ; Read "Climbing Skills" Again
				(IsFlag 174)
				38 ; Read "Creative Casting" Again
				(IsFlag 175)
				35 ; Read "Essential Exercise"
				(and (not (IsFlag 173)) (OneOf gHeroType 0 3)) ; Fighter, Paladin
				2 ; Read "Climbing Skills"
				(and (OneOf gHeroType 0 3) (== [gEgoStats 11] 0)) ; Fighter, Paladin, climbing
				33 ; Read "Creative Casting"
				(and [gEgoStats 12] (not (IsFlag 175))) ; magic
		)
	)

	(method (sayMessage)
		(switch iconValue
			(27 ; Climb Bookshelf
				(if (IsFlag 181)
					(self clean:)
					(gCurRoom setScript: sClimbBookcase)
				else
					(super sayMessage: &rest) ; You climb up to the top of the bookshelf. There doesn't seem to be anything interesting up there, so you climb back down. The picture frame at the top really is empty. So what is it doing there?
				)
			)
			(2 ; Read "Climbing Skills"
				(SetFlag 174)
				(switch gHeroType
					(3 ; Paladin
						(gEgo solvePuzzle: 526 6 8)
					)
					(0 ; Fighter
						(gEgo solvePuzzle: 476 2 1)
					)
				)
				(+= [gEgoStats 11] 100) ; climbing
				(super sayMessage: &rest) ; You read the book entitled "Climbing Skills for Upwardly-Mobile Adventurers." It's written entirely in one-syllable words, obviously intended for Fighters. It's absolutely fascinating.
			)
			(35 ; Read "Essential Exercise"
				(SetFlag 173)
				(+= [gEgoStats 0] 20) ; strength
				(super sayMessage: &rest) ; This book teaches you how to use the stair-stepper to build strong leg muscles and talks about the importance of whole-body development. It says to build up your strength gradually by adding weights to the baskets.
			)
			(33 ; Read "Creative Casting"
				(SetFlag 175)
				(+= [gEgoStats 12] 25) ; magic
				(super sayMessage: &rest) ; The book is all about using spells in unusual and creative ways, such as "Calming" a fire, using alternating Flame and Frost spells to make something brittle and break, and so on. You pick up a number of useful tips which will improve your spellcasting.
			)
			(31 ; Read "HERO" Magazine
				(SetFlag 176)
				(SetFlag 177)
				(super sayMessage: &rest) ; As you scan through "HERO: The Journal of General Job Adjusting," you find quite a bit of information that might be useful here.
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance ropeTeller of Teller
	(properties
		actionVerb 4
	)

	(method (sayMessage)
		(switch iconValue
			(19 ; Take Rope & Grapnel
				(self clean:)
				(gEgo get: 16) ; theGrapnel
				(ClearFlag 190)
				(rope dispose:)
			)
			(2 ; Climb Rope
				(if [gEgoStats 11] ; climbing
					(self clean:)
					(gCurRoom setScript: sClimbRope)
				else
					(super sayMessage: &rest) ; That was an interesting exercise... in frustration. You really haven't a clue about how to climb.
				)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance ceilingMark of Actor
	(properties
		x 138
		y 25
		priority 196
		fixPriority 1
		view 354
		signal 16385
		illegalBits 0
	)

	(method (handleEvent event)
		(if (OneOf (event type:) evMOUSEBUTTON $0020 evKEYBOARD) ; joyUp
			((gCurRoom script:) cue:)
			(event claimed: 1)
			(return 1)
		)
		(return 0)
	)
)

(instance deskMark of Actor
	(properties
		x 179
		y 121
		fixPriority 1
		view 354
		loop 1
		signal 16385
		illegalBits 0
	)

	(method (handleEvent event)
		(if (OneOf (event type:) evMOUSEBUTTON $0020 evKEYBOARD) ; joyUp
			((gCurRoom script:) cue:)
			(event claimed: 1)
			(return 1)
		)
		(return 0)
	)
)

(instance stepperRope of View
	(properties
		noun 14
		approachX 38
		approachY 171
		x 53
		y 161
		priority 160
		fixPriority 1
		view 351
		loop 4
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sStepper)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ropeGrapnel of View
	(properties
		noun 27
		approachX 149
		approachY 142
		x 117
		y 139
		priority 38
		fixPriority 1
		view 350
		loop 4
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 27 1 17) ; "This is a long, sturdy-looking rope with a grapnel hook attached to one end."
			)
			(4 ; Do
				(gCurRoom setScript: sGetGrapnel)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance weight of View
	(properties
		noun 26
		approachX 75
		approachY 138
		view 351
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((IsFlag 204)
						(gMessager say: 26 4 49) ; "You consider placing a few more weights in the baskets, but think better of it. You've done enough stepping for today."
					)
					(
						(and
							(IsFlag 271)
							(> (/ global451 10) local8)
							(not (mod global451 10))
						)
						(gCurRoom setScript: sGetWeights)
					)
					(else
						(gMessager say: 26 4 10) ; "Any more weight might strain your muscles! Try working with the weights you have in the baskets already."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance emptyCase of Prop
	(properties
		noun 11
		sightAngle 180
		approachX 176
		approachY 146
		x 202
		y 111
		fixPriority 1
		view 350
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(= actions (swordCase actions:))
	)
)

(instance rope of Prop
	(properties
		noun 29
		sightAngle 180
		approachX 140
		approachY 143
		x 129
		y 87
		priority 160
		fixPriority 1
		view 8
		loop 6
		cel 7
		signal 16385
	)

	(method (init)
		(super init: &rest)
		(ropeTeller init: self 350 28 165)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 27 1 18) ; "The grapnel is caught in the big ring with the rope dangling down from it."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(ropeTeller dispose:)
		(super dispose: &rest)
	)
)

(instance weightsOnFloor1 of Prop
	(properties
		noun 14
		approachX 38
		approachY 171
		x 59
		y 18
		priority 161
		fixPriority 1
		view 351
		loop 1
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sStepper)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance weightsOnFloor2 of Prop
	(properties
		noun 14
		approachX 38
		approachY 171
		x 76
		y 18
		priority 161
		fixPriority 1
		view 351
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sStepper)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance secretDoor of Prop
	(properties
		noun 12
		sightAngle 180
		approachX 245
		approachY 148
		x 251
		y 64
		view 350
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 181)
					(gMessager say: 12 1 48) ; "By moving the hooks around, you have opened a secret passage!"
				else
					(super doVerb: theVerb &rest)
				)
			)
			(4 ; Do
				(if (IsFlag 181)
					(gCurRoom setScript: sClimbBookcase)
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

(instance floorHole of Feature
	(properties
		noun 2
		nsLeft 106
		nsTop 165
		nsRight 158
		nsBottom 172
		sightAngle 180
		x 132
		y 168
	)
)

(instance floorHole2 of Feature
	(properties
		noun 2
		nsLeft 21
		nsTop 180
		nsRight 138
		nsBottom 189
		sightAngle 180
		x 79
		y 184
	)
)

(instance mooseHead of Feature
	(properties
		noun 1
		nsLeft 11
		nsTop 41
		nsRight 54
		nsBottom 97
		sightAngle 180
		x 32
		y 69
	)
)

(instance moose2 of Feature
	(properties
		noun 1
		nsLeft 54
		nsTop 48
		nsRight 80
		nsBottom 65
		sightAngle 180
		x 67
		y 56
	)
)

(instance wallCrack1 of Feature
	(properties
		noun 3
		nsLeft 16
		nsTop 119
		nsRight 42
		nsBottom 134
		sightAngle 180
		x 29
		y 126
	)
)

(instance wallCrack2 of Feature
	(properties
		noun 3
		nsLeft 129
		nsTop 84
		nsRight 140
		nsBottom 109
		sightAngle 180
		x 134
		y 96
	)
)

(instance wallCrack3 of Feature
	(properties
		noun 3
		nsLeft 139
		nsTop 44
		nsRight 169
		nsBottom 70
		sightAngle 180
		x 154
		y 57
	)
)

(instance bigRing of Feature
	(properties
		noun 4
		nsLeft 130
		nsTop 30
		nsRight 154
		nsBottom 45
		sightAngle 180
		approachX 143
		approachY 159
		x 142
		y 87
		z 50
	)

	(method (doVerb theVerb)
		(switch theVerb
			(33 ; theGrapnel
				(gCurRoom setScript: sThrowRope)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pulleys of Feature
	(properties
		noun 5
		nsLeft 45
		nsTop 10
		nsRight 79
		nsBottom 23
		sightAngle 180
		x 72
		y 33
	)
)

(instance hooks of Feature
	(properties
		noun 6
		nsLeft 290
		nsTop 111
		nsRight 306
		nsBottom 118
		sightAngle 180
		approachX 287
		approachY 154
		x 298
		y 114
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if [gEgoStats 9] ; pick locks
					(if (IsFlag 181)
						(gMessager say: 6 4 40) ; "You've already opened the secret passage."
					else
						(gCurRoom setScript: sHkPuzzle)
					)
				else
					(gMessager say: 6 4 0) ; "All of the hooks are empty."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pen of Feature
	(properties
		noun 7
		nsLeft 204
		nsTop 103
		nsRight 212
		nsBottom 120
		sightAngle 180
		x 208
		y 111
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 171)
					(gMessager say: 7 4 44) ; "Signature only, please. Only the Guildmaster is allowed to make other logbook entries."
				else
					(SetFlag 171)
					(gMessager say: 7 4 25) ; "You sign your name into the Adventurers' Logbook with a flourish; it's almost become a habit by now."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance painting1 of Feature
	(properties
		noun 9
		nsLeft 175
		nsTop 83
		nsRight 189
		nsBottom 99
		sightAngle 180
		x 182
		y 91
	)
)

(instance painting2 of Feature
	(properties
		noun 10
		nsLeft 184
		nsTop 64
		nsRight 196
		nsBottom 79
		sightAngle 180
		x 190
		y 71
	)
)

(instance swordCase of Feature
	(properties
		noun 11
		nsLeft 192
		nsTop 84
		nsRight 204
		nsBottom 110
		sightAngle 180
		approachX 176
		approachY 146
		x 198
		y 97
	)

	(method (init)
		(super init: &rest)
		(swordTeller init: self 350 28 164)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(171 ; theHammer
				(cond
					((IsFlag 168)
						(gMessager say: 11 171 1) ; "Hammer you already done enough to the sword case?"
					)
					((OneOf gHeroType 2 1) ; Thief, Magic User
						(gMessager say: 11 171 45) ; "You don't really know anything about sword fighting -- if you had to use one you'd probably end up a sword loser."
					)
					((and (gEgo has: 19) (== ((gInventory at: 19) state:) 2)) ; theSword, theSword
						(gMessager say: 11 171 43) ; "The sword in the case is pretty nice as swords go, but it really doesn't look as though it's as good a weapon as your battle axe. You might as well stick with what you have."
					)
					((and (gEgo has: 19) (== ((gInventory at: 19) state:) 3)) ; theSword, theSword
						(gMessager say: 11 171 47) ; "You think about retrieving the sword from the case, but then you realize that the weapon you already brandish is MUCH more extravagant."
					)
					((< [gEgoStats 0] 300) ; strength
						(gEgo trySkill: 0 300) ; strength
						(gMessager say: 11 171 5) ; "The heavy iron hammer ought to be pretty good for breaking glass, but somehow you aren't quite getting it. You think you should be able to manage it once you build up your strength some more."
					)
					(else
						(gCurRoom setScript: sBustCase)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance desk of Feature
	(properties
		noun 13
		nsLeft 173
		nsTop 122
		nsRight 212
		nsBottom 146
		sightAngle 180
		x 192
		y 134
	)

	(method (init)
		(super init: &rest)
		(bookTeller init: self 350 28 166)
	)
)

(instance book of Feature
	(properties
		noun 8
		nsLeft 175
		nsTop 115
		nsRight 206
		nsBottom 122
		sightAngle 180
		x 190
		y 118
	)

	(method (init)
		(super init: &rest)
		(= actions bookTeller)
	)
)

(instance stepper of Feature
	(properties
		noun 14
		nsLeft 30
		nsTop 129
		nsRight 77
		nsBottom 169
		sightAngle 180
		approachX 38
		approachY 171
		x 53
		y 149
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sStepper)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ceilingCrack of Feature
	(properties
		noun 15
		nsLeft 110
		nsTop 7
		nsRight 121
		nsBottom 26
		sightAngle 180
		x 115
		y 16
	)
)

(instance ewer1 of Feature
	(properties
		noun 16
		nsLeft 224
		nsTop 161
		nsRight 294
		nsBottom 189
		sightAngle 180
		x 259
		y 175
	)
)

(instance ewer2 of Feature
	(properties
		noun 17
		nsLeft 284
		nsTop 131
		nsRight 319
		nsBottom 189
		sightAngle 180
		x 301
		y 160
	)
)

(instance bookShelf of Feature
	(properties
		noun 18
		nsLeft 210
		nsTop 63
		nsRight 290
		nsBottom 149
		sightAngle 180
		approachX 245
		approachY 148
		x 250
		y 106
	)

	(method (init)
		(super init: &rest)
		(shelfTeller init: self 350 28 163)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (>= local5 6)
					(= local5 1)
				else
					(++ local5)
				)
				(gMessager say: 18 1 0 local5)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tableCorner of Feature
	(properties
		noun 20
		nsLeft 166
		nsTop 166
		nsRight 224
		nsBottom 189
		sightAngle 180
		x 195
		y 177
	)
)

(instance pillar of Feature
	(properties
		noun 21
		nsLeft 99
		nsTop 48
		nsRight 137
		nsBottom 134
		sightAngle 180
		x 118
		y 91
	)
)

(instance ceilingHole of Feature
	(properties
		noun 22
		nsLeft 126
		nsRight 152
		nsBottom 13
		sightAngle 180
		x 139
		y 6
	)
)

