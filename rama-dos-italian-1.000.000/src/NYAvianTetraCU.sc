;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5030)
(include sci.sh)
(use Main)
(use Location)
(use newYorkRegion)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	NYAvianTetraCU 0
)

(instance NYAvianTetraCU of CloseupLocation
	(properties
		heading 90
	)

	(method (init)
		(= picture 5153)
		(super init: picture &rest)
		(proc201_1 34)
		(OnSwitch init:)
		(LockSwitch init:)
		(Dial init:)
		(Monitor init:)
		(PuzzleControl init:)
		(machine_90 init:)
	)

	(method (dispose)
		(PuzzleControl dispose:)
		(super dispose: &rest)
	)
)

(class PuzzleControl of Obj
	(properties)

	(method (init)
		(super init: &rest)
		(if (IsFlag 233)
			(OnSwitch setOn:)
			(self on:)
		)
		(if (IsFlag 231)
			(LockSwitch setOn:)
			(self lock: 1)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (on)
		(SetFlag 233)
		(LockSwitch enable:)
		(Dial enable:)
		(Monitor startImage:)
		(proc201_1 35)
	)

	(method (off)
		(ClearFlag 233)
		(ClearFlag 231)
		(LockSwitch reset: disable:)
		(Dial disable:)
		(Monitor killImage:)
		(proc201_1 35)
	)

	(method (lock param1)
		(if (and argc param1)
			(SetFlag 231)
			(if (and (< global413 2) (self checkSolution:))
				(gCurRoom setScript: puzzleSolved)
			)
		else
			(ClearFlag 231)
		)
		(Monitor lockImage: param1)
	)

	(method (checkSolution)
		(return (== (Monitor cel:) 5))
	)

	(method (dialChange)
		(self lock: 0)
		(Monitor nextImage:)
		(LockSwitch reset:)
	)
)

(class OnSwitch of View
	(properties
		x 261
		y 198
		loop 4
		view 5070
	)

	(method (init)
		(&= signal $efff)
		(super init: global117 &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if cel
					(= cel 0)
					(PuzzleControl off:)
				else
					(= cel 1)
					(PuzzleControl on:)
				)
				(onSwitchSnd play:)
				(proc201_1 35)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (setOn)
		(= cel 1)
	)
)

(class LockSwitch of View
	(properties
		x 319
		y 109
		loop 3
		view 5070
	)

	(method (init)
		(&= signal $efff)
		(super init: global117 &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if cel
					(= cel 0)
					(proc1111_6)
					(proc1111_7 (+ 5100 global257) 245 15 0 0 250 0)
					(PuzzleControl lock: 0)
					(Dial setHotspot: 2)
				else
					(= cel 1)
					(proc1111_7 (+ 5000 global257) 245 15 0 0 250 1)
					(PuzzleControl lock: 1)
					(Dial deleteHotspot:)
				)
				(lockSwitchSnd play:)
				(proc201_1 35)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (disable)
		(self deleteHotspot:)
	)

	(method (enable)
		(self setHotspot: 2)
	)

	(method (reset)
		(= cel 0)
	)

	(method (setOn)
		(= cel 1)
	)
)

(class Dial of View
	(properties
		x 207
		y 122
		loop 2
		view 5070
	)

	(method (init)
		(&= signal $efff)
		(= cel global257)
		(super init: global117 &rest)
	)

	(method (dispose)
		(= global257 cel)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (> (++ cel) 7)
					(= cel 0)
				)
				(PuzzleControl dialChange:)
				(dialSnd play:)
				(= global257 cel)
				(proc201_1 35)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (disable)
		(self deleteHotspot:)
	)

	(method (enable)
		(self setHotspot: 2)
	)
)

(class Monitor of View
	(properties
		x 245
		y 15
		view 5070
	)

	(method (init)
		(super init: global117 &rest)
	)

	(method (dispose)
		(proc1111_6)
		(= global165 0)
		(super dispose: &rest)
	)

	(method (lockImage param1)
		(if (and argc param1)
			(if (not (self isLocked:))
				(= loop 1)
			)
		else
			(= loop 0)
		)
	)

	(method (isLocked)
		(return loop)
	)

	(method (nextImage)
		(if (> (++ cel) 8)
			(= cel 1)
		)
	)

	(method (killImage)
		(proc1111_6)
		(= loop (= cel 0))
	)

	(method (startImage)
		(= cel (+ global257 1))
		(= loop 0)
	)
)

(instance puzzleSolved of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(avLairUncoversSnd play: self)
			)
			(1
				(switch global413
					(0
						(= global413 2)
					)
					(1
						(= global413 3)
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance onSwitchSnd of Sound
	(properties
		number 5102
		flags 5
	)
)

(instance lockSwitchSnd of Sound
	(properties
		number 5103
		flags 5
	)
)

(instance dialSnd of Sound
	(properties
		number 5104
		flags 5
	)
)

(instance avLairUncoversSnd of Sound
	(properties
		number 5105
		flags 5
	)
)

(instance machine_90 of Feature
	(properties
		noun 36
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 183 15 199 15 202 0 394 1 391 16 412 17 420 80 453 78 458 167 435 175 439 216 356 240 356 301 216 291 194 232 164 232 154 194 180 30 182 19
					yourself:
				)
		)
	)
)

