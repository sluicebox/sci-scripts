;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use Interface)
(use arcadaRegion)
(use Elevator)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm11 0
)

(local
	local0
	local1
)

(instance rm11 of Rm
	(properties
		lookStr {This is the airlock of the Arcada.}
		picture 11
		east 12
	)

	(method (init)
		(LoadMany rsVIEW 9 111)
		(= global166 2)
		(if (not (IsFlag 16))
			(helmet init: stopUpd:)
			(spaceSuit init: stopUpd:)
		)
		(drawerFeature init:)
		(drawerButton init:)
		(BayButton init:)
		(controlPanel init:)
		(control setCycle: Fwd init:)
		(if (IsFlag 10)
			(lights setCycle: Fwd)
		)
		(lights init:)
		(if (proc700_1 553 128)
			(closetDoor init: ignoreActors: 1 cel: 6 stopUpd:)
			(helmet approachVerbs: 3 2) ; Do, Look
			(spaceSuit approachVerbs: 3 2) ; Do, Look
		else
			(closetDoor init: stopUpd:)
		)
		(drawer init: stopUpd:)
		(bigRedDoor init: setCel: (bigRedDoor lastCel:) approachVerbs: 3) ; Do
		(self
			setRegions: 700 ; arcadaRegion
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 4 100 22 100 22 113 4 115 4 126 14 150 58 179 93 187 172 187 294 150 289 135 255 126 218 107 194 104 195 92 218 84 173 76 127 89 121 86 78 97 98 105 72 112 56 108 48 112 38 114 35 98 6 98 6 0 319 0 319 189 0 189 0 0 4 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 91 162 89 156 116 147 164 170 161 178 145 183 131 183
					yourself:
				)
		)
		(gEgo init: illegalBits: 0)
		(super init:)
		(if (== gPrevRoomNum 12)
			(HandsOff)
			(self setScript: enterFromHanger)
		)
		(elevatorDoor
			exiting: (if (!= gPrevRoomNum 12) 1 else 0)
			light: doorLight
			init:
			setPri: 7
			whereTo: 10
		)
		(if (!= (gLongSong number:) 355)
			(gLongSong number: 323 loop: -1 play:)
		)
	)

	(method (dispose)
		(if (!= (gLongSong number:) 355)
			(gLongSong loop: 0 fade:)
		)
		(super dispose:)
	)

	(method (doit)
		(cond
			(script 0)
			((elevatorDoor inFront:)
				(elevatorDoor open:)
			)
		)
		(super doit:)
	)

	(method (notify)
		(if (== gPrevRoomNum 10)
			(HandsOff)
		)
	)
)

(instance putOnSpacesuit of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== (gEgo loop:) 1)
				(== (gEgo cel:) 2)
				(gCast contains: spaceSuit)
			)
			(spaceSuit _approachVerbs: 26505 dispose:)
		)
		(if
			(and
				(== (gEgo loop:) 2)
				(== (gEgo cel:) 3)
				(gCast contains: helmet)
			)
			(helmet _approachVerbs: 26505 dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 2 136)
				(gEgo
					view: 9
					setLoop: 1
					cycleSpeed: 8
					cel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(2
				(closetDoor setCycle: Beg self)
				((ScriptID 700 0) rFlag1: (& ((ScriptID 700 0) rFlag1:) $ff7f)) ; arcadaRegion, arcadaRegion
			)
			(3
				(gSoundEffects stop:)
				(closetDoor stopUpd:)
				(NormalEgo 3 1 61)
				(SetFlag 16)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance leaveToHanger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 ((gEgo cycler:) vWalking:))
				(= local1 ((gEgo cycler:) vStopped:))
				(gEgo
					view: 9
					setLoop: (if (== local0 0) 6 else 7)
					cel: 0
					setCycle: End self
				)
			)
			(1
				(gSoundEffects number: 311 loop: 1 play:)
				(gLongSong2 number: 322 loop: 1 play:)
				(bigRedDoor setCycle: Beg self)
			)
			(2
				(gEgo setPri: (bigRedDoor priority:) setCycle: Beg self)
			)
			(3
				(NormalEgo)
				(bigRedDoor setPri: (- (gEgo priority:) 1))
				(gEgo
					ignoreActors: 1
					view: local0
					setCycle: StopWalk local1
					setMotion: MoveTo 220 114 self
				)
			)
			(4
				(gEgo setMotion: MoveTo 272 114 self)
			)
			(5
				(gSoundEffects number: 311 loop: 1 play:)
				(bigRedDoor setPri: -1 setCycle: End self)
				(if (IsFlag 10)
					(gLongSong2 fade:)
				)
				(gEgo setPri: -1 setMotion: MoveTo 306 114 self)
			)
			(6 0)
			(7
				(gEgo illegalBits: $8000 ignoreActors: 0)
				(gCurRoom newRoom: 12)
			)
		)
	)
)

(instance enterFromHanger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					posn: 306 114
					setPri: (- (bigRedDoor priority:) 1)
					setMotion: MoveTo 260 114 self
				)
			)
			(1
				(gSoundEffects number: 311 loop: 1 play:)
				(bigRedDoor setCycle: Beg self)
			)
			(2
				(gEgo setPri: -1 setMotion: MoveTo 213 114 self)
			)
			(3
				(gSoundEffects number: 311 loop: 1 play:)
				(bigRedDoor setCycle: End self)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openClosetDoor of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== (gEgo loop:) 1)
				(== (gEgo cel:) 1)
				(not (gCast contains: spaceSuit))
			)
			(spaceSuit init: stopUpd:)
		)
		(if
			(and
				(== (gEgo loop:) 2)
				(== (gEgo cel:) 3)
				(not (gCast contains: helmet))
			)
			(helmet init: stopUpd:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo
					view: 9
					setLoop: (if (IsFlag 16) 5 else 0)
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(gSoundEffects number: 318 loop: 1 play:)
				(gEgo setCycle: Beg)
				(closetDoor setCycle: End self)
			)
			(3
				(gSoundEffects stop:)
				((ScriptID 700 0) rFlag1: (| ((ScriptID 700 0) rFlag1:) $0080)) ; arcadaRegion, arcadaRegion
				(closetDoor ignoreActors: 1)
				(if (IsFlag 16)
					(NormalEgo 0 1 61)
					(gEgo setMotion: PolyPath 159 80 self)
				else
					(if (not (proc700_1 553 64))
						(Print 11 0) ; "A spacesuit hangs in the closet. A helmet sits on the top shelf."
						((ScriptID 700 0) ; arcadaRegion
							rFlag1: (| ((ScriptID 700 0) rFlag1:) $0040) ; arcadaRegion
						)
					)
					(helmet approachVerbs: 3 2) ; Do, Look
					(spaceSuit approachVerbs: 3 2) ; Do, Look
					(NormalEgo 3 0 60)
					(= cycles 3)
				)
			)
			(4
				(if (IsFlag 16)
					(gEgo
						view: 9
						setLoop: 2
						cel: 10
						cycleSpeed: 8
						setCycle: Beg self
					)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(5
				(gEgo setLoop: 1 cel: 15 setCycle: Beg self)
			)
			(6
				(closetDoor setCycle: Beg self)
				((ScriptID 700 0) rFlag1: (& ((ScriptID 700 0) rFlag1:) $ff7f)) ; arcadaRegion, arcadaRegion
				(ClearFlag 16)
				(NormalEgo 3 0 60)
			)
			(7
				(gSoundEffects stop:)
				(closetDoor stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 9
					loop: (if (IsFlag 16) 4 else 3)
					cel: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(gSoundEffects number: 330 loop: 1 play:)
				(drawer setCycle: (if (drawer cel:) Beg else End) self)
			)
			(2
				(cond
					((not (drawer cel:))
						(gEgo setCycle: Beg self)
					)
					((not (gEgo has: 2)) ; Gadget
						(Print 11 1) ; "You notice some sort of gadget in the drawer."
						(gEgo get: 2 setCycle: End self) ; Gadget
						(SetScore 2 137)
						(= state -1)
					)
					(else
						(Print 11 2) ; "There is nothing inside the drawer. You push the button and the drawer slides neatly back into place."
						(= cycles 3)
						(= state 0)
					)
				)
			)
			(3
				(HandsOn)
				(if (IsFlag 16)
					(NormalEgo 3 1 61)
				else
					(NormalEgo 3 0 60)
				)
				(self dispose:)
			)
		)
	)
)

(instance spaceSuit of View
	(properties
		x 137
		y 76
		description {space suit}
		sightAngle 45
		approachX 159
		approachY 80
		lookStr {A space suit hangs in the closet. It won't be used by anyone else on the ship anymore.}
		view 111
		loop 7
		priority 2
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (closetDoor cel:)
					(gCurRoom setScript: putOnSpacesuit)
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

(instance helmet of View
	(properties
		x 135
		y 29
		description {helmet}
		sightAngle 45
		approachX 159
		approachY 80
		lookStr {It's a fish bowl - no, it's a space suit helmet!.}
		view 111
		loop 7
		cel 1
		priority 2
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(spaceSuit doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorLight of View
	(properties
		description {elevator light.}
		sightAngle 45
		lookStr {This elevator indicator points up.}
		view 111
		loop 1
	)
)

(instance bigRedDoor of Prop
	(properties
		x 229
		y 105
		description {big door.}
		sightAngle 45
		approachX 245
		approachY 121
		lookStr {These large red doors serve as the airlock entrance which empties out to the pod bay.}
		view 111
		loop 4
		priority 6
		signal 16401
		cycleSpeed 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: leaveToHanger)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drawer of Prop
	(properties
		x 91
		y 90
		z 22
		description {drawer}
		approachX 122
		approachY 96
		lookStr {A small drawer is located just beneath a button.}
		view 111
		loop 3
		cycleSpeed 8
	)

	(method (init)
		(self approachVerbs: 3 2) ; Do, Look
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: openDrawer)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance closetDoor of Prop
	(properties
		x 136
		y 81
		description {closet door}
		approachX 154
		approachY 86
		lookStr {The image on the closet door looks familiar, but you can't quite place it.}
		view 111
		loop 2
		priority 3
		signal 16
		cycleSpeed 5
	)

	(method (init)
		(self approachVerbs: 3 2) ; Do, Look
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (not cel)
					(HandsOff)
					(gCurRoom setScript: openClosetDoor)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (setCycle)
		(super setCycle: &rest)
		(gSoundEffects number: 329 loop: 1 play:)
	)

	(method (cue)
		(gSoundEffects stop:)
	)
)

(instance lights of Prop
	(properties
		x 134
		y 167
		z 28
		description {lights}
		approachX 111
		approachY 173
		lookStr {Flashing lights adorn this strange yet familiar-looking console.}
		view 111
		loop 6
		priority 13
		signal 16400
		cycleSpeed 20
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2) ; Look
	)
)

(instance control of Prop
	(properties
		x 123
		y 168
		z 19
		description {control}
		approachX 111
		approachY 173
		lookStr {It doesn't do anything but it sure looks cool.}
		view 111
		loop 5
		priority 12
		signal 16400
		cycleSpeed 24
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 3) ; Look, Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(controlPanel doVerb: theVerb &rest)
			)
			(3 ; Do
				(controlPanel doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance elevatorDoor of Elevator
	(properties
		x 30
		y 109
		description {door}
		sightAngle 45
		lookStr {This is another elevator door. This one goes up.}
		view 111
		cycleSpeed 4
		level 2
	)
)

(instance controlPanel of Feature
	(properties
		x 160
		y 100
		nsBottom 190
		nsRight 320
		description {controlPanel}
		sightAngle 45
		onMeCheck 4
		approachX 111
		approachY 173
		lookStr {The control panel has many confusing gauges on it. The only one you can read says "CAUTION: LAUNCH BAY DECOMPRESSED!"}
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 3) ; Look, Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 11 3) ; "There are no controls on this panel. It is populated only by gauges and read-outs."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drawerButton of Feature
	(properties
		x 101
		y 89
		z 34
		nsTop 50
		nsLeft 96
		nsBottom 61
		nsRight 106
		description {drawer}
		sightAngle 45
		onMeCheck 2
		approachX 122
		approachY 96
		lookStr {There is a button above the rectangular object below.}
	)

	(method (init)
		(self approachVerbs: 3 2) ; Do, Look
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (!= theVerb 2) ; Look
			(drawer doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance BayButton of Feature
	(properties
		x 265
		y 125
		z 31
		nsTop 88
		nsLeft 261
		nsBottom 101
		nsRight 269
		description {BayButton}
		sightAngle 45
		onMeCheck 8
		approachX 245
		approachY 121
		lookStr {This button might have some function involving the adjacent doors.}
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 2 3) ; Look, Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: leaveToHanger)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drawerFeature of Feature
	(properties
		description {drawer}
		onMeCheck 16
		lookStr {You notice a drawer and a button.}
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		)
		(super doVerb: theVerb &rest)
	)
)

