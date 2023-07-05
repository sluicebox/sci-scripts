;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use eRS)
(use RandCycle)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm019 0
)

(local
	local0
	[local1 6]
	local7 = 47
	local8 = 255
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(if (< param1 param3)
		(= temp0 (- param1 1))
		(= temp1 (+ param3 1))
	else
		(= temp0 (- param3 1))
		(= temp1 (- param1 1))
	)
	(= temp2 (Graph grSAVE_BOX temp0 (- param2 1) temp1 (+ param4 1) 1))
	(Graph
		grDRAW_LINE
		param1
		param2
		param3
		param4
		(proc0_18 global133 global143 global143)
		-1
		-1
	)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1))
	(localproc_1)
	(Wait 1)
	(Wait 2)
	(Graph grRESTORE_BOX temp2)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1))
)

(procedure (localproc_1)
	(Animate (gCast elements:) 1)
	(egoHead setCel: 1)
	(trHead setLoop: 2 setCel: 1)
	(egoMouth hide:)
	(trMouth hide:)
	(Animate (gCast elements:) 1)
	(egoHead setCel: 0)
	(trHead setCel: 0)
	(egoMouth show:)
	(trMouth show:)
)

(instance rm019 of SQRoom
	(properties
		picture 19
	)

	(method (init &tmp [temp0 50])
		(Load rsVIEW 18)
		(Load rsVIEW 28)
		(Load rsSOUND 105)
		(super init:)
		(shot1 init:)
		(shot2 init:)
		(egoHead init:)
		(egoMouth init:)
		(trHead init:)
		(self setScript: startScript setRegions: 707) ; intro
	)
)

(instance startScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(egoMouth setCycle: RandCycle)
				(= local0
					(proc0_12
						{"Hey! I wanna know what the..."}
						67
						5
						132
						70
						300
						28
						global136
						29
						global129
						30
						0
					)
				)
				(= seconds 2)
			)
			(2
				(egoMouth setCycle: 0)
				(= seconds 2)
			)
			(3
				(egoMouth setCycle: 0)
				(trHead setCycle: End self)
			)
			(4
				(proc0_12 local0)
				(trHead setLoop: 2 setCel: 0)
				(trMouth init:)
				(= cycles 10)
			)
			(5
				(trMouth setCycle: RandCycle)
				(= local0
					(proc0_12
						{"Listen! I can't explain it all to you now! They've got a bead on our coordinates! We've got to move fast!"}
						67
						138
						132
						70
						180
						28
						global136
						29
						global129
						30
						1
					)
				)
				(= seconds 7)
			)
			(6
				(trMouth setCycle: 0)
				(proc0_12 local0)
				(= cycles 2)
			)
			(7
				(localproc_0 local7 local8 51 319)
				(shotSound play:)
				(shot1 posn: local8 local7 setCycle: End self)
				(= cycles 5)
			)
			(8
				(shot1 dispose:)
				(= cycles 2)
			)
			(9
				(-= local8 4)
				(-= local7 3)
				(localproc_0 local7 local8 51 319)
				(shotSound play:)
				(shot2 posn: local8 local7 setCycle: End self)
				(= cycles 5)
			)
			(10
				(shot2 dispose:)
				(Animate (gCast elements:) 0)
				(gCurRoom newRoom: 20)
			)
		)
	)
)

(instance shotSound of Sound
	(properties
		number 105
	)
)

(instance shot1 of Prop
	(properties
		view 28
		priority 15
		signal 16400
	)
)

(instance shot2 of Prop
	(properties
		view 28
		priority 15
		signal 16400
	)
)

(instance egoHead of Prop
	(properties
		x 41
		y 97
		view 18
	)
)

(instance trHead of Prop
	(properties
		x 187
		y 109
		view 18
		loop 4
		priority 14
		signal 16
	)
)

(instance egoMouth of Prop
	(properties
		x 53
		y 77
		view 18
		loop 1
	)
)

(instance trMouth of Prop
	(properties
		x 181
		y 104
		view 18
		loop 3
		priority 14
		signal 16400
	)
)

