;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 135)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use Button)
(use newYorkRegion)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(local
	[local0 5] = [1 9 16 23 30]
	[local5 5] = [0 8 15 22 28]
	[local10 5] = [2 10 17 24 30]
)

(class MazeController of CloseupLocation
	(properties)

	(method (init)
		(self edgeN: 0 edgeE: 0 edgeW: 0)
		(super init: &rest)
		(MCPiston init: global117)
		(if (== (proc70_9 47) gCurRoomNum)
			(self startController:)
		else
			(MazeCardSlotFeat init:)
		)
		(RightButton init: global117)
		(LeftButton init: global117)
	)

	(method (startController)
		(Lights cel: (MCPiston curPos:) init: global117)
		(MazeCtrlCard init: global117)
	)

	(method (stopController)
		(Lights dispose:)
		(MazeCardSlotFeat init:)
	)

	(method (dispose)
		(if script
			(self setScript: 0)
		)
		(gateSnd stop:)
		(buttonClick stop:)
		(pistonSeek stop:)
		(mazeCardClick stop:)
		(super dispose: &rest)
	)
)

(class MCPiston of Prop
	(properties
		view 5057
		curPos -1
		lastACel -1
	)

	(method (forward)
		(proc201_1 4)
		(if (and (< curPos 4) (not (self cycler:)))
			(gGame handsOff:)
			(= global256 (++ curPos))
			(pistonSeek play:)
			(self setCycle: CT [local0 curPos] 1 self)
		)
	)

	(method (reverse)
		(proc201_1 4)
		(if (and (> curPos 0) (not (self cycler:)))
			(gGame handsOff:)
			(= global256 (-- curPos))
			(pistonSeek play:)
			(self setCycle: CT [local0 curPos] -1 self)
		)
	)

	(method (init)
		(= curPos global256)
		(= cel [local0 curPos])
		(super init: &rest)
	)

	(method (doit)
		(super doit: &rest)
		(if (!= lastACel cel)
			(= lastACel cel)
			(Lights notify: lastACel curPos)
			(if (== cel [local0 curPos])
				(gGame handsOn:)
			)
		)
	)

	(method (cue)
		(if (gateSnd handle:)
			(gateSnd stop:)
		)
		(switch curPos
			(0
				(gateSnd number: 5501 setVol: 127 play:)
			)
			(1
				(gateSnd number: 5502 setVol: 127 play:)
			)
			(2)
			(3
				(gateSnd number: 5503 setVol: 127 play:)
			)
			(4
				(gCurRoom setScript: playAll)
			)
		)
	)

	(method (dispose)
		(= global256 curPos)
		(super dispose: &rest)
	)
)

(class MazeCardSlotFeat of Feature
	(properties
		nsLeft 278
		nsTop 182
		nsRight 320
		nsBottom 214
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 46)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(46
				(mazeCardClick play:)
				(= temp0 (gTheCursor invItem:))
				(proc70_3 (proc70_7 (gTheCursor invItem:)))
				(proc70_10 47 gCurRoomNum)
				(gCurRoom startController:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class LeftButton of Button
	(properties
		view 5057
		loop 2
	)

	(method (init)
		(&= signal $efff)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (== (proc70_9 47) gCurRoomNum)
					(buttonClick play:)
					(MCPiston reverse:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class RightButton of Button
	(properties
		view 5057
		loop 1
	)

	(method (init)
		(&= signal $efff)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (== (proc70_9 47) gCurRoomNum)
					(buttonClick play:)
					(MCPiston forward:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class Lights of View
	(properties
		view 5057
		loop 3
	)

	(method (notify param1 param2)
		(if
			(and
				(global117 contains: self)
				(>= param1 [local5 param2])
				(<= param1 [local10 param2])
			)
			(= cel param2)
			(UpdateScreenItem self)
		)
	)
)

(class MazeCtrlCard of View
	(properties
		view 5057
		loop 4
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(mazeCardClick play:)
				(proc70_1 47)
				(gCurRoom stopController:)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance playAll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gateSnd number: 5501 setVol: 127 play: self)
			)
			(1
				(gateSnd number: 5502 setVol: 127 play: self)
			)
			(2
				(gateSnd number: 5503 setVol: 127 play: self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance buttonClick of Sound
	(properties
		flags 5
		number 5025
	)
)

(instance pistonSeek of Sound
	(properties
		flags 5
		number 5026
	)
)

(instance mazeCardClick of Sound
	(properties
		flags 5
		number 5027
	)
)

(instance gateSnd of Sound
	(properties
		flags 5
	)
)

