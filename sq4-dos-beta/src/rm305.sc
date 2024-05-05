;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 305)
(include sci.sh)
(use Main)
(use butte)
(use MoveToY)
(use SQRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm305 0
	pod 1
)

(instance rm305 of SQRoom
	(properties
		picture 305
		south 315
		west 300
	)

	(method (init)
		(LoadMany rsVIEW 0 305 300)
		(LoadMany rsSOUND 124 125)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 124 0 319 0 319 116 258 116 246 113 245 91 165 102 147 90 145 80 122 72
					yourself:
				)
				((Polygon new:)
					type: PNearestAccess
					init: 0 0 112 0 112 71 60 70 0 66
					yourself:
				)
				((Polygon new:)
					type: PNearestAccess
					init: 0 85 66 84 127 89 143 103 135 112 104 117 103 130 90 132 86 151 59 178 62 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PNearestAccess
					init: 319 189 186 189 187 165 170 152 165 125 250 125 254 122 319 123
					yourself:
				)
		)
		(if (> (butte policeLanded:) 0)
			(Load rsPIC 300)
		else
			(LoadMany rsVIEW 7 5)
		)
		(self setRegions: 703 setFeatures: theStairs theRoom) ; butte
		(HandsOn)
		(switch gPrevRoomNum
			(south
				(gEgo init:)
				(self style: 43)
			)
			(west
				(self style: 41)
				(gEgo
					init:
					y:
						(cond
							((< (gEgo y:) 67) 67)
							((> (gEgo y:) 88) 88)
							(else
								(gEgo y:)
							)
						)
					setHeading: 90 self
				)
			)
			(else
				(HandsOff)
				(gLongSong number: 18 loop: -1 vol: 127 playBed:)
				(if (IsFlag 2)
					(self setScript: egoLands)
				else
					(gEgo
						view: 378
						loop: 0
						cel: 0
						x: 218
						y: 97
						setPri: 7
						normal: 0
						moveHead: 0
						init:
					)
					(self setScript: egoExits)
				)
			)
		)
		(super init:)
		(if (or (== gPrevRoomNum 300) (== gPrevRoomNum 315))
			(gEgo setPri: 8 ignoreActors: 0 illegalBits: 0)
			(pod loop: 1 cel: 10 init: stopUpd:)
		)
		(if
			(and
				(< (butte policeLanded:) 0)
				(or
					(== (butte curPolice1Room:) 305)
					(== (butte curPolice2Room:) 305)
				)
			)
			(butte junctioned: 1)
			((ScriptID 703 4) posn: 146 95 init: setScript: copEnters) ; cop
		else
			(butte junctioned: 0)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 531)
			(gLongSong stop:)
		)
		(if (and (== script fallScript) (== (gEgo edgeHit:) EDGE_BOTTOM))
			(= newRoomNumber 0)
		else
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(HandsOff)
				(self setScript: exitSouthScript)
			)
		)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(HandsOff)
				(self setScript: exitSouthScript)
			)
			((and (butte junctioned:) (not ((ScriptID 703 4) script:))) ; cop
				(cond
					((== (butte oldPoliceRoom:) 300)
						((ScriptID 703 4) posn: -5 75) ; cop
					)
					((== (butte oldPoliceRoom:) 315)
						((ScriptID 703 4) posn: 150 250) ; cop
					)
				)
				((ScriptID 703 4) init:) ; cop
				((ScriptID 703 4) setScript: copEnters) ; cop
			)
			(
				(or
					(& temp0 $0002)
					(& temp0 $0004)
					(& temp0 $0010)
					(& temp0 $0080)
					(& temp0 $0100)
					(& temp0 $0200)
				)
				(HandsOff)
				(self setScript: fallScript 0 temp0)
			)
			((and (& temp0 $4000) (== (gEgo view:) 0))
				(gEgo view: 0)
			)
			(
				(and
					(!= script exitSouthScript)
					(not (& temp0 $4000))
					(== (gEgo view:) 0)
				)
				(gEgo view: 0)
			)
		)
		(cond
			(script)
			((and (< (gEgo y:) 96) (> (gEgo x:) 142))
				(gEgo setPri: 5)
			)
			((> (gEgo y:) 113)
				(gEgo setPri: 15)
			)
			((> (gEgo y:) 86)
				(gEgo setPri: 13)
			)
			(else
				(gEgo setPri: 8)
			)
		)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(cond
					((& register $0100)
						(gEgo setPri: 3)
					)
					((& register $0200)
						(gEgo x: (+ (gEgo x:) 10) setPri: 4)
					)
					((& register $0002)
						(gEgo x: (- (gEgo x:) 10) setPri: 4)
					)
					((and (& register $0010) (> (gEgo x:) 170))
						(gEgo setPri: 6)
					)
					(else
						(gEgo setPri: 4)
					)
				)
				(gCurRoom setScript: (ScriptID 703 1)) ; butteFallScript
			)
		)
	)
)

(instance exitSouthScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gEgo setHeading: (+ 180 (/ (- (gEgo x:) 210) 3)) self)
			)
			(1
				(= temp0
					(+
						(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
						1
					)
				)
				(gEgo setMotion: MoveToY (+ 189 temp0) self)
			)
			(2
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance egoLands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(podFlash init: setCycle: Fwd)
				(= cycles 25)
			)
			(1
				(pod init: setCycle: CT 9 1 self)
			)
			(2
				(door init:)
				(pod setCycle: End self)
			)
			(3
				(podFlash dispose:)
				(= cycles 3)
			)
			(4
				(HandsOn)
				(gCurRoom newRoom: 531)
			)
		)
	)
)

(instance egoExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(door init: setCycle: End)
				(pod cel: 10 init:)
				(if (IsFlag 17)
					((ScriptID 703 4) init: view: 13 loop: 0 x: 115 y: 117) ; cop
				)
				(= cycles 1)
			)
			(1
				(gLongSong2 number: 124 loop: 1 vol: 127 play:)
				(door setCycle: End self)
			)
			(2
				(door dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(pod priority: -1 stopUpd:)
				(gEgo view: 0 loop: 1 normal: 1 moveHead: 1 x: 221 y: 97)
				(NormalEgo)
				(= cycles 3)
			)
			(4
				(if (IsFlag 17)
					((ScriptID 703 4) setScript: (ScriptID 703 5)) ; cop, shootEgoScript
				else
					(HandsOn)
					(User canControl: 1)
					(client setScript: 0)
				)
			)
		)
	)
)

(instance enterPod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 221 97 self)
			)
			(1
				(gEgo
					view: 378
					normal: 0
					loop: 1
					cel: 0
					x: 224
					y: 75
					illegalBits: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(gEgo setPri: (- (door priority:) 1))
				(gLongSong2 number: 125 loop: 1 vol: 127 play:)
				(door cel: 9 init: setCycle: Beg self)
			)
			(3
				(gEgo dispose:)
				(HandsOn)
				(= cycles 2)
			)
			(4
				(if (< (butte policeLanded:) 0)
					(SetFlag 17)
				)
				(gCurRoom newRoom: 531)
			)
		)
	)
)

(instance copEnters of Script
	(properties)

	(method (doit)
		(if (and (not (gCurRoom script:)) (== state 0))
			(self cue:)
		)
		(if
			(and
				(< ((ScriptID 703 4) distanceTo: gEgo) 80) ; cop
				(not (gCurRoom script:))
			)
			((ScriptID 703 4) setScript: (ScriptID 703 5)) ; cop, shootEgoScript
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				((ScriptID 703 4) ; cop
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 146 95 self
				)
			)
			(2
				((ScriptID 703 4) ; cop
					setMotion: MoveTo (gEgo x:) (gEgo y:) self
				)
			)
		)
	)
)

(instance podFlash of Prop
	(properties
		x 186
		y 57
		view 305
		priority 6
		signal 16400
	)
)

(instance pod of Prop
	(properties
		x 254
		y 85
		description {time pod}
		lookStr {Your high-tech but butt-ugly pod stands ready to ride those wild planes of time.}
		view 305
		loop 1
		priority 5
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(gCurRoom setScript: enterPod)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 194
		y 61
		view 305
		loop 2
		priority 10
		signal 16
	)
)

(instance theStairs of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {stairs}
		onMeCheck 16384
		lookStr {The shale-like shelves provide a stairway to the unknown.}
	)
)

(instance theRoom of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {buttes}
		lookStr {You've seen a lot of plateaus and sloping hills before, but this one's a butte.__Everywhere you look, the horizon undulates in the enticing peaks, curves and crevices for which Estros is famous.}
	)
)

