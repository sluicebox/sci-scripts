;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3014)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use SaveManager)
(use Button)
(use ZoomCycleTo)
(use n1111)
(use VMDMovie)
(use Sound)
(use Actor)
(use System)

(public
	london_Map_Puzzle 0
)

(local
	local0
	local1 = -1
	local2 = -1
	[local3 11] = [104 168 232 297 362 427 37 22 34 19 36]
)

(procedure (localproc_0 param1 &tmp temp0)
	(= temp0 (proc70_7 param1))
	(cond
		((<= 10 temp0 15)
			(return (+ (- (proc70_7 param1) 10) 1))
		)
		((<= 83 temp0 88)
			(return (+ (- (proc70_7 param1) 83) 1))
		)
	)
)

(procedure (localproc_1 param1 param2)
	(switch param2
		(0
			(return (+ 10 (- param1 1)))
		)
		(1
			(return (+ 83 (- param1 1)))
		)
	)
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2)
	(if (== param1 1)
		(for ((= temp1 0)) (< temp1 6) ((++ temp1))
			(cond
				((!= [global285 (+ local0 temp1)] 1)
					(return 0)
				)
				((!= [global273 (+ local0 temp1)] (+ temp1 1))
					(return 0)
				)
			)
		)
		(SetFlag 111)
	else
		(if (== (= temp2 [global273 (+ local0 0)]) 0)
			(return 0)
		)
		(= temp1 0)
		(while (< temp1 6)
			(cond
				((!= [global285 (+ local0 temp1)] 0)
					(return 0)
				)
				((!= [global273 (+ local0 temp1)] temp2)
					(return 0)
				)
			)
			(= temp2 (mod temp2 6))
			(++ temp1)
			(++ temp2)
		)
		(SetFlag 97)
	)
	(return 1)
)

(procedure (localproc_3 param1 &tmp temp0)
	(if (== (gCurRoom heading:) 45)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(if (== [global273 temp0] param1)
				(return temp0)
			)
		)
	else
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(if (== [global279 temp0] param1)
				(return temp0)
			)
		)
	)
	(return -1)
)

(procedure (localproc_4)
	(= local1 0)
	(MapSlot_1 deleteHotspot:)
	(MapSlot_2 deleteHotspot:)
	(MapSlot_3 deleteHotspot:)
	(MapSlot_4 deleteHotspot:)
	(MapSlot_5 deleteHotspot:)
	(MapSlot_6 deleteHotspot:)
	(mp_B32y_Piece init:)
	(mp_B21z_Piece init:)
	(mp_B11z_Piece init:)
	(mp_B11x_Piece init:)
	(mp_NY_Piece_3 init:)
	(mp_L31x_Piece init:)
	(mp_L32y_Piece init:)
	(mp_L11z_Piece init:)
	(mp_L22z_Piece init:)
	(mp_B22x_Piece init:)
	(mp_NY_Piece_6 init:)
	(mp_L32z_Piece init:)
	(londonButton init:)
	(wheelButton init:)
	(bangkokButton init:)
	(iceportButton init:)
	(beamButton init:)
)

(procedure (localproc_5)
	(mp_B32y_Piece dispose:)
	(mp_B21z_Piece dispose:)
	(mp_B11z_Piece dispose:)
	(mp_B11x_Piece dispose:)
	(mp_NY_Piece_3 dispose:)
	(mp_L31x_Piece dispose:)
	(mp_L32y_Piece dispose:)
	(mp_L11z_Piece dispose:)
	(mp_L22z_Piece dispose:)
	(mp_B22x_Piece dispose:)
	(mp_NY_Piece_6 dispose:)
	(mp_L32z_Piece dispose:)
	(londonButton dispose:)
	(wheelButton dispose:)
	(bangkokButton dispose:)
	(iceportButton dispose:)
	(beamButton dispose:)
)

(procedure (localproc_6)
	(= local1 1)
	(MapSlot_1 hide:)
	(MapSlot_2 hide:)
	(MapSlot_3 hide:)
	(MapSlot_4 hide:)
	(MapSlot_5 hide:)
	(MapSlot_6 hide:)
	(APButton init:)
	(HPButton init:)
	(OPButton init:)
)

(procedure (localproc_7)
	(APButton dispose:)
	(HPButton dispose:)
	(OPButton dispose:)
)

(instance london_Map_Puzzle of CloseupLocation
	(properties)

	(method (init)
		(= heading global164)
		(self edgeW: 0 edgeE: 0)
		(if (== heading 45)
			(= local0 0)
		else
			(= local0 6)
		)
		(localproc_2)
		(cond
			((localproc_2 0)
				(super init: 3109)
				(MapSlot_1 init:)
				(MapSlot_2 init:)
				(MapSlot_3 init:)
				(MapSlot_4 init:)
				(MapSlot_5 init:)
				(MapSlot_6 init:)
				(localproc_4)
			)
			((localproc_2 1)
				(super init: 3121)
				(localproc_6)
			)
			(else
				(= local1 -1)
				(if (proc1111_24 110)
					(super init: 3108)
				else
					(super init: 3109)
					(MapSlot_1 init:)
					(MapSlot_2 init:)
					(MapSlot_3 init:)
					(MapSlot_4 init:)
					(MapSlot_5 init:)
					(MapSlot_6 init:)
				)
			)
		)
		(switch local2
			(0
				(londonDisplay init: cel: 4 posn: 296 139)
			)
			(1
				(bangkokDisplay init: cel: 4 posn: 296 139)
			)
			(3
				(beamDisplay init: cel: 4 posn: 296 139)
			)
			(2
				(wheelDisplay init: cel: 4 posn: 296 139)
			)
			(4
				(iceportDisplay init: cel: 4 posn: 296 139)
			)
			(5
				(octoPlazaDisplay init: cel: 4 posn: 296 139)
			)
			(7
				(humanPlazaDisplay init: cel: 4 posn: 296 139)
			)
			(6
				(avianPlazaDisplay init: cel: 4 posn: 296 139)
			)
		)
	)

	(method (newRoom)
		(if (!= local1 -1)
			(self setScript: exitRoom)
		else
			(super newRoom: &rest)
		)
	)

	(method (serialize param1)
		(if param1
			(super serialize: param1)
			(= local2 (SaveManager readWord:))
		else
			(super serialize: param1)
			(SaveManager writeWord: local2)
		)
	)
)

(instance MapSlot_1 of View
	(properties
		y 63
		view 3105
	)

	(method (init)
		(= x [local3 0])
		(&= signal $efff)
		(= loop [global285 (+ local0 0)])
		(= cel [global273 (+ local0 0)])
		(super init: global117)
		(if cel
			(self setHotspot: 2)
		else
			(self setHotspot: 53 81)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(proc70_1 (localproc_1 (self cel:) [global285 (+ local0 0)]))
				(self cel: 0)
				(= [global273 (+ local0 0)] 0)
				(self setHotspot: 53 81)
				(placePieceSound play:)
			)
			(53
				(self loop: 0)
				(self cel: (localproc_0 (= temp0 (gTheCursor invItem:))))
				(proc70_3)
				(temp0 owner: gCurRoomNum)
				(FrameOut)
				(= [global285 (+ local0 0)] 0)
				(= [global273 (+ local0 0)] cel)
				(self setHotspot: 2)
				(placePieceSound play:)
				(if (localproc_2 0)
					(localproc_4)
				)
			)
			(81
				(self loop: 1)
				(self cel: (localproc_0 (= temp0 (gTheCursor invItem:))))
				(proc70_3)
				(temp0 owner: gCurRoomNum)
				(FrameOut)
				(= [global285 (+ local0 0)] 1)
				(= [global273 (+ local0 0)] cel)
				(self setHotspot: 2)
				(placePieceSound play:)
				(if (localproc_2 1)
					(New_York_Anim play:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance MapSlot_2 of View
	(properties
		y 63
		view 3105
	)

	(method (init)
		(= x [local3 1])
		(&= signal $efff)
		(= loop [global285 (+ local0 1)])
		(= cel [global273 (+ local0 1)])
		(super init: global117)
		(if cel
			(self setHotspot: 2)
		else
			(self setHotspot: 53 81)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(proc70_1 (localproc_1 (self cel:) [global285 (+ local0 1)]))
				(self cel: 0)
				(= [global273 (+ local0 1)] 0)
				(self setHotspot: 53 81)
				(placePieceSound play:)
			)
			(53
				(self loop: 0)
				(self cel: (localproc_0 (= temp0 (gTheCursor invItem:))))
				(proc70_3)
				(temp0 owner: gCurRoomNum)
				(FrameOut)
				(= [global285 (+ local0 1)] 0)
				(= [global273 (+ local0 1)] cel)
				(self setHotspot: 2)
				(placePieceSound play:)
				(if (localproc_2 0)
					(localproc_4)
				)
			)
			(81
				(self loop: 1)
				(self cel: (localproc_0 (= temp0 (gTheCursor invItem:))))
				(proc70_3)
				(temp0 owner: gCurRoomNum)
				(FrameOut)
				(= [global285 (+ local0 1)] 1)
				(= [global273 (+ local0 1)] cel)
				(self setHotspot: 2)
				(placePieceSound play:)
				(if (localproc_2 1)
					(New_York_Anim play:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance MapSlot_3 of View
	(properties
		y 63
		view 3105
	)

	(method (init)
		(= x [local3 2])
		(&= signal $efff)
		(= loop [global285 (+ local0 2)])
		(= cel [global273 (+ local0 2)])
		(super init: global117)
		(if cel
			(self setHotspot: 2)
		else
			(self setHotspot: 53 81)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(proc70_1 (localproc_1 (self cel:) [global285 (+ local0 2)]))
				(self cel: 0)
				(= [global273 (+ local0 2)] 0)
				(self setHotspot: 53 81)
				(placePieceSound play:)
			)
			(53
				(self loop: 0)
				(self cel: (localproc_0 (= temp0 (gTheCursor invItem:))))
				(proc70_3)
				(temp0 owner: gCurRoomNum)
				(FrameOut)
				(= [global285 (+ local0 2)] 0)
				(= [global273 (+ local0 2)] cel)
				(self setHotspot: 2)
				(placePieceSound play:)
				(if (localproc_2 0)
					(localproc_4)
				)
			)
			(81
				(self loop: 1)
				(self cel: (localproc_0 (= temp0 (gTheCursor invItem:))))
				(proc70_3)
				(temp0 owner: gCurRoomNum)
				(FrameOut)
				(= [global285 (+ local0 2)] 1)
				(= [global273 (+ local0 2)] cel)
				(self setHotspot: 2)
				(placePieceSound play:)
				(if (localproc_2 1)
					(New_York_Anim play:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance MapSlot_4 of View
	(properties
		y 63
		view 3105
	)

	(method (init)
		(= x [local3 3])
		(&= signal $efff)
		(= loop [global285 (+ local0 3)])
		(= cel [global273 (+ local0 3)])
		(super init: global117)
		(if cel
			(self setHotspot: 2)
		else
			(self setHotspot: 53 81)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(proc70_1 (localproc_1 (self cel:) [global285 (+ local0 3)]))
				(self cel: 0)
				(= [global273 (+ local0 3)] 0)
				(self setHotspot: 53 81)
				(placePieceSound play:)
			)
			(53
				(self loop: 0)
				(self cel: (localproc_0 (= temp0 (gTheCursor invItem:))))
				(proc70_3)
				(temp0 owner: gCurRoomNum)
				(FrameOut)
				(= [global285 (+ local0 3)] 0)
				(= [global273 (+ local0 3)] cel)
				(self setHotspot: 2)
				(placePieceSound play:)
				(if (localproc_2 0)
					(localproc_4)
				)
			)
			(81
				(self loop: 1)
				(self cel: (localproc_0 (= temp0 (gTheCursor invItem:))))
				(proc70_3)
				(temp0 owner: gCurRoomNum)
				(FrameOut)
				(= [global285 (+ local0 3)] 1)
				(= [global273 (+ local0 3)] cel)
				(self setHotspot: 2)
				(placePieceSound play:)
				(if (localproc_2 1)
					(New_York_Anim play:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance MapSlot_5 of View
	(properties
		y 63
		view 3105
	)

	(method (init)
		(= x [local3 4])
		(&= signal $efff)
		(= loop [global285 (+ local0 4)])
		(= cel [global273 (+ local0 4)])
		(super init: global117)
		(if cel
			(self setHotspot: 2)
		else
			(self setHotspot: 53 81)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(proc70_1 (localproc_1 (self cel:) [global285 (+ local0 4)]))
				(self cel: 0)
				(= [global273 (+ local0 4)] 0)
				(self setHotspot: 53 81)
				(placePieceSound play:)
			)
			(53
				(self loop: 0)
				(self cel: (localproc_0 (= temp0 (gTheCursor invItem:))))
				(proc70_3)
				(temp0 owner: gCurRoomNum)
				(FrameOut)
				(= [global285 (+ local0 4)] 0)
				(= [global273 (+ local0 4)] cel)
				(self setHotspot: 2)
				(placePieceSound play:)
				(if (localproc_2 0)
					(localproc_4)
				)
			)
			(81
				(self loop: 1)
				(self cel: (localproc_0 (= temp0 (gTheCursor invItem:))))
				(proc70_3)
				(temp0 owner: gCurRoomNum)
				(FrameOut)
				(= [global285 (+ local0 4)] 1)
				(= [global273 (+ local0 4)] cel)
				(self setHotspot: 2)
				(placePieceSound play:)
				(if (localproc_2 1)
					(New_York_Anim play:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance MapSlot_6 of View
	(properties
		y 63
		view 3105
	)

	(method (init)
		(= x [local3 5])
		(&= signal $efff)
		(= loop [global285 (+ local0 5)])
		(= cel [global273 (+ local0 5)])
		(super init: global117)
		(if cel
			(self setHotspot: 2)
		else
			(self setHotspot: 53 81)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(2
				(proc70_1 (localproc_1 (self cel:) [global285 (+ local0 5)]))
				(self cel: 0)
				(= [global273 (+ local0 5)] 0)
				(self setHotspot: 53 81)
				(placePieceSound play:)
			)
			(53
				(self loop: 0)
				(self cel: (localproc_0 (= temp0 (gTheCursor invItem:))))
				(proc70_3)
				(temp0 owner: gCurRoomNum)
				(FrameOut)
				(= [global285 (+ local0 5)] 0)
				(= [global273 (+ local0 5)] cel)
				(self setHotspot: 2)
				(placePieceSound play:)
				(if (localproc_2 0)
					(localproc_4)
				)
			)
			(81
				(self loop: 1)
				(self cel: (localproc_0 (= temp0 (gTheCursor invItem:))))
				(proc70_3)
				(temp0 owner: gCurRoomNum)
				(FrameOut)
				(= [global285 (+ local0 5)] 1)
				(= [global273 (+ local0 5)] cel)
				(self setHotspot: 2)
				(placePieceSound play:)
				(if (localproc_2 1)
					(New_York_Anim play:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance londonButton of Button
	(properties
		y 120
		view 3105
		loop 2
		downCel 0
	)

	(method (init)
		(= x (+ [local3 (localproc_3 1)] 45))
		(super init: global117)
		(gMouseDownHandler delete: self)
		(self setHotspot: 2)
	)

	(method (cue)
		(gGame handsOn:)
		(localproc_5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gTheCursor setNormalCursor:)
				(gGame handsOff:)
				(londonDisplay init: setCycle: ZoomCycleTo 4 296 139 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wheelButton of Button
	(properties
		y 150
		view 3105
		loop 2
		cel 1
		upCel 1
	)

	(method (init)
		(= x (+ [local3 (localproc_3 2 (gCurRoom heading:))] 30))
		(super init: global117)
		(gMouseDownHandler delete: self)
		(self setHotspot: 2)
	)

	(method (cue)
		(gGame handsOn:)
		(localproc_5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gTheCursor setNormalCursor:)
				(gGame handsOff:)
				(wheelDisplay init: setCycle: ZoomCycleTo 4 296 139 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bangkokButton of Button
	(properties
		y 121
		view 3105
		loop 2
		cel 2
		upCel 2
		downCel 2
	)

	(method (init)
		(= x (+ [local3 (localproc_3 3)] 43))
		(super init: global117)
		(gMouseDownHandler delete: self)
		(self setHotspot: 2)
	)

	(method (cue)
		(gGame handsOn:)
		(localproc_5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gTheCursor setNormalCursor:)
				(gGame handsOff:)
				(bangkokDisplay init: setCycle: ZoomCycleTo 4 296 139 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance iceportButton of Button
	(properties
		y 75
		view 3105
		loop 2
		cel 3
		upCel 3
		downCel 3
	)

	(method (init)
		(= x (+ [local3 (localproc_3 5)] 27))
		(super init: global117)
		(gMouseDownHandler delete: self)
		(self setHotspot: 2)
	)

	(method (cue)
		(gGame handsOn:)
		(localproc_5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gTheCursor setNormalCursor:)
				(gGame handsOff:)
				(iceportDisplay init: setCycle: ZoomCycleTo 4 296 139 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance beamButton of Button
	(properties
		y 141
		view 3105
		loop 2
		cel 4
		upCel 4
		downCel 4
	)

	(method (init)
		(= x (+ [local3 (localproc_3 6)] 44))
		(super init: global117)
		(gMouseDownHandler delete: self)
		(self setHotspot: 2)
	)

	(method (cue)
		(gGame handsOn:)
		(localproc_5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gTheCursor setNormalCursor:)
				(gGame handsOff:)
				(beamDisplay init: setCycle: ZoomCycleTo 4 296 139 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance APButton of Button
	(properties
		x 244
		y 137
		view 3105
		loop 2
		cel 6
		upCel 6
		downCel 6
	)

	(method (init)
		(&= signal $efff)
		(super init: global117)
		(gMouseDownHandler delete: self)
		(self setHotspot: 2)
	)

	(method (cue)
		(gGame handsOn:)
		(localproc_7)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gTheCursor setNormalCursor:)
				(gGame handsOff:)
				(avianPlazaDisplay init: setCycle: ZoomCycleTo 4 296 139 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance OPButton of Button
	(properties
		x 309
		y 137
		view 3105
		loop 2
		cel 6
		upCel 6
		downCel 6
	)

	(method (init)
		(&= signal $efff)
		(super init: global117)
		(gMouseDownHandler delete: self)
		(self setHotspot: 2)
	)

	(method (cue)
		(gGame handsOn:)
		(localproc_7)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gTheCursor setNormalCursor:)
				(gGame handsOff:)
				(octoPlazaDisplay init: setCycle: ZoomCycleTo 4 296 139 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance HPButton of Button
	(properties
		x 377
		y 137
		view 3105
		loop 2
		cel 6
		upCel 6
		downCel 6
	)

	(method (init)
		(&= signal $efff)
		(super init: global117)
		(gMouseDownHandler delete: self)
		(self setHotspot: 2)
	)

	(method (cue)
		(gGame handsOn:)
		(localproc_7)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(gTheCursor setNormalCursor:)
				(gGame handsOff:)
				(humanPlazaDisplay init: setCycle: ZoomCycleTo 4 296 139 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance londonDisplay of Prop
	(properties
		view 3120
		cycleSpeed 2
	)

	(method (init)
		(= cel 0)
		(= x (londonButton x:))
		(= y (londonButton y:))
		(super init: global117)
		(self setHotspot: 2)
		(self setPri: 255)
		(= local2 0)
	)

	(method (cue)
		(super dispose:)
		(gGame handsOn:)
		(localproc_4)
		(if (gCurRoom script:)
			((gCurRoom script:) cue:)
		)
	)

	(method (dispose param1)
		(= local2 -1)
		(if (and argc param1)
			(gGame handsOff:)
			(self
				setCycle: ZoomCycleTo 0 (londonButton x:) (londonButton y:) self
			)
		else
			(super dispose:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self dispose: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wheelDisplay of Prop
	(properties
		view 3122
		cycleSpeed 2
	)

	(method (init)
		(= cel 0)
		(= x (wheelButton x:))
		(= y (wheelButton y:))
		(super init: global117)
		(self setHotspot: 2)
		(self setPri: 255)
		(= local2 2)
	)

	(method (cue)
		(super dispose:)
		(gGame handsOn:)
		(localproc_4)
		(if (gCurRoom script:)
			((gCurRoom script:) cue:)
		)
	)

	(method (dispose param1)
		(= local2 -1)
		(if (and argc param1)
			(gGame handsOff:)
			(self
				setCycle: ZoomCycleTo 0 (wheelButton x:) (wheelButton y:) self
			)
		else
			(super dispose:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self dispose: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bangkokDisplay of Prop
	(properties
		view 3124
		cycleSpeed 2
	)

	(method (init)
		(= cel 0)
		(= x (bangkokButton x:))
		(= y (bangkokButton y:))
		(super init: global117)
		(self setHotspot: 2)
		(self setPri: 255)
		(= local2 1)
	)

	(method (cue)
		(super dispose:)
		(gGame handsOn:)
		(localproc_4)
		(if (gCurRoom script:)
			((gCurRoom script:) cue:)
		)
	)

	(method (dispose param1)
		(= local2 -1)
		(if (and argc param1)
			(gGame handsOff:)
			(self
				setCycle:
					ZoomCycleTo
					0
					(bangkokButton x:)
					(bangkokButton y:)
					self
			)
		else
			(super dispose:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self dispose: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance iceportDisplay of Prop
	(properties
		view 3123
		cycleSpeed 2
	)

	(method (init)
		(= cel 0)
		(= x (iceportButton x:))
		(= y (iceportButton y:))
		(super init: global117)
		(self setHotspot: 2)
		(self setPri: 255)
		(= local2 4)
	)

	(method (cue)
		(super dispose:)
		(gGame handsOn:)
		(localproc_4)
		(if (gCurRoom script:)
			((gCurRoom script:) cue:)
		)
	)

	(method (dispose param1)
		(= local2 -1)
		(if (and argc param1)
			(gGame handsOff:)
			(self
				setCycle:
					ZoomCycleTo
					0
					(iceportButton x:)
					(iceportButton y:)
					self
			)
		else
			(super dispose:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self dispose: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance beamDisplay of Prop
	(properties
		view 3121
		cycleSpeed 2
	)

	(method (init)
		(= cel 0)
		(= x (beamButton x:))
		(= y (beamButton y:))
		(super init: global117)
		(self setHotspot: 2)
		(self setPri: 255)
		(= local2 3)
	)

	(method (cue)
		(super dispose:)
		(gGame handsOn:)
		(localproc_4)
		(if (gCurRoom script:)
			((gCurRoom script:) cue:)
		)
	)

	(method (dispose param1)
		(= local2 -1)
		(if (and argc param1)
			(gGame handsOff:)
			(self setCycle: ZoomCycleTo 0 (beamButton x:) (beamButton y:) self)
		else
			(super dispose:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self dispose: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance octoPlazaDisplay of Prop
	(properties
		view 3125
		cycleSpeed 2
	)

	(method (init)
		(= cel 0)
		(= x (OPButton x:))
		(= y (OPButton y:))
		(super init: global117)
		(self setHotspot: 2)
		(self setPri: 255)
		(= local2 5)
	)

	(method (cue)
		(super dispose:)
		(gGame handsOn:)
		(localproc_6)
		(if (gCurRoom script:)
			((gCurRoom script:) cue:)
		)
	)

	(method (dispose param1)
		(= local2 -1)
		(if (and argc param1)
			(gGame handsOff:)
			(self setCycle: ZoomCycleTo 0 (OPButton x:) (OPButton y:) self)
		else
			(super dispose:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self dispose: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance humanPlazaDisplay of Prop
	(properties
		view 3128
		cycleSpeed 2
	)

	(method (init)
		(= cel 0)
		(= x (HPButton x:))
		(= y (HPButton y:))
		(super init: global117)
		(self setHotspot: 2)
		(self setPri: 255)
		(= local2 7)
	)

	(method (cue)
		(super dispose:)
		(gGame handsOn:)
		(localproc_6)
		(if (gCurRoom script:)
			((gCurRoom script:) cue:)
		)
	)

	(method (dispose param1)
		(= local2 -1)
		(if (and argc param1)
			(gGame handsOff:)
			(self setCycle: ZoomCycleTo 0 (HPButton x:) (HPButton y:) self)
		else
			(super dispose:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self dispose: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance avianPlazaDisplay of Prop
	(properties
		view 3127
		cycleSpeed 2
	)

	(method (init)
		(= cel 0)
		(= x (APButton x:))
		(= y (APButton y:))
		(super init: global117)
		(self setHotspot: 2)
		(self setPri: 255)
		(= local2 6)
	)

	(method (cue)
		(super dispose:)
		(gGame handsOn:)
		(localproc_6)
		(if (gCurRoom script:)
			((gCurRoom script:) cue:)
		)
	)

	(method (dispose param1)
		(= local2 -1)
		(if (and argc param1)
			(gGame handsOff:)
			(self setCycle: ZoomCycleTo 0 (APButton x:) (APButton y:) self)
		else
			(super dispose:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self dispose: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mp_B32y_Piece of View
	(properties
		view 3105
		loop 2
		cel 5
	)

	(method (init)
		(switch (proc70_9 62)
			(-1
				(return)
			)
			(-2
				(return)
			)
			(-3
				(return)
			)
			(3040
				(= x (+ [local3 (localproc_3 2)] 51))
				(= y 138)
			)
			(else
				(= x (+ [local3 (localproc_3 2)] 30))
				(= y 149)
			)
		)
		(super init: global117)
		(self setPri: 250)
	)
)

(instance mp_B21z_Piece of View
	(properties
		view 3105
		loop 2
		cel 5
	)

	(method (init)
		(switch (proc70_9 54)
			(-1
				(return)
			)
			(-2
				(return)
			)
			(-3
				(return)
			)
			(3040
				(= x (+ [local3 (localproc_3 2)] 51))
				(= y 138)
			)
			(else
				(= x (+ [local3 (localproc_3 2)] 39))
				(= y 141)
			)
		)
		(super init: global117)
		(self setPri: 250)
	)
)

(instance mp_B11z_Piece of View
	(properties
		view 3105
		loop 2
		cel 5
	)

	(method (init)
		(switch (proc70_9 51)
			(-1
				(return)
			)
			(-2
				(return)
			)
			(-3
				(return)
			)
			(3040
				(= x (+ [local3 (localproc_3 2)] 51))
				(= y 138)
			)
			(else
				(= x (+ [local3 (localproc_3 2)] 37))
				(= y 135)
			)
		)
		(super init: global117)
		(self setPri: 250)
	)
)

(instance mp_B11x_Piece of View
	(properties
		view 3105
		loop 2
		cel 5
	)

	(method (init)
		(switch (proc70_9 49)
			(-1
				(return)
			)
			(-2
				(return)
			)
			(-3
				(return)
			)
			(3040
				(= x (+ [local3 (localproc_3 2)] 51))
				(= y 138)
			)
			(else
				(= x (+ [local3 (localproc_3 2)] 44))
				(= y 134)
			)
		)
		(super init: global117)
		(self setPri: 250)
	)
)

(instance mp_L31x_Piece of View
	(properties
		view 3105
		loop 2
		cel 5
	)

	(method (init)
		(switch (proc70_9 73)
			(-1
				(return)
			)
			(-2
				(return)
			)
			(-3
				(return)
			)
			(3040
				(= x (+ [local3 (localproc_3 6)] 39))
				(= y 142)
			)
			(else
				(= x (+ [local3 (localproc_3 6)] 31))
				(= y 135)
			)
		)
		(super init: global117)
		(self setPri: 250)
	)
)

(instance mp_L32y_Piece of View
	(properties
		view 3105
		loop 2
		cel 5
	)

	(method (init)
		(switch (proc70_9 77)
			(-1
				(return)
			)
			(-2
				(return)
			)
			(-3
				(return)
			)
			(3040
				(= x (+ [local3 (localproc_3 6)] 39))
				(= y 142)
			)
			(else
				(= x (+ [local3 (localproc_3 6)] 40))
				(= y 142)
			)
		)
		(super init: global117)
		(self setPri: 250)
	)
)

(instance mp_L22z_Piece of View
	(properties
		view 3105
		loop 2
		cel 5
	)

	(method (init)
		(switch (proc70_9 72)
			(-1
				(return)
			)
			(-2
				(return)
			)
			(-3
				(return)
			)
			(else
				(= x (+ [local3 (localproc_3 6)] 39))
				(= y 142)
			)
		)
		(super init: global117)
		(self setPri: 250)
	)
)

(instance mp_B22x_Piece of View
	(properties
		view 3105
		loop 2
		cel 5
	)

	(method (init)
		(switch (proc70_9 55)
			(-1
				(return)
			)
			(-2
				(return)
			)
			(-3
				(return)
			)
			(else
				(= x (+ [local3 (localproc_3 6)] 31))
				(= y 135)
			)
		)
		(super init: global117)
		(self setPri: 250)
	)
)

(instance mp_L11z_Piece of View
	(properties
		view 3105
		loop 2
		cel 5
	)

	(method (init)
		(switch (proc70_9 66)
			(-1
				(return)
			)
			(-2
				(return)
			)
			(-3
				(return)
			)
			(3040
				(= x (+ [local3 (localproc_3 6)] 39))
				(= y 142)
			)
			(else
				(= x (+ [local3 (localproc_3 6)] 46))
				(= y 126)
			)
		)
		(super init: global117)
		(self setPri: 250)
	)
)

(instance mp_NY_Piece_3 of View
	(properties
		view 3105
		loop 2
		cel 5
	)

	(method (init)
		(switch (proc70_9 85)
			(-1
				(return)
			)
			(-2
				(return)
			)
			(-3
				(return)
			)
			(3040
				(= x (+ [local3 (localproc_3 6)] 49))
				(= y 142)
			)
			(3014
				(return)
			)
			(else
				(= x (+ [local3 (localproc_3 6)] 35))
				(= y 137)
			)
		)
		(super init: global117)
		(self setPri: 250)
	)
)

(instance mp_NY_Piece_6 of View
	(properties
		view 3105
		loop 2
		cel 5
	)

	(method (init)
		(switch (proc70_9 88)
			(-1
				(return)
			)
			(-2
				(return)
			)
			(-3
				(return)
			)
			(3014
				(return)
			)
			(else
				(= x (+ [local3 (localproc_3 1)] 38))
				(= y 123)
			)
		)
		(super init: global117)
		(self setPri: 250)
	)
)

(instance mp_L32z_Piece of View
	(properties
		view 3105
		loop 2
		cel 5
	)

	(method (init)
		(switch (proc70_9 78)
			(-1
				(return)
			)
			(-2
				(return)
			)
			(-3
				(return)
			)
			(else
				(= x (+ [local3 (localproc_3 1)] 38))
				(= y 125)
			)
		)
		(super init: global117)
		(self setPri: 250)
	)
)

(instance New_York_Anim of VMDMovie
	(properties
		movieName 3206
		endPic 3121
	)

	(method (play)
		(localproc_6)
		(super play: &rest)
	)
)

(instance exitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch local2
					(0
						(londonDisplay dispose: 1)
					)
					(1
						(bangkokDisplay dispose: 1)
					)
					(3
						(beamDisplay dispose: 1)
					)
					(2
						(wheelDisplay dispose: 1)
					)
					(4
						(iceportDisplay dispose: 1)
					)
					(5
						(octoPlazaDisplay dispose: 1)
					)
					(7
						(humanPlazaDisplay dispose: 1)
					)
					(6
						(avianPlazaDisplay dispose: 1)
					)
					(else
						(= seconds 1)
					)
				)
			)
			(1
				(if (== local1 0)
					(localproc_5)
				else
					(localproc_7)
				)
				(= seconds 1)
			)
			(2
				(= local1 -1)
				(FrameOut)
				(gGame handsOn:)
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance placePieceSound of Sound
	(properties
		flags 5
		number 3005
	)
)

