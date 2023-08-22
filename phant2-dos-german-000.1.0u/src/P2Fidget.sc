;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63015)
(include sci.sh)
(use Main)
(use Array)
(use Cycle)
(use Jump)
(use System)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10 = -1
	local11
	local12
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(= temp0 (wiggleArray indexOf: param1))
	(switch local9
		(0
			(if (!= (= temp1 (- (wiggleArray size:) 1)) temp0)
				(wiggleArray at: (+ temp0 1))
				(return)
			else
				(= local9 -1)
				(= local8 0)
				(localproc_1 20 35)
				(wiggleArray at: temp1)
				(return)
			)
		)
		(-1
			(if (!= (= temp1 0) temp0)
				(wiggleArray at: (- temp0 1))
				(return)
			else
				(= local9 1)
				(= local8 0)
				(localproc_1 10 25)
				(wiggleArray at: temp1)
				(return)
			)
		)
		(1
			(= temp1 (- (wiggleArray size:) 1))
			(if (!= local10 temp0)
				(wiggleArray at: (+ temp0 1))
				(return)
			else
				(= local9 0)
				(= local11 -1)
				(= local8 0)
				(= local10 -1)
				(wiggleArray at: temp0)
				(return)
			)
		)
	)
)

(procedure (localproc_1 param1 param2)
	(if argc
		(= local12 (Random param1 param2))
	else
		(= local12 (Random 90 150))
	)
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (= temp1 (= temp2 (= temp3 1))))
	(cond
		((or (== (param1 zone1aLeft:) 0) (== (param1 zone1aRight:) 0))
			(= temp0 0)
		)
		((or (== (param1 zone1bLeft:) 0) (== (param1 zone1bRight:) 0))
			(= temp1 0)
		)
		((or (== (param1 zone2aLeft:) 0) (== (param1 zone2aRight:) 0))
			(= temp2 0)
		)
		((or (== (param1 zone2bLeft:) 0) (== (param1 zone2bRight:) 0))
			(= temp3 0)
		)
	)
	(= local3
		(/
			(- (= local2 (/ (= local1 (param1 origin:)) 2)) 0)
			(+ temp0 (Abs (- (param1 zone1aLeft:) (param1 zone1aRight:))))
		)
	)
	(= local4
		(/
			(- local1 local2)
			(+ temp1 (Abs (- (param1 zone1bLeft:) (param1 zone1bRight:))))
		)
	)
	(= local6
		(/
			(- (= local5 (+ (/ (- 640 local1) 2) local1)) local1)
			(+ temp2 (Abs (- (param1 zone2aLeft:) (param1 zone2aRight:))))
		)
	)
	(= local7
		(/
			(- 640 local5)
			(+ temp3 (Abs (- (param1 zone2bLeft:) (param1 zone2bRight:))))
		)
	)
)

(class P2Fidget of Prop
	(properties
		dir 1
		time 0
		initStart 4
		initFinish 10
		cycleStart 4
		cycleFinish 10
		wholeCycle 0
		wiggler 0
		delay 0
		zone1aLeft -1
		zone1aRight -1
		zone1bLeft -1
		zone1bRight -1
		zone2aLeft -1
		zone2aRight -1
		zone2bLeft -1
		zone2bRight -1
		origin -1
	)

	(method (init)
		(self needsEvents: 0)
		(super init: &rest)
		(if wiggler
			(if (== origin -1)
				(= origin x)
			)
			(= local0 (= local8 (= local9 0)))
			(= local10 -1)
			(= local11 (((gUser curEvent:) localize: gThePlane) x:))
			(= local2 (= local3 (= local4 (= local5 (= local6 (= local7 0))))))
			(localproc_2 self)
			(wiggleArray init: self)
			(self cel: (wiggleArray at: 0))
			(self setCycle: wigglerCycle)
			(return)
		)
		(if (== dir -1)
			(self cel: (self lastCel:))
		)
		(cond
			(
				(and
					(== initStart 0)
					(== initFinish 0)
					(== cycleStart 0)
					(== cycleFinish 0)
				)
				(switch dir
					(1
						(self setCycle: constantCycle (self lastCel:) (= dir 1))
					)
					(-1
						(self setCycle: constantCycle 0 (= dir -1))
					)
				)
			)
			((and (== initStart 0) (== initFinish 0))
				(if wholeCycle
					(switch dir
						(1
							(self
								setCycle:
									onceThruCycle
									(self lastCel:)
									(= dir 1)
									self
							)
						)
						(-1
							(self setCycle: onceThruCycle 0 (= dir -1) self)
						)
					)
				else
					(switch dir
						(1
							(self
								setCycle:
									fidCycle
									(self lastCel:)
									(= dir 1)
									self
							)
						)
						(-1
							(self setCycle: fidCycle 0 (= dir -1) self)
						)
					)
				)
			)
			(else
				(= time
					(FidTimer
						new:
							self
							3
							(Random (self initStart:) (self initFinish:))
					)
				)
			)
		)
	)

	(method (cue)
		(if time
			(= time 0)
			(cond
				((and (== cycleStart 0) (== cycleFinish 0))
					(switch dir
						(1
							(self
								setCycle:
									constantCycle
									(self lastCel:)
									(= dir 1)
							)
						)
						(-1
							(self setCycle: constantCycle 0 (= dir -1))
						)
					)
				)
				(wholeCycle
					(switch dir
						(1
							(self
								setCycle:
									onceThruCycle
									(self lastCel:)
									(= dir 1)
									self
							)
						)
						(-1
							(self setCycle: onceThruCycle 0 (= dir -1) self)
						)
					)
				)
				(else
					(switch dir
						(1
							(self
								setCycle:
									fidCycle
									(self lastCel:)
									(= dir 1)
									self
							)
						)
						(-1
							(self setCycle: fidCycle 0 (= dir -1) self)
						)
					)
				)
			)
		else
			(= time
				(FidTimer
					new: self 3 (Random (self cycleStart:) (self cycleFinish:))
				)
			)
		)
	)

	(method (dispose)
		(if (and time (== gCurRoomNum gNewRoomNum))
			((self time:) dispose:)
		)
		(= time 0)
		(super dispose:)
	)
)

(class fidCycle of CT
	(properties)

	(method (nextCel &tmp temp0 temp1)
		(= temp1 (client cel:))
		(= temp0 (super nextCel:))
		(= completed 0)
		(if (== temp0 endCel)
			(= completed 1)
			(client dir: (* (client dir:) -1))
		)
		(return temp0)
	)
)

(class constantCycle of CT
	(properties)

	(method (nextCel &tmp temp0 temp1)
		(= temp1 (client cel:))
		(= temp0 (super nextCel:))
		(= completed 0)
		(if (== temp0 endCel)
			(switch cycleDir
				(1
					(= endCel 0)
					(= cycleDir -1)
				)
				(-1
					(= endCel (client lastCel:))
					(= cycleDir 1)
				)
			)
		)
		(return temp0)
	)
)

(class onceThruCycle of CT
	(properties)

	(method (nextCel &tmp temp0 temp1)
		(= temp1 (client cel:))
		(= temp0 (super nextCel:))
		(= completed 0)
		(if (== temp0 endCel)
			(switch cycleDir
				(1
					(switch (client dir:)
						(1
							(= endCel 0)
							(= cycleDir -1)
						)
						(-1
							(= completed 1)
						)
					)
				)
				(-1
					(switch (client dir:)
						(1
							(= completed 1)
						)
						(-1
							(= endCel (client lastCel:))
							(= cycleDir 1)
						)
					)
				)
			)
		)
		(return temp0)
	)
)

(class FidTimer of Cue
	(properties
		plane 0
		type -1
		cycles -1
		seconds -1
		ticks -1
		lastTime -1
	)

	(method (new param1 param2 param3 &tmp temp0)
		(= temp0 (super new: param1))
		(if (>= argc 3)
			(temp0 set: param2 param3 &rest)
		)
		(return temp0)
	)

	(method (dispose)
		(super dispose: &rest)
	)

	(method (doit &tmp temp0)
		(switch type
			(1
				(if (not (-- cycles))
					(super doit:)
				)
			)
			(3
				(if (!= lastTime (= temp0 (GetTime 1))) ; SysTime12
					(= lastTime temp0)
					(if (not (-- seconds))
						(super doit:)
					)
				)
			)
			(2
				(if (> (- gGameTime ticks) 0)
					(super doit:)
				)
			)
			(else
				(PrintDebug {Unknown Timer type: %d\n} type)
				(SetDebug self)
			)
		)
	)

	(method (set param1 param2)
		(switch param1
			(1
				(self setCycle: param2)
			)
			(2
				(self setTicks: param2)
			)
			(3
				(self setReal: param2 &rest)
			)
			(else
				(PrintDebug {Unknown Timer type: %d\n} param1)
				(SetDebug self)
			)
		)
	)

	(method (setCycle param1)
		(= type 1)
		(= cycles param1)
	)

	(method (setReal param1 param2 param3)
		(= type 3)
		(++ param1)
		(if (> argc 2)
			(+= param1 (* param2 60))
		)
		(if (> argc 3)
			(+= param1 (* param3 3600))
		)
		(= seconds param1)
	)

	(method (setTicks param1)
		(= type 2)
		(= ticks (+ (GetTime) param1 gTickOffset))
	)
)

(instance wigglerCycle of CT
	(properties)

	(method (nextCel &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp2 (client cel:))
		(if ((gUser curEvent:) claimed:)
			(return temp2)
		)
		(if (< (++ local0) (client delay:))
			(return temp2)
		)
		(= local0 0)
		(= temp0 (((gUser curEvent:) localize: gThePlane) x:))
		(= completed 0)
		(cond
			((< temp0 local1)
				(if (> temp0 local2)
					(= temp1 local4)
					(if (> (client zone1bLeft:) (client zone1bRight:))
						(= temp3
							(+
								(/ (- local1 temp0) local4)
								(client zone1bRight:)
							)
						)
					else
						(= temp3
							(-
								(client zone1bRight:)
								(/ (- local1 temp0) local4)
							)
						)
					)
				else
					(= temp1 local3)
					(if (> (client zone1aLeft:) (client zone1aRight:))
						(= temp3
							(+
								(/ (- local2 temp0) local3)
								(client zone1aRight:)
							)
						)
					else
						(= temp3
							(-
								(client zone1aRight:)
								(/ (- local2 temp0) local3)
							)
						)
					)
				)
			)
			((< temp0 local5)
				(= temp1 local6)
				(if (> (client zone2aLeft:) (client zone2aRight:))
					(= temp3
						(+ (/ (- local5 temp0) local6) (client zone2aRight:))
					)
				else
					(= temp3
						(- (client zone2aRight:) (/ (- local5 temp0) local6))
					)
				)
			)
			(else
				(= temp1 local7)
				(if (> (client zone2bLeft:) (client zone2bRight:))
					(= temp3 (+ (/ (- 640 temp0) local7) (client zone2bRight:)))
				else
					(= temp3 (- (client zone2bRight:) (/ (- 640 temp0) local7)))
				)
			)
		)
		(= temp4 (wiggleArray indexOf: temp2))
		(= temp5 (wiggleArray indexOf: temp3))
		(if (or (== temp4 -1) (== temp5 -1) (< temp0 0) (> temp0 640))
			(return temp2)
		)
		(cond
			((!= local11 temp0)
				(= local11 temp0)
				(= local8 0)
				(= local9 0)
				(= local10 -1)
				(localproc_1)
			)
			((> (++ local8) local12)
				(if (== local10 -1)
					(= local10 (wiggleArray indexOf: temp2))
				)
				(return (localproc_0 temp2))
			)
		)
		(cond
			((!= local10 -1)
				(return temp2)
			)
			((< temp4 temp5)
				(return (wiggleArray at: (+ temp4 1)))
			)
			((> temp4 temp5)
				(return (wiggleArray at: (- temp4 1)))
			)
		)
		(return temp2)
	)
)

(instance wiggleArray of IntArray
	(properties)

	(method (init param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(= temp3 (param1 zone1aLeft:))
		(= temp4 (param1 zone1aRight:))
		(= temp5 (param1 zone1bLeft:))
		(= temp6 (param1 zone1bRight:))
		(= temp7 (param1 zone2aLeft:))
		(= temp8 (param1 zone2aRight:))
		(= temp9 (param1 zone2bLeft:))
		(= temp10 (param1 zone2bRight:))
		(if data
			(KArray 4 data) ; ArrayFree
		)
		(= data (KArray 0 1 type)) ; ArrayNew
		(self at: 0 temp3)
		(= temp1 (if (> temp3 temp4) -1 else 1))
		(for ((= temp0 1)) (<= temp0 (Abs (- temp3 temp4))) ((++ temp0))
			(= temp2 (self at: (- (self size:) 1)))
			(self at: (self size:) (+ temp2 temp1))
		)
		(self at: (self size:) temp5)
		(= temp1 (if (> temp5 temp6) -1 else 1))
		(for ((= temp0 1)) (<= temp0 (Abs (- temp5 temp6))) ((++ temp0))
			(= temp2 (self at: (- (self size:) 1)))
			(self at: (self size:) (+ temp2 temp1))
		)
		(self at: (self size:) temp7)
		(= temp1 (if (> temp7 temp8) -1 else 1))
		(for ((= temp0 1)) (<= temp0 (Abs (- temp7 temp8))) ((++ temp0))
			(= temp2 (self at: (- (self size:) 1)))
			(self at: (self size:) (+ temp2 temp1))
		)
		(self at: (self size:) temp9)
		(= temp1 (if (> temp9 temp10) -1 else 1))
		(for ((= temp0 1)) (<= temp0 (Abs (- temp9 temp10))) ((++ temp0))
			(= temp2 (self at: (- (self size:) 1)))
			(self at: (self size:) (+ temp2 temp1))
		)
	)
)

