;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2100)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use useObj)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm2100 0
)

(local
	local0
	local1
	[local2 3]
	local5
	local6
)

(instance rm2100 of KQRoom
	(properties
		picture 2100
	)

	(method (init)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 25 122 25 136 271 136 263 124 243 109 251 101 221 100 190 112 97 113 72 108 58 110
					yourself:
				)
		)
		(gEgo normalize: init:)
		(if (IsFlag 55)
			(gEgo setScaler: Scaler 93 66 107 91)
		else
			(gEgo setScaler: Scaler 91 83 136 104)
		)
		(door init:)
		(standStart init:)
		(chairStart init:)
		(stoolStart init:)
		(if (IsFlag 59)
			(ladder init:)
		else
			(stand init:)
			(chair init:)
			(stool init:)
			(vanity init:)
			(cond
				((IsFlag 55)
					(standPlace init:)
					(smoke init:)
				)
				((not (IsFlag 98))
					(bed init:)
				)
			)
		)
		(if (or (not (IsFlag 55)) (IsFlag 59))
			(doorExit init:)
		)
		(painting init:)
		(cond
			((== gPrevRoomNum 2110)
				(self setScript: lookPic)
			)
			((== gPrevRoomNum 2485)
				(self setScript: poofToon)
			)
			((not (IsFlag 358))
				(self setScript: imaTroll)
			)
			(else
				(self setScript: enterRoom)
			)
		)
		(if (!= gPrevRoomNum 2110)
			(gKqMusic1
				number: 2100
				setLoop: -1
				play:
				setVol: 0
				fade: 127 25 10 0
			)
		)
		(if (IsFlag 55)
			(Load rsVIEW 2103)
			(Load 140 2111) ; WAVE
		)
	)

	(method (handleEvent event)
		(cond
			((gInterfacePlane onMe: event)
				(super handleEvent: event)
			)
			((and local1 (not script))
				(= local5 (global123 firstTrue: #onMe event))
				(gCurRoom setScript: standUp)
				(= local1 0)
				(gMouseDownHandler delete: self)
				(event claimed: 1)
				(return 1)
			)
			((and local6 (not script))
				(if (vent onMe: event)
					(vent handleEvent: event)
				else
					(self setScript: climbDownLadder)
				)
				(event claimed: 1)
				(return 1)
			)
			(else
				(super handleEvent: event)
				(return)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 2110)
			(gKqMusic1 fade:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance lookInMirrorAsHuman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScale: 0
					view: 2103
					setLoop: 1
					setCel: 0
					posn: 236 109
					setCycle: CT 12 1 self
				)
			)
			(1
				(gEgo setCycle: End self)
				(gMessager say: 1 8 3 0 self) ; "(THINKS TO HERSELF)Whew. That's better! Now I've got to get out of here. Come on, Rosella, think!"
			)
			(2 0)
			(3
				(gEgo normalize:)
				(gEgo posn: 267 108 setMotion: MoveTo 222 119 self)
				(if (IsFlag 55)
					(gEgo setScaler: Scaler 93 66 107 91)
				else
					(gEgo setScaler: Scaler 91 83 136 104)
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookInMirrorAsTroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 274 107 self)
			)
			(1
				(= register (gEgo cycleSpeed:))
				(gEgo
					setScale: 0
					posn: 275 105
					view: 2101
					setLoop: 0
					setCel: 0
					cycleSpeed: 14
					setCycle: CT 10 1 self
				)
			)
			(2
				(gMessager say: 1 8 2 0 self) ; "(DISGUSTED)BLEH!"
			)
			(3
				(gEgo setCel: 9 setCycle: End self)
			)
			(4
				(gEgo
					normalize:
					cycleSpeed: register
					setMotion: MoveTo 230 109 self
				)
				(if (IsFlag 55)
					(gEgo setScaler: Scaler 93 66 107 91)
				else
					(gEgo setScaler: Scaler 91 83 136 104)
				)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance imaTroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(gGame handsOff:)
				(Load 140 802) ; WAVE
				(SetFlag 358)
				(bed setHotspot: 0)
				(gEgo posn: 100 115 setMotion: PolyPath 202 101 self)
				(door setCel: 2)
				(= seconds 2)
			)
			(1
				(door setCycle: Beg self)
			)
			(2
				(gKqSound1 number: 802 setLoop: 1 play:)
			)
			(3
				(gMessager say: 0 0 1 0 self) ; "(ANGRY, FRUSTRATED)A TROLL! I can't believe I'm a TROLL! And not just any troll, oh no! I'm engaged to the Troll King! How lucky can a girl GET?!"
			)
			(4
				(gEgo setMotion: MoveTo 207 96 self)
			)
			(5
				(gEgo setHeading: 135 self)
			)
			(6
				(gEgo view: 8874 loop: 0 cel: 0 setCycle: End self)
				(= local1 1)
			)
			(7
				(gMouseDownHandler add: gCurRoom)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(bed setHotspot: 8 10) ; Do, Exit
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo normalize: 4 setMotion: MoveTo 225 110 self)
			)
			(2
				(gEgo setHeading: 180 self)
			)
			(3
				(gGame handsOn:)
				(if local5
					(local5 doVerb: 8)
				)
				(self dispose:)
			)
		)
	)
)

(instance tooShort of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc11_3 gEgo painting self)
			)
			(1
				(gMessager say: 4 8 0 1 self) ; "(THINKS TO HERSELF)No...it's not tall enough yet."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance climbAndRemovePic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 2106)
				(Load 140 2102) ; WAVE
				(gEgo setMotion: MoveTo 255 95 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo
					setScale: 0
					view: 2106
					setLoop: 0
					cel: 0
					ignoreActors:
					setPri: 120
					setCycle: End self
				)
				(= local6 1)
			)
			(3
				(gEgo setLoop: 1 cel: 0 posn: 246 63 setCycle: CT 7 1 self)
			)
			(4
				(smoke dispose:)
				(painting hide:)
				(gEgo setCycle: CT 29 1 self)
			)
			(5
				(gKqSound1 number: 2102 setLoop: 1 play:)
				(gEgo setCycle: CT 31 1 self)
			)
			(6
				(painting
					view: 2106
					loop: 4
					cel: 0
					posn: 240 65
					setHotspot: 0
					show:
				)
				(gEgo setCycle: End self)
			)
			(7
				(client setScript: climbThroughVent)
			)
		)
	)
)

(instance climbLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 2106)
				(gEgo setPri: 120 setMotion: MoveTo 249 95 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo
					setScale: 0
					view: 2106
					setLoop: 0
					cel: 0
					setCycle: End self
				)
				(= local6 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance climbDownLadder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 2106
					setLoop: 0
					posn: 255 95
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(1
				(gEgo posn: 249 95 normalize: 3)
				(if (IsFlag 55)
					(gEgo setScaler: Scaler 93 66 107 91)
				else
					(gEgo setScaler: Scaler 91 83 136 104)
				)
				(= cycles 4)
			)
			(2
				(gEgo setHeading: 180 self)
			)
			(3
				(= local6 0)
				(gMouseDownHandler delete: gCurRoom)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance climbThroughVent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 2106
					setLoop: 3
					cel: 0
					posn: 258 28
					setPri: 10
					setCycle: End self
				)
			)
			(1
				(SetFlag 59)
				(gCurRoom newRoom: 2300)
			)
		)
	)
)

(instance poofToon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 360)
				(gGame handsOff:)
				(Load rsVIEW 836)
				(Load 140 2105) ; WAVE
				(Load 140 2106) ; WAVE
				(Load 140 2107) ; WAVE
				(gEgo posn: 1000 1000)
				(= ticks 30)
			)
			(1
				(gEgo
					view: 2103
					setLoop: 0
					setCel: 0
					posn: 163 115
					setCycle: End self
				)
				(gKqSound1 number: 2105 setLoop: 1 play:)
			)
			(2
				(gEgo normalize: 0)
				(= ticks 100)
			)
			(3
				(gKqSound1 number: 2106 setLoop: 1 play: self)
			)
			(4
				(gEgo setHeading: 270 self)
			)
			(5
				(= ticks 20)
			)
			(6
				(gKqSound1 number: 2107 setLoop: 1 play: self)
			)
			(7
				(= ticks 100)
			)
			(8
				(gMessager say: 0 0 4 0 self) ; "(LOUD, ECHOING, SCARY)There! you just be patient, girl. I'll be in to take care of you before you know it. Ha ha ha ha ha!"
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 802) ; WAVE
				(SetFlag 358)
				(gEgo posn: 100 115 setMotion: PolyPath 135 120 self)
				(door setCel: 2)
				(= seconds 2)
			)
			(1
				(door setCycle: Beg self)
			)
			(2
				(gKqSound1 number: 802 setLoop: 1 play:)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lookPic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 225 105 normalize: 6 setHeading: 180 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tryLockedDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 79 105 self)
			)
			(1
				(gEgo view: 8485 setLoop: 1 cel: 0 setCycle: CT 5 1 self)
			)
			(2
				(gKqSound1
					number: (if local0 846 else 803)
					setLoop: 1
					play: self
				)
				(= local0 1)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gEgo normalize: 7 setMotion: MoveTo 80 110 self)
			)
			(5
				(= ticks 20)
			)
			(6
				(gMessager say: 3 8 3 0 self) ; "Rats."
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 801) ; WAVE
				(gEgo setMotion: MoveTo 76 109 self)
			)
			(1
				(gEgo
					view: (if (IsFlag 55) 8485 else 8815)
					setLoop: 1
					setCel: 0
					setCycle: CT 8 1 self
				)
			)
			(2
				(gEgo setCycle: End self)
				(door setLoop: 1 setCel: 0 setPri: 113 setCycle: End self)
				(gKqSound1 number: 801 setLoop: 1 play:)
			)
			(3 0)
			(4
				(gEgo normalize: setMotion: MoveTo -10 108 self)
			)
			(5
				(gGame handsOn:)
				(gCurRoom newRoom: 2450)
			)
		)
	)
)

(instance ladderFall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 2106)
				(gEgo setPri: 120 setMotion: MoveTo 249 95 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gEgo
					setScale: 0
					view: 2106
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(3
				(pseudoHide doit: stand 1)
				(pseudoHide doit: chair 1)
				(pseudoHide doit: stool 1)
				(cond
					(
						(and
							(== (stool position:) 1)
							(== (stand position:) 2)
							(== (chair position:) 3)
						)
						(ladder setLoop: 4)
					)
					(
						(and
							(== (stool position:) 1)
							(== (chair position:) 2)
							(== (stand position:) 3)
						)
						(ladder setLoop: 5)
					)
					(
						(and
							(== (chair position:) 1)
							(== (stand position:) 2)
							(== (stool position:) 3)
						)
						(ladder setLoop: 6)
					)
					(
						(and
							(== (chair position:) 1)
							(== (stool position:) 2)
							(== (stand position:) 3)
						)
						(ladder setLoop: 7)
					)
					(
						(and
							(== (stand position:) 1)
							(== (stool position:) 2)
							(== (chair position:) 3)
						)
						(ladder setLoop: 8)
					)
				)
				(ladder init: setCel: 0)
				(gEgo view: 2106 setLoop: 2 cel: 0)
				(ladder cel: 0 setCycle: End self)
				(gKqSound1 number: 2111 setLoop: 1 play:)
				(gEgo setCycle: End)
			)
			(4
				(ladder dispose:)
				(pseudoHide doit: chair 0)
				(pseudoHide doit: stool 0)
				(pseudoHide doit: stand 0)
				(chair
					posn: (chairStart x:) (+ (chairStart y:) 4)
					position: 0
					setPri: 113
				)
				(stool
					posn: (stoolStart x:) (+ (stoolStart y:) 4)
					position: 0
					setPri: 112
				)
				(stand posn: (standStart x:) (+ (standStart y:) 4) position: 0)
				(= register (gEgo cycleSpeed:))
				(gEgo
					setLoop: 5
					cel: 0
					posn: 250 99
					setSpeed: 10
					setCycle: End self
				)
			)
			(5
				(stoolStart init:)
				(chairStart init:)
				(standStart init:)
				(standPlace init:)
				(gEgo posn: 270 113 normalize: 2)
				(if (IsFlag 55)
					(gEgo setScaler: Scaler 93 66 107 91)
				else
					(gEgo setScaler: Scaler 91 83 136 104)
				)
				(= ticks 10)
			)
			(6
				(gEgo ignoreActors: setMotion: MoveTo 250 125 self)
			)
			(7
				(gGame handsOn:)
				(gMouseDownHandler delete: gCurRoom)
				(= local6 0)
				(self dispose:)
			)
		)
	)
)

(instance lookPainting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 244 102 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(gCurRoom newRoom: 2110)
			)
		)
	)
)

(instance door of Prop
	(properties
		noun 3
		x 16
		y 87
		view 2102
		loop 1
	)

	(method (init)
		(super init: &rest)
		(if (and (IsFlag 55) (not (IsFlag 59)))
			(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
		else
			(doorExit init:)
		)
	)

	(method (doVerb)
		(gCurRoom setScript: tryLockedDoor)
		(return 1)
	)
)

(instance doorExit of ExitFeature
	(properties
		nsLeft 15
		nsTop 36
		nsRight 61
		nsBottom 114
		approachX 81
		approachY 110
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10 approachVerbs: 8) ; Do, Exit, Do
	)

	(method (doVerb)
		(gCurRoom setScript: openDoor)
		(return 1)
	)
)

(instance ladder of Prop
	(properties
		x 255
		y 90
		view 2103
		loop 3
	)
)

(instance painting of View
	(properties
		approachX 244
		approachY 102
		x 253
		y 40
		view 2100
		loop 3
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 59)
			(self view: 2106 loop: 4 cel: 0 posn: 240 65)
		else
			(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(cond
				((ladderCode doit:)
					(gCurRoom setScript: climbAndRemovePic)
				)
				((didSomeCode doit:)
					(gMessager say: 4 theVerb 0 1) ; "(THINKS TO HERSELF)No...it's not tall enough yet."
				)
				(else
					(gCurRoom setScript: lookPainting)
				)
			)
			(return 1)
		)
	)
)

(instance stool of useObj
	(properties
		x 287
		y 122
		view 2100
		loop 1
		verb 64
		myCursorView 21000
		myCursorLoop 2
	)

	(method (init)
		(if (IsFlag 55)
			(self setHotspot: 8 10) ; Do, Exit
		)
		(super init: &rest)
		(self setPri: 112 position: 0)
	)

	(method (show)
		(super show: &rest)
		(self setPri: 112 setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(switch position
				(0
					(stoolStart init:)
				)
				(1
					(standPlace init:)
					(chairPlace dispose:)
					(stoolPlace dispose:)
					(if (== (chair position:) 3)
						(chair
							posn: (chairStart x:) (chairStart y:)
							position: 0
							setPri: -1
						)
						(chairStart dispose:)
					)
					(if (== (stand position:) 3)
						(stand
							posn: (standStart x:) (standStart y:)
							position: 0
							setPri: -1
						)
						(standStart dispose:)
					)
					(if (== (chair position:) 2)
						(chair
							posn: (chairStart x:) (chairStart y:)
							position: 0
							setPri: -1
						)
						(chairStart dispose:)
					)
					(if (== (stand position:) 2)
						(stand
							posn: (standStart x:) (standStart y:)
							position: 0
							setPri: -1
						)
						(standStart dispose:)
					)
				)
				(2
					(chairPlace init:)
					(stoolPlace dispose:)
					(if (== (chair position:) 3)
						(chair
							posn: (chairStart x:) (chairStart y:)
							position: 0
							setPri: -1
						)
						(chairStart dispose:)
					)
					(if (== (stand position:) 3)
						(stand
							posn: (standStart x:) (standStart y:)
							position: 0
							setPri: -1
						)
						(standStart dispose:)
					)
				)
				(3
					(stoolPlace init:)
				)
			)
			(self setPri: -1)
			(super doVerb: 8)
			(return 1)
		)
	)
)

(instance chair of useObj
	(properties
		x 272
		y 105
		view 2100
		verb 62
		myCursorView 21000
		myCursorLoop 1
	)

	(method (init)
		(if (IsFlag 55)
			(self setHotspot: 8 10) ; Do, Exit
		)
		(super init: &rest)
		(self position: 0 setPri: 113)
	)

	(method (show)
		(super show: &rest)
		(self setHotspot: 8 10 setPri: -1) ; Do, Exit
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(switch position
				(0
					(chairStart init:)
				)
				(2
					(chairPlace init:)
					(stoolPlace dispose:)
					(if (== (stool position:) 3)
						(stool
							posn: (stoolStart x:) (stoolStart y:)
							position: 0
							setPri: -1
						)
						(stoolStart dispose:)
					)
					(if (== (stand position:) 3)
						(stand
							posn: (standStart x:) (standStart y:)
							position: 0
							setPri: -1
						)
						(standStart dispose:)
					)
				)
				(1
					(standPlace init:)
					(chairPlace dispose:)
					(stoolPlace dispose:)
					(if (== (stool position:) 3)
						(stool
							posn: (stoolStart x:) (stoolStart y:)
							position: 0
							setPri: -1
						)
						(stoolStart dispose:)
					)
					(if (== (stand position:) 3)
						(stand
							posn: (standStart x:) (standStart y:)
							position: 0
							setPri: -1
						)
						(standStart dispose:)
					)
					(if (== (stool position:) 2)
						(stool
							posn: (stoolStart x:) (stoolStart y:)
							position: 0
							setPri: -1
						)
						(stoolStart dispose:)
					)
					(if (== (stand position:) 2)
						(stand
							posn: (standStart x:) (standStart y:)
							position: 0
							setPri: -1
						)
						(standStart dispose:)
					)
				)
				(3
					(stoolPlace init:)
				)
			)
			(self setPri: -1)
			(super doVerb: 8)
			(return 1)
		)
	)
)

(instance stand of useObj
	(properties
		x 122
		y 99
		view 2100
		loop 2
		verb 63
		myCursorView 21000
	)

	(method (init)
		(if (IsFlag 55)
			(self setHotspot: 8 10) ; Do, Exit
		)
		(super init: &rest)
		(self position: 0)
	)

	(method (show)
		(super show: &rest)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(switch position
				(0
					(standStart init:)
				)
				(2
					(chairPlace init:)
					(stoolPlace dispose:)
					(if (== (chair position:) 3)
						(chair
							posn: (chairStart x:) (chairStart y:)
							position: 0
							setPri: -1
						)
						(chairStart dispose:)
					)
					(if (== (stool position:) 3)
						(stool
							posn: (stoolStart x:) (stoolStart y:)
							position: 0
							setPri: -1
						)
						(stoolStart dispose:)
					)
				)
				(1
					(standPlace init:)
					(chairPlace dispose:)
					(stoolPlace dispose:)
					(if (== (chair position:) 3)
						(chair
							posn: (chairStart x:) (chairStart y:)
							position: 0
							setPri: -1
						)
						(chairStart dispose:)
					)
					(if (== (stool position:) 3)
						(stool
							posn: (stoolStart x:) (stoolStart y:)
							position: 0
							setPri: -1
						)
						(stoolStart dispose:)
					)
					(if (== (chair position:) 2)
						(chair
							posn: (chairStart x:) (chairStart y:)
							position: 0
							setPri: -1
						)
						(chairStart dispose:)
					)
					(if (== (stool position:) 2)
						(stool
							posn: (stoolStart x:) (stoolStart y:)
							position: 0
							setPri: -1
						)
						(stoolStart dispose:)
					)
				)
				(3
					(stoolPlace init:)
				)
			)
			(self setPri: -1)
			(super doVerb: 8)
			(return 1)
		)
	)
)

(instance vent of ExitFeature
	(properties
		nsLeft 234
		nsTop 15
		nsRight 259
		nsBottom 50
		exitDir 1
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 8 10) ; Do, Exit
	)

	(method (handleEvent event)
		(if (and (== (event type:) evVERB) (self onMe: event))
			(if local6
				(gCurRoom setScript: climbThroughVent)
			else
				(climbLadder next: climbThroughVent)
				(gCurRoom setScript: climbLadder)
			)
		else
			(super handleEvent: event)
			(return)
		)
	)
)

(instance vanity of Feature
	(properties
		nsLeft 283
		nsTop 34
		nsRight 309
		nsBottom 78
		sightAngle 359
		approachX 234
		approachY 105
		x 260
		y 105
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 setHotspot: 8 10) ; Do, Do, Exit
		(if (IsFlag 55)
			(= approachX 244)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(if (IsFlag 55)
				(gCurRoom setScript: lookInMirrorAsHuman)
				(self setHotspot: 0)
			else
				(gCurRoom setScript: lookInMirrorAsTroll)
			)
			(return 1)
		)
	)
)

(instance bed of Feature
	(properties
		noun 2
		sightAngle 5
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 98 21 123 21 136 21 209 73 213 97 159 110 100 96
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gMessager say: noun theVerb 2 0) ; "(THINKS TO HERSELF)Eeow. That's enough to give our castle decorator a case of the vapors."
			(self setHotspot: 0)
			(SetFlag 98)
			(return 1)
		)
	)
)

(instance standPlace of Feature
	(properties
		nsLeft 235
		nsTop 80
		nsRight 270
		nsBottom 105
		sightAngle 360
		x 254
		y 95
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 0 63 62 64) ; stand, chair, stool
	)

	(method (doVerb theVerb)
		(switch theVerb
			(64 ; stool
				(stool
					position: 1
					show:
					posn: 254 82
					setHotspot: 8 10 ; Do, Exit
					setPri: 1
				)
				(self dispose:)
			)
			(62 ; chair
				(chair
					position: 1
					show:
					posn: 254 83
					setHotspot: 8 10 ; Do, Exit
					setPri: 1
				)
				(self dispose:)
			)
			(63 ; stand
				(stand
					position: 1
					show:
					posn: 254 82
					setHotspot: 8 10 ; Do, Exit
					setPri: 1
				)
				(self dispose:)
			)
		)
		(chairPlace init:)
	)
)

(instance chairPlace of Feature
	(properties
		nsLeft 229
		nsTop 66
		nsRight 264
		nsBottom 85
		sightAngle 360
		x 255
		y 83
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 0 64 62 63) ; stool, chair, stand
	)

	(method (doVerb theVerb)
		(switch theVerb
			(64 ; stool
				(stool
					position: 2
					show:
					posn: 255 74
					setHotspot: 8 10 ; Do, Exit
					setPri: 2
				)
				(gCurRoom setScript: tooShort)
				(self dispose:)
			)
			(62 ; chair
				(chair
					position: 2
					show:
					posn: 256 71
					setHotspot: 8 10 ; Do, Exit
					setPri: 2
				)
				(gCurRoom setScript: tooShort)
				(self dispose:)
			)
			(63 ; stand
				(stand
					position: 2
					show:
					posn: 253 73
					setHotspot: 8 10 ; Do, Exit
					setPri: 2
				)
				(gCurRoom setScript: tooShort)
				(self dispose:)
			)
		)
		(stoolPlace init:)
	)
)

(instance stoolPlace of Feature
	(properties
		nsLeft 230
		nsTop 40
		nsRight 265
		nsBottom 64
		sightAngle 360
		x 243
		y 59
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 0 64 62 63) ; stool, chair, stand
	)

	(method (doVerb theVerb)
		(switch theVerb
			(64 ; stool
				(stool
					position: 3
					show:
					posn: 255 64
					setHotspot: 8 10 ; Do, Exit
					setPri: 3
				)
				(if (ladderCode doit:)
					(gCurRoom setScript: climbAndRemovePic)
				else
					(gCurRoom setScript: ladderFall)
				)
			)
			(62 ; chair
				(chair
					position: 3
					show:
					posn: 255 65
					setHotspot: 8 10 ; Do, Exit
					setPri: 3
				)
				(self dispose:)
				(gCurRoom setScript: ladderFall)
			)
			(63 ; stand
				(stand
					position: 3
					show:
					posn: 251 67
					setHotspot: 8 10 ; Do, Exit
					setPri: 3
				)
				(self dispose:)
				(gCurRoom setScript: ladderFall)
			)
		)
	)
)

(instance stoolStart of Feature
	(properties
		nsLeft 277
		nsTop 117
		nsRight 298
		nsBottom 127
		sightAngle 360
		x 287
		y 120
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 0 64) ; stool
	)

	(method (doVerb theVerb)
		(switch theVerb
			(64 ; stool
				(stool posn: x y position: 0 show: setHotspot: 8 10) ; Do, Exit
				(self dispose:)
			)
		)
	)
)

(instance chairStart of Feature
	(properties
		nsLeft 261
		nsTop 98
		nsRight 283
		nsBottom 112
		sightAngle 360
		x 272
		y 100
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 0 62) ; chair
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; chair
				(chair posn: x y position: 0 show: setHotspot: 8 10) ; Do, Exit
				(self dispose:)
			)
		)
	)
)

(instance standStart of Feature
	(properties
		nsLeft 107
		nsTop 92
		nsRight 146
		nsBottom 107
		sightAngle 360
		x 122
		y 90
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 0 63) ; stand
	)

	(method (doVerb theVerb)
		(switch theVerb
			(63 ; stand
				(stand posn: x y position: 0 show: setHotspot: 8 10) ; Do, Exit
				(self dispose:)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		x 254
		y 28
		view 2111
		loop 1
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(super init: &rest)
		(self setPri: 100 setCycle: Fwd)
	)
)

(instance ladderCode of Code
	(properties)

	(method (doit)
		(return
			(and
				(== (stool position:) 3)
				(== (chair position:) 2)
				(== (stand position:) 1)
			)
		)
	)
)

(instance didSomeCode of Code
	(properties)

	(method (doit)
		(return
			(or
				(!= (stool position:) 0)
				(!= (chair position:) 0)
				(!= (stand position:) 0)
			)
		)
	)
)

(instance pseudoHide of Code
	(properties)

	(method (doit param1 param2)
		(if param2
			(param1 y: (+ (param1 y:) 1000))
		else
			(param1 y: (- (param1 y:) 1000))
		)
	)
)

