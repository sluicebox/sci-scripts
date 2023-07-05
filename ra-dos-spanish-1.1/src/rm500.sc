;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use eRS)
(use ExitFeature)
(use MuseumRgn)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm500 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm500 of LBRoom
	(properties
		noun 40
		picture 500
		north 420
		south 510
		vanishingX 0
	)

	(method (init)
		(LoadMany rsVIEW 500 504 505 831)
		(Load rsPIC 501)
		(Load rsSOUND 501 19)
		(if (IsFlag 4)
			(Load rsSOUND 502)
		)
		(if (or (> gAct 4) (and (== gAct 4) (TimeCheck $3104 1))) ; can 3:15 am occur?
			(LoadMany rsPIC 556 505)
			(LoadMany rsSOUND 500 3 6 84)
		)
		(gEgo
			init:
			normalize: (if (== gAct 5) 426 else 831)
			setScale: Scaler 100 0 190 0
		)
		(self setRegions: 90) ; MuseumRgn
		(gGame handsOff:)
		(switch gPrevRoomNum
			(north
				(gEgo x: 103 y: 159 setHeading: 180)
				(cond
					((== gAct 5)
						(self setScript: sLauraDies)
					)
					((and (== gAct 3) (TimeCheck $2140) (not (IsFlag 85))) ; has 2:15 am occurred?
						(if (== ((ScriptID 90 1) room:) gCurRoomNum) ; aCountess
							((ScriptID 90 1) moveTo: -2) ; aCountess
						)
						(if (== ((ScriptID 90 2) room:) gCurRoomNum) ; aOlympia
							((ScriptID 90 2) moveTo: -2) ; aOlympia
						)
						(self setScript: sMeeting)
					)
					(else
						(self setScript: sEnterNorth)
					)
				)
			)
			(south
				(gEgo x: 260 y: 200 setHeading: 315)
				(self setScript: sEnterSouth)
			)
			(else
				(gEgo posn: 78 176)
				(gGame handsOn:)
			)
		)
		(super init:)
		(if (and (== gAct 3) (TimeCheck $2140) (not (IsFlag 85))) ; has 2:15 am occurred?
			(= local3 ((ScriptID 90 3) room:)) ; aORiley
			((ScriptID 90 3) ; aORiley
				originalView: 818
				view: 818
				moveTo: gCurRoomNum
				posn: 227 179
				setLoop: 8
				setCel: 1
			)
			((ScriptID 32 0) ; aHeimlich
				originalView: 814
				room: gCurRoomNum
				init:
				posn: 206 179
				setLoop: 8
				setCel: 0
			)
			(WrapMusic pause:)
			(gGameMusic2 number: 350 loop: -1 flags: 1 play:)
		)
		(if (or (> gAct 4) (and (== gAct 4) (TimeCheck $3104 1))) ; can 3:15 am occur?
			(yvetteStatue init: stopUpd:)
			(gCurRoom
				addObstacle:
					(= local1
						((Polygon new:)
							type: PBarredAccess
							init: 135 183 180 183 191 189 142 189
							yourself:
						)
					)
			)
		)
		(if (not (gEgo has: 8)) ; skeletonKey
			(keyGlint init: approachVerbs: 4 1 8 setScript: sKeyGlint) ; Do, Look, magnifier
		)
		(bobPortrait init:)
		(rickPortrait init:)
		(leftWall init:)
		(dennisPortrait init:)
		(suziPortrait init:)
		(boschPortrait init:)
		(erwinPortrait init:)
		(johnPortrait init:)
		(bench init:)
		(sculpture1 init:)
		(sculpture2 init:)
		(ceiling init:)
		(borderCeiling init:)
		(southExitFeature init:)
	)

	(method (newRoom newRoomNumber)
		(cond
			((and (== gAct 3) (IsFlag 85) (TimeCheck $0080))
				(= newRoomNumber 26) ; actBreak
			)
			((== gAct 2)
				(gGameMusic2 stop:)
				(gGameMusic1 pause: 0)
			)
			((or (> gAct 4) (and (== gAct 4) (TimeCheck $3104 1))) ; can 3:15 am occur?
				(local1 dispose:)
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 2)
				(gEgo edgeHit: EDGE_TOP)
				(self newRoom: north)
			)
		)
	)
)

(instance sLauraDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 152 166 self)
			)
			(1
				(Face gEgo oRiley)
				(oRiley
					init:
					view: 423
					posn: 99 150
					setScale: 165
					setHeading: 180
					setCycle: StopWalk -1
					setMotion: PolyPath 124 161 self
				)
			)
			(2
				(oRiley
					view: 424
					posn: (+ (oRiley x:) 4) (oRiley y:)
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(gEgo setMotion: 0 view: 858 setLoop: 4 setCycle: End self)
				(sFX number: 80 flags: 5 play:)
			)
			(4
				(= ticks 60)
			)
			(5
				(= global145 0) ; "You came in thinking like a journalist, and you left with a skull full of mush."
				(gCurRoom newRoom: 99) ; deathRoom
				(self dispose:)
			)
		)
	)
)

(instance oRiley of Actor
	(properties
		x 227
		y 179
		view 818
		loop 8
		cel 1
	)
)

(instance yvetteStatue of Prop
	(properties
		x 150
		y 141
		noun 8
		approachX 185
		approachY 187
		view 504
		priority 15
		signal 16
	)

	(method (init)
		(if (or (> gAct 4) (and (== gAct 4) (TimeCheck $3104))) ; has 3:15 am occurred?
			(self cel: 8 stopUpd:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29 ; dinoBone
				(if
					(not
						(or
							(> gAct 4)
							(and (== gAct 4) (TimeCheck $3104)) ; has 3:15 am occurred?
						)
					)
					(if (MuseumRgn nobodyAround:)
						(gCurRoom setScript: sSmashPlaster)
					else
						(return 1)
					)
				)
			)
			(1 ; Look
				(if (== (yvetteStatue cel:) (yvetteStatue lastCel:))
					(gCurRoom setScript: sDeadYvette)
				else
					(gMessager say: 8 1) ; "The subject of this sculpture looks curiously familiar."
				)
			)
			(8 ; magnifier
				(if (== (yvetteStatue cel:) (yvetteStatue lastCel:))
					(gCurRoom setScript: sDeadYvette)
				else
					(gMessager say: 8 8) ; "The sculpture gives off a strong smell of fresh plaster."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance keyGlint of Prop
	(properties
		x 267
		y 116
		noun 20
		view 500
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; magnifier
				(gCurRoom setScript: sBoschPainting)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance keyGlintInset of Prop
	(properties
		x 198
		y 91
		noun 21
		view 500
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; magnifier
				(inBoschPainting setInset: inSkeletonKey)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lauraSwingingRt of Actor ; UNUSED
	(properties
		x 185
		y 187
		view 504
		loop 1
		cel 8
	)
)

(instance lauraSwingingLt of Actor ; UNUSED
	(properties
		x 136
		y 185
		view 504
		loop 2
		cel 9
	)
)

(instance bobPortrait of Feature
	(properties
		x 50
		y 128
		noun 2
		nsTop 106
		nsLeft 33
		nsBottom 151
		nsRight 67
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 24 4) ; "When you touch the painting, you smear a bit of the paint as if it's still damp!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rickPortrait of Feature
	(properties
		x 153
		y 113
		noun 4
		nsTop 102
		nsLeft 136
		nsBottom 124
		nsRight 170
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 24 4) ; "When you touch the painting, you smear a bit of the paint as if it's still damp!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftWall of Feature
	(properties
		y 1
		noun 7
		sightAngle 40
		onMeCheck 4
	)
)

(instance dennisPortrait of Feature
	(properties
		x 200
		y 1
		noun 3
		sightAngle 40
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 24 4) ; "When you touch the painting, you smear a bit of the paint as if it's still damp!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance suziPortrait of Feature
	(properties
		x 240
		y 1
		noun 5
		sightAngle 40
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 24 4) ; "When you touch the painting, you smear a bit of the paint as if it's still damp!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance boschPortrait of Feature
	(properties
		x 270
		y 100
		noun 9
		sightAngle 40
		onMeCheck 16
	)
)

(instance skeletonKey of Feature ; UNUSED
	(properties
		x 270
		y 100
		noun 17
		sightAngle 40
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: sBoschPainting)
			)
			(8 ; magnifier
				(gCurRoom setScript: sBoschPainting)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance erwinPortrait of Feature
	(properties
		x 380
		y 100
		noun 6
		sightAngle 40
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 24 4) ; "When you touch the painting, you smear a bit of the paint as if it's still damp!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance johnPortrait of Feature
	(properties
		x 380
		y 160
		noun 1
		sightAngle 40
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 24 4) ; "When you touch the painting, you smear a bit of the paint as if it's still damp!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bench of Feature
	(properties
		y 1
		noun 10
		sightAngle 40
		onMeCheck 128
	)
)

(instance sculpture1 of Feature
	(properties
		y 1
		noun 11
		sightAngle 40
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 25 4) ; "It's an expensive work of art on display in a museum. Your father would be appalled if he knew you wanted to touch it. Overcoming your temporary insanity, you change your mind."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sculpture2 of Feature
	(properties
		y 1
		noun 12
		sightAngle 40
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 25 4) ; "It's an expensive work of art on display in a museum. Your father would be appalled if he knew you wanted to touch it. Overcoming your temporary insanity, you change your mind."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ceiling of Feature
	(properties
		y 1
		noun 13
		sightAngle 40
		onMeCheck 2048
	)
)

(instance borderCeiling of Feature
	(properties
		y 1
		noun 14
		sightAngle 40
		onMeCheck 4096
	)
)

(instance inDeadYvette of Inset
	(properties
		picture 505
		priority 12
	)

	(method (init)
		(super init: &rest)
		(= local2 gDoVerbCode)
		(= gDoVerbCode exitDoVerbCode)
		(proc0_8 1)
		(gWalkHandler addToFront: self)
		(gTheIconBar disable: 7)
		(if (not (gEgo has: 26)) ; bifocals
			(bifocals init:)
		)
		(if (not (gEgo has: 27)) ; redHair
			(redHair init:)
		)
		(feHair init:)
		(feScarf init:)
		(feFace init:)
		(feDress init:)
		(feCleavage init:)
		(feBody init:)
		(feLtHand init:)
		(feRtHand init:)
		(feTowel init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(= gDoVerbCode local2)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(gTheIconBar enable: 7)
		(super dispose:)
	)
)

(instance exitDoVerbCode of Code
	(properties)

	(method (doit param1 param2)
		(if (== param1 13)
			(= gDoVerbCode local2)
			(inDeadYvette dispose:)
		else
			(proc0_6 param2 param1)
		)
	)
)

(instance bifocals of View
	(properties
		x 102
		y 156
		noun 22
		view 505
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; magnifier
				(if (not (gEgo has: 26)) ; bifocals
					(inDeadYvette setInset: inBifocals)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance inBifocals of Inset
	(properties
		view 505
		loop 1
		x 90
		y 135
		disposeNotOnMe 1
		noun 37
	)

	(method (init)
		(super init: &rest)
		(if (not (gEgo has: 26)) ; bifocals
			(bifocals hide:)
			(viBifocals init:)
		)
	)
)

(instance viBifocals of View
	(properties
		x 103
		y 156
		noun 38
		view 505
		loop 1
		cel 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame points: 1 162)
				((ScriptID 21 0) doit: 795) ; addCluesCode, Bifocals
				(gEgo get: 26) ; bifocals
				(bifocals dispose:)
				(inBifocals dispose:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (not (gEgo has: 26)) ; bifocals
			(bifocals show:)
		)
		(super dispose:)
	)
)

(instance redHair of View
	(properties
		x 161
		y 152
		noun 23
		view 505
		loop 2
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; magnifier
				(if (not (gEgo has: 27)) ; redHair
					(inDeadYvette setInset: inRedHair)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance inRedHair of Inset
	(properties
		view 505
		loop 3
		x 144
		y 146
		disposeNotOnMe 1
		noun 35
	)

	(method (init)
		(super init: &rest)
		(if (not (gEgo has: 27)) ; redHair
			(redHair hide:)
			(viRedHair init:)
		)
	)
)

(instance viRedHair of View
	(properties
		x 155
		y 155
		noun 39
		view 505
		loop 3
		cel 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame points: 1 160)
				(gEgo get: 27) ; redHair
				((ScriptID 21 0) doit: 796) ; addCluesCode, Red Hair
				(redHair dispose:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (not (gEgo has: 27)) ; redHair
			(redHair show:)
		)
		(super dispose:)
	)
)

(instance feHair of Feature
	(properties
		y 1
		noun 29
		sightAngle 40
		onMeCheck 16384
	)
)

(instance feScarf of Feature
	(properties
		y 1
		noun 30
		sightAngle 40
		onMeCheck 8192
	)
)

(instance feFace of Feature
	(properties
		y 1
		noun 31
		sightAngle 40
		onMeCheck 4096
	)
)

(instance feDress of Feature
	(properties
		y 1
		noun 32
		sightAngle 40
		onMeCheck 2048
	)
)

(instance feCleavage of Feature
	(properties
		y 1
		noun 33
		sightAngle 40
		onMeCheck 1024
	)
)

(instance feBody of Feature
	(properties
		y 1
		noun 34
		sightAngle 40
		onMeCheck 512
	)
)

(instance feLtHand of Feature
	(properties
		y 1
		noun 35
		sightAngle 40
		onMeCheck 256
	)
)

(instance feRtHand of Feature
	(properties
		y 1
		noun 36
		sightAngle 40
		onMeCheck 128
	)
)

(instance feTowel of Feature
	(properties
		y 1
		noun 37
		sightAngle 40
		onMeCheck 64
	)
)

(instance inBoschPainting of Inset
	(properties
		picture 501
		hideTheCast 1
		noun 19
	)

	(method (init)
		(super init: &rest)
		(proc0_8 1)
		(gWalkHandler addToFront: self)
		(if (not (gEgo has: 8)) ; skeletonKey
			(keyGlintInset init: setScript: sKeyGlintInset)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)
)

(instance inSkeletonKey of Inset
	(properties
		view 500
		loop 1
		x 179
		y 93
		disposeNotOnMe 1
		noun 18
	)

	(method (doVerb theVerb)
		(switch theVerb
			(22 ; daggerOfRa
				(if (MuseumRgn nobodyAround:)
					(gGame points: 1 146)
					(gEgo get: -1 8) ; skeletonKey
					((ScriptID 21 0) doit: 777) ; addCluesCode, Skeleton Key
					(sFX number: 501 play:)
					(keyGlintInset dispose:)
					(keyGlint setScript: 0)
					(gMessager say: 18 22) ; "With careful use of the Dagger, you manage to pry the skeleton key off the Bosch painting without any serious damage."
					(self dispose:)
					(return 1)
				else
					(return 1)
				)
			)
			(21 ; wireCutters
				(if (MuseumRgn nobodyAround:)
					(gGame points: 1 146)
					(gEgo get: -1 8) ; skeletonKey
					((ScriptID 21 0) doit: 777) ; addCluesCode, Skeleton Key
					(sFX number: 501 play:)
					(keyGlintInset dispose:)
					(keyGlint setScript: 0)
					(gMessager say: 18 21) ; "With careful use of the wire cutters, you manage to remove the skeleton key without damaging the Bosch painting."
					(self dispose:)
					(return 1)
				else
					(return 1)
				)
			)
			(25 ; snakeOil
				(gMessager say: 18 25) ; "The Snake Oil would only damage the painting without removing the key."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sMeeting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveFwd 15 self)
				(= cycles 5)
			)
			(1
				(gMessager say: 3 0 0 0 self 1500) ; "Ach, you are shmelling like ze brewery, mein Kapitan! Either you've been drinking, or you've been eating too many of zose grapes!"
			)
			(2)
			(3
				(gEgo setMotion: PolyPath 166 179 self)
			)
			(4
				(= cycles 3)
			)
			(5
				(gMessager say: 2 0 0 0 self 1500) ; "ERNIE LEACH has been MURDERED!"
			)
			(6
				((ScriptID 32 0) setHeading: 270 self) ; aHeimlich
			)
			(7
				(gMessager say: 1 0 0 0 self 1500) ; "What was that, lass?"
			)
			(8
				(gEgo setHeading: 180 self)
			)
			(9
				(if (TimeCheck $0080)
					(gGameMusic2 number: 502 loop: 1 flags: 1 play: self)
				)
				(gEgo setMotion: MoveFwd 70 self)
			)
			(10
				(if (not (TimeCheck $0080))
					(gGameMusic2 fade:)
					(WrapMusic pause: 0)
					(= cycles 1)
				)
			)
			(11
				(SetFlag 85)
				((ScriptID 90 3) moveTo: local3) ; aORiley
				(gCurRoom newRoom: (gCurRoom south:))
				(self dispose:)
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveFwd 20 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gAct 2)
					((ScriptID 32 0) ; aHeimlich
						originalView: 814
						room: gCurRoomNum
						init:
						posn: 130 180
						setLoop: 8
						setCel: 3
						noun: 1
					)
					(gGameMusic1 pause:)
					(gGameMusic2 number: 19 flags: 1 setLoop: 1 play:)
				)
				(gEgo setMotion: MoveFwd 15 self)
			)
			(1
				(if (gCast contains: (ScriptID 32 0)) ; aHeimlich
					(Face (ScriptID 32 0) gEgo self) ; aHeimlich
				else
					(= cycles 1)
				)
			)
			(2
				(= cycles 5)
			)
			(3
				(if (> gAct 2)
					(if
						(not
							(and
								(== gAct 3)
								(TimeCheck $2140) ; has 2:15 am occurred?
								(not (IsFlag 85))
							)
						)
						(gGame handsOn:)
					)
					(self dispose:)
				else
					(gMessager say: 3 0 84 0 self 1889) ; "Achtung! Tourists are not allowed in zis room at zis time! You are disturbing ze paintings! Raus! You leaf now! Mach schnell!"
				)
			)
			(4
				(gEgo
					setMotion: PolyPath (gEgo x:) (- (gEgo y:) 15) self
				)
			)
			(5
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance sSmashPlaster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 185 187 self)
			)
			(1
				(gEgo view: 504 loop: 1 cel: 0 setCycle: CT 10 1 self)
			)
			(2
				(gEgo setCycle: End self)
				(sFX number: 500 play:)
				(yvetteStatue setCycle: End self)
			)
			(3 0)
			(4
				((ScriptID 22 0) doit: $3104) ; triggerAndClock, 3:15 am
				(gGame points: 1 161)
				(gEgo normalize: 831)
				(yvetteStatue stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDeadYvette of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheIconBar disable: 7)
				(gCast eachElementDo: #hide)
				(gEgo stopUpd:)
				(WrapMusic pause: 1)
				(if (IsFlag 68)
					(fooSound number: 6 loop: -1 flags: 1 play:)
					(= cycles 1)
				else
					(SetFlag 68)
					(gCurRoom drawPic: 556)
					(wrapMusic init: -1 3 6)
					(= local0 1)
					(sFX number: 84 flags: 5 loop: 1 play:)
					(= ticks 180)
				)
			)
			(1
				(gCurRoom setInset: inDeadYvette self)
			)
			(2
				(gEgo startUpd:)
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 500)
				(= cycles 1)
			)
			(3
				(fooSound fade: 0 12 30 1)
				(if local0
					(wrapMusic dispose: 1)
				)
				(WrapMusic pause: 0)
				(proc0_8 0)
				(gTheIconBar enable: 7)
				(self dispose:)
			)
		)
	)
)

(instance sBoschPainting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom setInset: inBoschPainting self)
			)
			(1
				(if (gEgo has: 8) ; skeletonKey
					(keyGlint dispose:)
				)
				(= cycles 1)
			)
			(2
				(proc0_8 0)
				(self dispose:)
			)
		)
	)
)

(instance sKeyGlint of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(= ticks 300)
			)
			(2
				(if (and (> (gEgo y:) 168) (< (gEgo y:) 187))
					(keyGlint setCel: 0 setCycle: End)
					(= ticks (* 60 (Random 3 10)))
				else
					(= cycles 1)
				)
			)
			(3
				(self changeState: 2)
			)
		)
	)
)

(instance sKeyGlintInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(keyGlintInset setCel: 0 setCycle: End)
				(= ticks (* 60 (Random 2 5)))
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance wrapMusic of WrapMusic
	(properties)

	(method (init)
		(= wrapSound fooSound)
		(super init: &rest)
	)
)

(instance fooSound of Sound
	(properties)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

(instance southExitFeature of ExitFeature
	(properties
		nsTop 184
		nsBottom 189
		nsRight 319
		cursor 11
		exitDir 3
		noun 26
	)
)

