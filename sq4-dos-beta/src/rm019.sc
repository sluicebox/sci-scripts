;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use SQRoom)
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
	(Graph grDRAW_LINE param1 param2 param3 param4 global133 -1 -1)
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
						{"Hey, what the..."}
						67
						5
						132
						70
						300
						28
						global135
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
				(= seconds 2)
			)
			(5
				(trMouth setCycle: RandCycle)
				(= local0
					(proc0_12
						{"Listen! There's no time to explain! They've\ngot a bead on our coordinates!"}
						67
						5
						132
						70
						300
						28
						global135
						29
						global129
						30
						-1
					)
				)
				(= seconds 4)
			)
			(6
				(trMouth setCycle: 0)
				(proc0_12 local0)
				(= cycles 2)
			)
			(7
				(localproc_0 47 255 51 319)
				(shotSound play:)
				(shot1 posn: 255 47 init: setCycle: End self)
			)
			(8
				(= seconds 2)
			)
			(9
				(shot1 dispose:)
				(= cycles 2)
			)
			(10
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

