;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use eRS)
(use Language)
(use Osc)
(use RandCycle)
(use LoadMany)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	rm016 0
)

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
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1) ; UNUSED
	(if (< param1 param3)
		(= temp0 (- param1 1))
		(= temp1 (+ param3 1))
	else
		(= temp0 (- param3 1))
		(= temp1 (- param1 1))
	)
	(= local3 temp0)
	(= local4 param2)
	(= local5 temp1)
	(= local6 param4)
	(= local2 (Graph grSAVE_BOX temp0 (- param2 1) temp1 (+ param4 1) 1))
	(Graph grDRAW_LINE param1 param2 param3 param4 global136 -1 -1)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1))
)

(procedure (localproc_1) ; UNUSED
	(Graph grRESTORE_BOX local2)
	(Graph grREDRAW_BOX local3 (- local4 1) local5 (+ local6 1))
)

(instance rm016 of SQRoom
	(properties
		picture 16
	)

	(method (init)
		(LoadMany rsVIEW 16 7)
		(super init:)
		(self setRegions: 707) ; intro
		(alien1 init:)
		(alien2 init:)
		(alien3 init: setScript: alienScript)
		(lAnt init:)
		(rAnt init:)
		(rogHead setScript: convScript init:)
		(rogEyes init:)
		(rogMouth init:)
		(rHand init:)
		(= local0
			(proc0_12
				{We join Roger as he relates one of his (greatly exaggerated) tales of adventure. The aliens are only too happy to listen (as long as Roger is buying).}
				67
				1
				(LangSwitch 160 154)
				70
				318
				28
				global135
				29
				global129
				30
				1
				33
				68
			)
		)
	)
)

(instance alienScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(alien1 setCycle: Osc)
				(= cycles (Random 10 20))
			)
			(1
				(alien1 setCycle: 0 1)
				(= cycles (Random 10 50))
			)
			(2
				(alien2 setCycle: Osc)
				(= cycles (Random 10 20))
			)
			(3
				(alien2 setCycle: 0 1)
				(= cycles (Random 10 50))
			)
			(4
				(alien3 setCycle: Osc)
				(= cycles (Random 10 20))
			)
			(5
				(alien3 setCycle: 0 1)
				(= cycles (Random 10 50))
			)
			(6
				(self init:)
			)
		)
	)
)

(instance convScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(rogEyes setCel: 1)
				(gLongSong vol: 127 changeState:)
				(gLongSong2 number: 824 loop: -1 vol: 127 play:)
				(rogMouth setCycle: RandCycle)
				(rHand setCel: 1)
				(= seconds 2)
			)
			(2
				(rogEyes setCel: 0)
				(= local7 2)
				(rogMouth setCycle: 0 setCel: 0)
				(rHand setCel: 0)
				(= seconds 1)
			)
			(3
				(= local7 2)
				(= seconds 2)
			)
			(4
				(rAnt setCel: 2)
				(lAnt setCel: 1)
				(rogEyes setCel: 1)
				(= seconds 1)
			)
			(5
				(= local7 2)
				(rAnt setCel: 0)
				(lAnt setCel: 0)
				(rogMouth setCycle: 0 setCycle: RandCycle)
				(rHand setCel: 1)
				(= seconds 1)
			)
			(6
				(rogEyes setCel: 0)
				(= seconds 2)
			)
			(7
				(= local7 2)
				(= seconds 1)
			)
			(8
				(rogMouth setCycle: 0 setCel: 0)
				(if (not (gCurRoom script:))
					(gCurRoom setScript: spScript)
				)
				(self init:)
			)
		)
	)
)

(instance spScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Animate (gCast elements:) 0)
				(gunSp
					setCycle: Walk
					setLoop: Grooper
					init:
					setMotion: MoveTo 189 87 self
				)
				(doorSp
					setCycle: Walk
					setLoop: Grooper
					init:
					setMotion: MoveTo 164 87
				)
			)
			(1
				(doorSp setHeading: 180)
				(gunSp setHeading: 180)
				(= seconds 2)
			)
			(2
				(doorSp setHeading: 90)
				(gunSp setHeading: 270)
				(= seconds 2)
			)
			(3
				(gunSp setHeading: 180)
				(= seconds 2)
			)
			(4
				(doorSp setHeading: 180)
				(= cycles 10)
			)
			(5
				(gunSp setHeading: 90 self)
			)
			(6
				(gunSp setMotion: MoveTo 330 87 self)
			)
			(7
				(= seconds 4)
			)
			(8
				(proc0_12 local0)
				(gunSp
					view: 16
					setLoop: 6
					setCel: 0
					setStep: 10 1
					posn: 377 161
					setPri: 13
					setMotion: MoveTo 251 161 self
				)
			)
			(9
				(gunSp signal: -32719)
				(rogHead
					setPri: 15
					setScript: 0
					setCel: 0
					setLoop: 0
					posn: 132 84
				)
				(rogMouth posn: 132 84 setCycle: 0 setLoop: 3 setCel: 0)
				(rHand setCel: 0)
				(rAnt setCel: 1)
				(lAnt setCel: 2)
				(= local0
					(proc0_12
						{"Are you Roger Wilco?"}
						67
						95
						15
						70
						120
						28
						global136
						29
						global129
						30
						0
						33
						68
					)
				)
				(spHead init: setCycle: RandCycle)
				(= seconds 7)
			)
			(10
				(spHead setCycle: 0 setCel: 0)
				(proc0_12 local0)
				(Animate (gCast elements:) 0)
				(= seconds 3)
			)
			(11
				(rogMouth setCel: 0 setCycle: RandCycle 8)
				(= local0
					(proc0_12
						{"Uh, yeah."}
						67
						45
						15
						70
						160
						28
						global137
						29
						global129
						30
						0
						33
						68
					)
				)
				(= seconds 7)
			)
			(12
				(rogMouth setCel: 0)
				(proc0_12 local0)
				(Animate (gCast elements:) 0)
				(Animate (gCast elements:) 0)
				(spHead init: setCycle: RandCycle)
				(= local0
					(proc0_12
						{"Please come with me."}
						67
						90
						15
						70
						125
						28
						global136
						29
						global129
						30
						-1
						33
						68
					)
				)
				(= seconds 5)
			)
			(13
				(spHead setCycle: 0 setCel: 0)
				(= seconds 3)
			)
			(14
				(proc0_12 local0)
				(Animate (gCast elements:) 0)
				(Animate (gCast elements:) 0)
				(gLongSong fade: 80 15 10 0)
				(gLongSong2 fade:)
				(gCurRoom newRoom: 15)
			)
		)
	)
)

(instance alien1 of Prop
	(properties
		x 69
		y 74
		description {alien.}
		lookStr {It looks like a cross between a praying mantis and Richard Nixon.}
		view 19
		priority 11
		signal 16
	)
)

(instance alien2 of Prop
	(properties
		x 187
		y 86
		description {alien.}
		lookStr {Must be a duck billed planetpuss.}
		view 19
		loop 1
		priority 11
		signal 16
	)
)

(instance alien3 of Prop
	(properties
		x 249
		y 82
		description {alien.}
		lookStr {Hey, it's a gilled Thwarkian lambotraus! I havn't seen one of those in years!}
		view 19
		loop 2
		priority 11
		signal 16
	)
)

(instance lAnt of Prop
	(properties
		x 73
		y 146
		view 16
		loop 4
		cel 1
		priority 14
		signal 16
	)
)

(instance rAnt of Prop
	(properties
		x 250
		y 127
		view 16
		loop 5
		cel 1
		priority 14
		signal 16
	)
)

(instance rogHead of Prop
	(properties
		x 132
		y 85
		view 16
		cel 1
		priority 13
		signal 16400
	)
)

(instance rogEyes of View
	(properties
		x 134
		y 58
		view 16
		loop 8
		priority 14
		signal 16400
	)

	(method (doit)
		(super doit: &rest)
		(switch local7
			(1
				(= loop local8)
				(= cel local9)
				(-- local7)
			)
			(2
				(= local8 (rogEyes loop:))
				(= local9 (rogEyes cel:))
				(= loop 9)
				(= cel 1)
				(-- local7)
			)
		)
	)
)

(instance rogMouth of Prop
	(properties
		x 132
		y 82
		view 16
		loop 1
		cel 1
		priority 14
		signal 16400
	)
)

(instance rHand of Prop
	(properties
		x 135
		y 154
		view 16
		loop 2
		priority 14
		signal 16
	)
)

(instance gunSp of Actor
	(properties
		x 146
		y 50
		view 7
		cel 5
		signal 16400
	)
)

(instance doorSp of Actor
	(properties
		x 121
		y 51
		view 7
		cel 5
		signal 16400
	)
)

(instance spHead of Prop
	(properties
		x 234
		y 40
		view 16
		loop 7
		priority 15
		signal 16
	)
)

