;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 455)
(include sci.sh)
(use Main)
(use n013)
(use GKTeller)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm455 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm455 of Room
	(properties
		noun 1
		picture 99
		style 14
		exitStyle 0
	)

	(method (init)
		(= local1 (ScriptID 0 1)) ; globeCursor
		(local1 view: 968)
		(super init:)
		(gWalkHandler addToFront: self)
		(self setScript: sEnter)
		(if (== gPrevRoomNum 800) ; Hounfour
			(gGkMusic1
				number: 450
				setLoop: -1
				stop:
				play:
				setVol: (/ (gGkMusic1 musicVolume:) 2)
			)
		)
		(if (IsFlag 273)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 172 122 172 103 168 103 168 122
						yourself:
					)
			)
			(confessional setLoop: 0 init: setScript: sConfess)
			(bench1 init:)
			(shelf1 init:)
			(knothole init:)
			(pWindow init:)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 144 122 147 122 147 101 144 101
						yourself:
					)
			)
			(confessional posn: 179 50 setLoop: 1 init: setScript: sConfess)
			(pWindow posn: 181 63 setCel: 0 setLoop: 5 init:)
			(bench2 init:)
			(shelf2 init:)
		)
	)

	(method (doVerb)
		(if (confessional onMe: gMouseX (- gMouseY 10))
			(return 0)
		else
			(gEgo setScript: sExitElevator)
			(return 1)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(DisposeScript 920)
		(DisposeScript 51)
		(super dispose:)
	)
)

(instance sExitElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self setScript: sGabeStands self 0)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: MoveTo 160 121 self)
			)
			(2
				(if (and (IsFlag 273) (IsFlag 271))
					(gCurRoom newRoom: 800) ; Hounfour
				else
					(gCurRoom newRoom: 450)
				)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsFlag 273)
					(gEgo
						view: 900
						posn: 168 118
						init:
						state: 2
						setScale: 0
						setCycle: StopWalk -1
						setMotion: MoveTo 168 110 self
					)
				else
					(gEgo
						normalize: 3
						posn: 145 118
						init:
						state: 2
						setScale: 0
						setMotion: MoveTo 145 110 self
					)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoToInterrogates of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 8 77 7 0 self) ; "Can I ask you a few questions?"
			)
			(1
				(= global178 42)
				(gCurRoom newRoom: 50) ; interrogation
			)
		)
	)
)

(instance sGabeUsesKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local0
					(self setScript: sGabeStands self 0)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 170 103 self)
			)
			(2
				(if (not (IsFlag 272))
					(if (gTalkers size:)
						(gMessager cue: 1)
					)
					(gEgo getPoints: -999 3)
					(gMessager say: 5 76 15 1 self) ; "(TO HIMSELF. PONDERING)Something about this knothole looks familiar."
				else
					(gMessager say: 5 76 17) ; "(TO HIMSELF. NERVOUS)I think I've got everything I need. Might as well see it through."
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(3
				(gEgo view: 455 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo normalize: 3 setMotion: PolyPath 170 111 self)
			)
			(6
				(Face gEgo 0 111 self)
			)
			(7
				(= cycles 2)
			)
			(8
				(if (IsFlag 271)
					(self changeState: 12)
				else
					(gGkMusic1 fade: (/ (gGkMusic1 musicVolume:) 2) 1 10 0)
					(ShakeScreen 3 ssUPDOWN)
					(gEgo hide:)
					(knothole hide:)
					(pWindow hide:)
					(gGkSound1 setLoop: -1 number: 803 play:)
					(confessional
						view: 4551
						setPri: 10
						posn: 160 123
						setCel: 8
						setLoop: 0
						setCycle: End self
					)
					(UpdateScreenItem confessional)
				)
			)
			(9
				(if (not (IsFlag 272))
					(gMessager say: 5 76 15 2) ; "(ACTIVATES SECRET ELEVATOR. EXCITED)It's moving! I knew it!"
				)
				(confessional setCel: 0 setCycle: CT 1 1)
				(= seconds 6)
			)
			(10
				(confessional setCycle: CT 8 1 self)
			)
			(11
				(gEgo show:)
				(knothole show:)
				(pWindow show:)
				(confessional
					posn: 136 50
					view: 455
					setCel: 0
					setLoop: 0
					setPri: -1
					setCycle: 0
				)
				(if (not (IsFlag 272))
					(if (gTalkers size:)
						(gMessager cue: 1)
					)
					(gMessager say: 5 76 15 3) ; "(APPREHENSIVE)Ride's over."
				)
				(ShakeScreen 3 ssUPDOWN)
				(SetFlag 272)
				(SetFlag 271)
				(gGame handsOn:)
				(gGkSound1 stop:)
				(self dispose:)
			)
			(12
				(gEgo z: 1000)
				(ShakeScreen 3 ssUPDOWN)
				(confessional
					posn: 160 123
					view: 4551
					setPri: 10
					setCel: 8
					setLoop: 0
					setCycle: CT 1 -1 self
				)
			)
			(13
				(= seconds 6)
			)
			(14
				(confessional setCel: 0)
				(= cycles 1)
			)
			(15
				(confessional setCel: 12 setCycle: CT 8 -1 self)
			)
			(16
				(confessional
					posn: 136 50
					view: 455
					setCel: 0
					setLoop: 0
					setPri: -1
					setCycle: 0
				)
				(ShakeScreen 3 ssUPDOWN)
				(ClearFlag 271)
				(gEgo z: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGabeKneels of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: 0 setLooper: 0)
				(= cycles 2)
			)
			(1
				(= local0 1)
				(if (IsFlag 273)
					(= local4 0)
					(gEgo setMotion: PolyPath 168 110 self)
				else
					(= local4 1)
					(gEgo setMotion: PolyPath 145 110 self)
				)
			)
			(2
				(gEgo
					view: 456
					setCel: 0
					setLoop: local4 1
					setCycle: End self
				)
			)
			(3
				(gWalkHandler add: confessional)
				(= cycles 2)
			)
			(4
				(if register
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sGabeStands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 273)
					(= local4 2)
				else
					(= local4 3)
				)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 456
					setCel: 0
					setLoop: local4 1
					setCycle: End self
				)
			)
			(2
				(gEgo normalize: (if (IsFlag 273) 1 else 0))
				(gWalkHandler delete: confessional)
				(= cycles 2)
			)
			(3
				(= local0 0)
				(if register
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sConfess of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (== gPrevRoomNum 50) (== gDay 10)) ; interrogation
					(self dispose:)
				else
					(= seconds 10)
				)
			)
			(1
				(if (gEgo script:)
					(-- state)
					(= cycles 1)
				else
					(gGame handsOff:)
					(pWindow setCycle: End self)
				)
			)
			(2
				(gMessager say: 6 0 4 0 self) ; "May I help you, my child?"
				(if (not local0)
					(if (IsFlag 273)
						(Face gEgo bench1)
					else
						(Face gEgo bench2)
					)
				)
			)
			(3
				(priestTeller init: confessional doVerb: 11)
			)
			(4
				(pWindow setCycle: Beg)
				(priestTeller dispose:)
				(if local0
					(gGame handsOff:)
					(self setScript: sGabeStands self 0)
				else
					(= cycles 1)
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRandomBlessings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not local0)
					(self setScript: sGabeKneels self 0)
				else
					(= cycles 1)
				)
			)
			(1
				(gMessager say: 8 77 5 0 self) ; "(IN CONFESSIONAL)Could you give me a blessing?"
			)
			(2
				(cond
					((and (not (IsFlag 413)) (not (IsFlag 414)))
						(gMessager say: 8 77 25 0 self) ; "(CONCERNED)Do you feel the need for a blessing, Son?"
						(SetFlag 413)
					)
					((and (IsFlag 413) (not (IsFlag 414)))
						(gMessager say: 8 77 26 0 self) ; "(CONCERNED)Are you in trouble, my child?"
						(SetFlag 414)
						(ClearFlag 413)
					)
					((and (not (IsFlag 413)) (IsFlag 414))
						(gMessager say: 8 77 28 0 self) ; "(CONCERNED)Would that comfort you, Son?"
						(SetFlag 413)
					)
					((and (IsFlag 413) (IsFlag 414))
						(gMessager say: 8 77 31 0 self) ; "The priest blesses Gabriel through the confessional window."
					)
				)
			)
			(3
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance sRandomConfessions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not local0)
					(self setScript: sGabeKneels self 0)
				else
					(= cycles 1)
				)
			)
			(1
				(gMessager say: 8 77 6 0 self) ; "I'd like to make a confession."
			)
			(2
				(gMessager
					say:
						6
						0
						(switch (Random 0 5)
							(0 3)
							(1 8)
							(2 9)
							(3 10)
							(4 11)
							(5 12)
						)
						0
						self
				)
			)
			(3
				(gMessager say: 6 0 13 0 self) ; "(ENDING CONFESSION)Is there anything else?"
			)
			(4
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance sStowStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 170 119 self)
			)
			(1
				(Face gEgo 0 100 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo view: 455 setCel: 0 setLoop: 3 setCycle: CT 6 1 self)
				(cond
					((== register 76)
						(gMessager say: 2 register 20) ; "Gabriel puts the snake rod under the bench for Mosely."
					)
					((IsFlag 280)
						(gMessager say: 2 register 20)
					)
					(else
						(gMessager say: 2 register 35)
					)
				)
			)
			(4
				(= seconds 2)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(gEgo getPoints: -999 1)
				(gEgo normalize: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pWindow of Prop
	(properties
		noun 3
		x 134
		y 63
		view 455
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (IsFlag 271)
					(gMessager say: noun theVerb 22) ; "(RRCC)Through the mesh Gabriel can see a solid wood wall."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(9 ; Move
				(if (IsFlag 271)
					(gMessager say: noun theVerb 22) ; "(RRCC)There's nothing of interest beyond the meshed window that would make that action worthwhile."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(6 ; Open
				(if (IsFlag 271)
					(gMessager say: noun theVerb 22) ; "(RRCC)There's nothing of interest beyond the meshed window that would make that action worthwhile."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(8 ; Operate
				(if (IsFlag 271)
					(gMessager say: noun theVerb 22) ; "(RRCC)There's nothing of interest beyond the meshed window that would make that action worthwhile."
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(60 ; signalDev_ or signalDev2_
				(if (IsFlag 272)
					(gMessager say: 1 theVerb 20) ; "The signal device would be out in plain sight there."
				else
					(gMessager say: 1 theVerb 29) ; "Gabriel has no reason to leave the signal device here."
				)
				(return 1)
			)
			(76 ; rod
				(if (IsFlag 272)
					(gMessager say: 1 theVerb 20) ; "The snake rod would be out in plain sight there."
				else
					(gMessager say: 1 theVerb 29) ; "Gabriel has no reason to leave the snake rod here."
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance confessional of Prop
	(properties
		noun 1
		x 136
		y 50
		view 455
		signal 16417
		cycleSpeed 12
	)

	(method (doit)
		(FrameOut)
		(super doit:)
		(if (and (gUser canControl:) (gUser canInput:))
			(if (self onMe: gMouseX (- gMouseY 10))
				(if local3
					(= local3 0)
					(gGame setCursor: local2 1)
				)
			else
				(if (!= gTheCursor local1)
					(= local2 gTheCursor)
					(gGame setCursor: local1 1)
				)
				(= local3 1)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(gGame handsOff:)
				(gCurRoom setScript: sGabeStands 0 1)
			)
			(7 ; Look
				(if (and (IsFlag 273) (IsFlag 272))
					(gMessager say: noun theVerb 20) ; "This confessional has turned out to be an express elevator to Hell."
				else
					(super doVerb: theVerb)
				)
			)
			(60 ; signalDev_ or signalDev2_
				(if (IsFlag 272)
					(gMessager say: noun theVerb 20) ; "The signal device would be out in plain sight there."
				else
					(gMessager say: noun theVerb 29) ; "Gabriel has no reason to leave the signal device here."
				)
				(return 1)
			)
			(76 ; rod
				(if (IsFlag 272)
					(gMessager say: noun theVerb 20) ; "The snake rod would be out in plain sight there."
				else
					(gMessager say: noun theVerb 29) ; "Gabriel has no reason to leave the snake rod here."
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shelf1 of Feature
	(properties
		noun 4
		nsTop 62
		nsRight 9
		nsBottom 88
		sightAngle 20
		approachX 248
		approachY 124
		x 11
		y 179
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 144 79 151 78 151 82 142 89 132 92 132 86
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(60 ; signalDev_ or signalDev2_
				(if (IsFlag 272)
					(gMessager say: 1 theVerb 20) ; "The signal device would be out in plain sight there."
				else
					(gMessager say: 1 theVerb 29) ; "Gabriel has no reason to leave the signal device here."
				)
				(return 1)
			)
			(76 ; rod
				(if (IsFlag 272)
					(gMessager say: 1 theVerb 20) ; "The snake rod would be out in plain sight there."
				else
					(gMessager say: 1 theVerb 29) ; "Gabriel has no reason to leave the snake rod here."
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bench1 of Feature
	(properties
		noun 2
		nsTop 62
		nsRight 9
		nsBottom 88
		sightAngle 20
		approachX 248
		approachY 124
		x 11
		y 179
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 139 113 151 97 159 97 161 106 155 121 139 121
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(cond
					((and (IsFlag 280) (IsFlag 281))
						(gMessager say: noun theVerb 34) ; "It's a cushioned kneeler."
					)
					((and (IsFlag 280) (not (IsFlag 281)))
						(gMessager say: noun theVerb 32) ; "It's a cushioned kneeler."
					)
					((and (not (IsFlag 280)) (IsFlag 281))
						(gMessager say: noun theVerb 33) ; "It's a cushioned kneeler."
					)
					((and (not (IsFlag 280)) (not (IsFlag 281)))
						(gMessager say: noun theVerb 0) ; "It's a cushioned kneeler."
					)
				)
				(return 1)
			)
			(12 ; Pickup
				(if (or (IsFlag 280) (IsFlag 281))
					(gMessager say: noun theVerb 18) ; "Gabriel can't take the kneeler, and the items under it should be left for Mosely."
				else
					(gMessager say: noun theVerb 0) ; "Gabriel can't take the kneeler."
				)
				(return 1)
			)
			(60 ; signalDev_ or signalDev2_
				(if (IsFlag 272)
					(gEgo put: (gInventory indexOf: (gTheIconBar curInvIcon:)))
					(SetFlag 281)
					(gCurRoom setScript: sStowStuff 0 theVerb)
				else
					(gMessager say: noun theVerb 29) ; "Gabriel has no reason to leave the signal device here."
				)
				(return 1)
			)
			(76 ; rod
				(if (IsFlag 272)
					(gEgo put: 60) ; rod
					(SetFlag 280)
					(gCurRoom setScript: sStowStuff 0 theVerb)
				else
					(gMessager say: noun theVerb 29) ; "Gabriel has no reason to leave the snake rod here."
				)
				(return 1)
			)
			(8 ; Operate
				(if (not (IsFlag 272))
					(gGame handsOff:)
					(if local0
						(gCurRoom setScript: sGabeStands 0 1)
					else
						(gCurRoom setScript: sGabeKneels 0 1)
					)
				else
					(gMessager say: 2 8 22) ; "(RRCC)Kneeling is probably not a great idea down here. Who know WHAT deity Gabriel would be supplicating to!"
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shelf2 of Feature
	(properties
		noun 4
		nsTop 62
		nsRight 9
		nsBottom 88
		sightAngle 20
		approachX 248
		approachY 124
		x 311
		y 179
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 173 89 165 82 163 79 172 79 182 87 182 91
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(60 ; signalDev_ or signalDev2_
				(if (IsFlag 272)
					(gMessager say: 1 theVerb 20) ; "The signal device would be out in plain sight there."
				else
					(gMessager say: 1 theVerb 29) ; "Gabriel has no reason to leave the signal device here."
				)
				(return 1)
			)
			(76 ; rod
				(if (IsFlag 272)
					(gMessager say: 1 theVerb 20) ; "The snake rod would be out in plain sight there."
				else
					(gMessager say: 1 theVerb 29) ; "Gabriel has no reason to leave the snake rod here."
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bench2 of Feature
	(properties
		noun 2
		nsTop 62
		nsRight 9
		nsBottom 88
		sightAngle 20
		approachX 248
		approachY 124
		x 311
		y 179
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 177 113 175 120 161 119 152 107 156 97 164 97
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(60 ; signalDev_ or signalDev2_
				(gMessager say: noun theVerb 29) ; "Gabriel has no reason to leave the signal device here."
				(return 1)
			)
			(76 ; rod
				(gMessager say: noun theVerb 29) ; "Gabriel has no reason to leave the snake rod here."
				(return 1)
			)
			(8 ; Operate
				(gGame handsOff:)
				(if local0
					(gCurRoom setScript: sGabeStands 0 1)
				else
					(gCurRoom setScript: sGabeKneels 0 1)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance knothole of View
	(properties
		noun 5
		x 172
		y 51
		z 1
		priority 2
		view 455
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(76 ; rod
				(gEgo setScript: sGabeUsesKey)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mySetCursor of Code ; UNUSED
	(properties)

	(method (doit param1 param2 param3)
		(= local2 gTheCursor)
		(gTheCursor view: param1 loop: param2 cel: param3)
	)
)

(instance priestTeller of GKTeller
	(properties
		curNoun 7
		sayNoun 8
		verb 77
	)

	(method (dispose)
		(local1 view: 968)
		(super dispose:)
	)

	(method (showCases)
		(super showCases: 7 (not (IsFlag 395))) ; Can I ask you a few questions?
	)

	(method (cue)
		(switch iconValue
			(24 ; No, thank you.
				(sConfess cue:)
			)
			(7 ; Can I ask you a few questions?
				(SetFlag 395)
				(self doVerb: 11)
			)
			(else
				(self doVerb: 11)
			)
		)
	)

	(method (sayMessage)
		(switch iconValue
			(6 ; I'd like to make a confession.
				(sConfess setScript: sRandomConfessions)
			)
			(5 ; Could you give me a blessing?
				(sConfess setScript: sRandomBlessings)
			)
			(else
				(super sayMessage:)
			)
		)
	)
)

