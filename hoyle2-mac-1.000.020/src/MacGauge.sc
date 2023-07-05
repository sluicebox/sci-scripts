;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 896)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use System)

(public
	MacGauge 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 40]
)

(procedure (localproc_0 param1 param2 param3 param4 param5 param6 param7 param8 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
	(= temp0 (Event new:))
	(= temp1 (temp0 y:))
	(= temp3 param1)
	(= temp5 (+ (CelHigh (param6 view:) (param6 loop:) 0) temp3))
	(= temp2 param2)
	(= temp4 (+ (CelWide (param6 view:) (param6 loop:) 0) param2))
	(while (!= (temp0 type:) evMOUSERELEASE)
		(GetEvent 32767 temp0)
		(GlobalToLocal temp0)
		(if (< (= temp1 (- (temp0 y:) 3)) param3)
			(= temp1 param3)
		)
		(if (> temp1 param4)
			(= temp1 param4)
		)
		(if (!= temp1 temp3)
			(Graph grRESTORE_BOX global62)
			(Graph grUPDATE_BOX temp3 temp2 temp5 temp4 1)
			(= temp3 temp1)
			(= temp5 (+ (CelHigh (param6 view:) (param6 loop:) 0) temp1))
			(= global62 (Graph grSAVE_BOX temp3 temp2 temp5 temp4 1))
			(DrawCel (param6 view:) (param6 loop:) 0 param2 temp1 -1)
		)
	)
	(temp0 dispose:)
	(Graph grRESTORE_BOX global62)
	(Graph grUPDATE_BOX temp3 temp2 temp5 temp4 1)
	(= temp7 (+ (- param8 (/ (- temp1 param3) param5)) param7))
	(= temp6 (* (- param8 (- temp7 param7)) param5))
	(= global62
		(Graph
			grSAVE_BOX
			(+ (param6 nsTop:) temp6)
			param2
			(+ (CelHigh (param6 view:) (param6 loop:) 0) temp6 (param6 nsTop:))
			(+ (CelWide (param6 view:) (param6 loop:) 0) param2)
			1
		)
	)
	(DrawCel
		(param6 view:)
		(param6 loop:)
		0
		param2
		(+ (param6 nsTop:) temp6)
		-1
	)
	(return temp7)
)

(class MacGauge of Dialog
	(properties
		type 7
		description 0
		topX 0
		topY 0
		bottomY 0
		range 0
		start 0
		low 0
		view 0
		loop 0
		cel 0
		value 0
	)

	(method (init &tmp temp0 temp1 temp2)
		(= window SysWindow)
		(+= nsBottom 8)
		(= local4 (DIcon new:))
		(local4 view: view loop: loop cel: cel)
		(local4 moveTo: 4 4)
		(local4 setSize:)
		(self add: local4 setSize:)
		(= topY (+ (local4 nsTop:) topY))
		(= bottomY (- (local4 nsBottom:) bottomY))
		(= local0 (/ (- bottomY topY) range))
		(= local2 (DText new:))
		(local2 text: description font: gSmallFont setSize: (- nsRight 8))
		(= temp1 (+ (local2 nsBottom:) 4))
		(local2 moveTo: (+ 4 (local4 nsRight:)) 4)
		(self add: local2 setSize:)
		(= local3 (DButton new:))
		(local3 text: {OK} setSize: value: 1)
		(local3 moveTo: (+ (local4 nsRight:) 4) (+ (local4 nsBottom:) 8))
		(self add: local3 setSize:)
		(= local5 (DButton new:))
		(local5 text: {CANCEL} setSize: value: 2)
		(local5 moveTo: (+ (local3 nsRight:) 4) (+ (local4 nsBottom:) 8))
		(self add: local5 setSize:)
		(self setSize: center: open: 4 15)
		(local4 draw:)
		(= local1 (* (- range (- start low)) local0))
		(= global62
			(Graph
				grSAVE_BOX
				(+ (local4 nsTop:) local1)
				(+ (local4 nsLeft:) topX)
				(+
					(CelHigh (local4 view:) (local4 loop:) 0)
					local1
					(local4 nsTop:)
				)
				(+
					(CelWide (local4 view:) (local4 loop:) 0)
					topX
					(local4 nsLeft:)
				)
				1
			)
		)
		(DrawCel
			(local4 view:)
			(local4 loop:)
			0
			(+ (local4 nsLeft:) topX)
			(+ (local4 nsTop:) local1)
			-1
		)
	)

	(method (doit param1 &tmp temp0 temp1)
		(self init: param1)
		(= temp1 param1)
		(repeat
			(cond
				((== (= temp0 (super doit: local3)) local3)
					(= temp1 start)
					(break)
				)
				((or (== temp0 0) (== temp0 local5))
					(= temp1 param1)
					(break)
				)
			)
		)
		(self dispose:)
		(return temp1)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evMOUSEBUTTON
				(if
					(and
						(>
							(+
								(local4 nsLeft:)
								topX
								(CelWide (local4 view:) (local4 loop:) 0)
							)
							(event x:)
							(- (+ (local4 nsLeft:) topX) 1)
						)
						(>
							(+
								(local4 nsTop:)
								local1
								(CelHigh (local4 view:) (local4 loop:) 0)
							)
							(event y:)
							(- (+ (local4 nsTop:) local1) 1)
						)
					)
					(= start
						(localproc_0
							(+ (local4 nsTop:) local1)
							(+ (local4 nsLeft:) topX)
							topY
							bottomY
							local0
							local4
							low
							range
						)
					)
					(= local1 (* (- range (- start low)) local0))
					(event claimed: 1)
				else
					(super handleEvent: event)
				)
			)
		)
	)
)

