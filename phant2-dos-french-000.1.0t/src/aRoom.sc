;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3310)
(include sci.sh)
(use Main)
(use eggAMatic)
(use nExit)
(use BorderWindow)
(use Cycle)
(use Jump)

(public
	aRoom 0
)

(instance aRoom of P2Room
	(properties
		picture 170
	)

	(method (init)
		(gPlanes plane: gThePlane)
		(eggAMatic add: gCurRoomNum 1 25)
		(curtis init: setPri: 2)
		(andy init: setPri: 1 setCycle: Fwd)
		(bigScript init: 0 self)
		(super init: &rest)
		(gGame handsOff:)
	)

	(method (cue)
		(gPlanes plane: 0)
		(self newRoom: gPrevRoomNum)
	)
)

(instance curtis of Prop
	(properties
		x 377
		y 327
		view 11702
		loop 2
		cel 2
		cycleSpeed 4
	)
)

(instance andy of Prop
	(properties
		x 425
		y 147
		view 11702
		cycleSpeed 4
	)
)

(instance bigScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(sARise init: 0 self)
			)
			(2
				(for ((= temp1 0)) (< temp1 3) ((++ temp1))
					(= temp0 (GetTime 1)) ; SysTime12
					(while (== temp0 (GetTime 1)) ; SysTime12
					)
				)
				(= cycles 1)
			)
			(3
				(sALeft init: 0 self)
			)
			(4
				((sARtCLt new:) init: 0 self)
			)
			(5
				(sALtCRt init: 0 self)
			)
			(6
				((sARtCLt new:) init: 0 self)
			)
			(7
				(sCRight init: 0 self)
			)
			(8
				(sDoubleTake init: 0 self)
			)
			(9
				(for ((= temp1 0)) (< temp1 3) ((++ temp1))
					(= temp0 (GetTime 1)) ; SysTime12
					(while (== temp0 (GetTime 1)) ; SysTime12
					)
				)
				(= cycles 1)
			)
			(10
				(curtis cycleSpeed: 8 setLoop: 1 setCycle: Fwd)
				(sARight init: 0 self)
			)
			(11
				(self dispose:)
			)
		)
	)
)

(instance sARise of Script
	(properties)

	(method (cue)
		(if (> (andy y:) 50)
			(andy posn: (andy x:) (- (andy y:) 2))
			(= ticks 3)
		else
			(self dispose:)
		)
	)
)

(instance sALeft of Script
	(properties)

	(method (cue)
		(if (> (andy x:) 310)
			(andy posn: (- (andy x:) 2) (andy y:))
			(= ticks 3)
		else
			(self dispose:)
		)
	)
)

(instance sARtCLt of Script
	(properties)

	(method (cue)
		(if (< (andy x:) 540)
			(andy posn: (+ (andy x:) 2) (andy y:))
			(cond
				((< (andy x:) 350)
					(curtis setCel: 4)
				)
				((< (andy x:) 400)
					(curtis setCel: 3)
				)
				((== (andy x:) 425)
					(curtis setCel: 2)
				)
				((> (andy x:) 450)
					(curtis setCel: 1)
				)
				((> (andy x:) 500)
					(curtis setCel: 0)
				)
			)
			(= ticks 3)
		else
			(self dispose:)
		)
	)
)

(instance sALtCRt of Script
	(properties)

	(method (cue)
		(if (> (andy x:) 310)
			(andy posn: (- (andy x:) 2) (andy y:))
			(cond
				((< (andy x:) 350)
					(curtis setCel: 4)
				)
				((< (andy x:) 400)
					(curtis setCel: 3)
				)
				((== (andy x:) 425)
					(curtis setCel: 2)
				)
				((> (andy x:) 450)
					(curtis setCel: 1)
				)
				((> (andy x:) 500)
					(curtis setCel: 0)
				)
			)
			(= ticks 3)
		else
			(self dispose:)
		)
	)
)

(instance sCRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(curtis cycleSpeed: 4 setCycle: End)
				((curtis cycler:) caller: self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sDoubleTake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(curtis cycleSpeed: 1 setCycle: Beg)
				((curtis cycler:) caller: self)
			)
			(1
				(curtis cycleSpeed: 1 setCycle: End)
				((curtis cycler:) caller: self)
			)
			(2
				(curtis cycleSpeed: 1 setCycle: Beg)
				((curtis cycler:) caller: self)
			)
			(3
				(curtis cycleSpeed: 1 setCycle: End)
				((curtis cycler:) caller: self)
			)
			(4
				(curtis cycleSpeed: 1 setCycle: Beg)
				((curtis cycler:) caller: self)
			)
			(5
				(curtis cycleSpeed: 1 setCycle: End)
				((curtis cycler:) caller: self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance sARight of Script
	(properties)

	(method (cue)
		(if (< (andy x:) 700)
			(andy posn: (+ (andy x:) 3) (andy y:))
			(= ticks 3)
		else
			(self dispose:)
		)
	)
)

