;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use Osc)
(use LoadMany)
(use Grooper)
(use Motion)
(use System)

(public
	rm016 0
)

(local
	[local0 7]
	local7
	[local8 2]
)

(instance rm016 of SQRoom
	(properties
		picture 16
	)

	(method (init)
		(LoadMany rsVIEW 16 7 19)
		(super init:)
		(gLongSong setVol: 127)
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
				(gNarrator ; "We join Roger as he relates one of his greatly exaggerated tales of adventure. The aliens are only too happy to listen (as long as Roger is buying)."
					modeless: 1
					returnVal: 0
					nMsgType: 2
					say:
						1
						self
						2
						64
						1
						160
						67
						318
						25
						global135
						26
						global129
						27
						1
						30
						68
				)
			)
			(1
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 2)
			)
			(2
				(if (not (gCurRoom script:))
					(gCurRoom setScript: spScript)
				)
				(= cycles 10)
			)
			(3
				(rogEyes setCel: 1)
				(gLongSong2 number: 824 loop: -1 vol: 127 play:)
				(if global83
					(tROGER
						modeless: 1
						init: 0 rogEyes rogMouth
						say:
							3
							0
							2
							64
							30
							15
							67
							175
							25
							global137
							26
							global129
							27
							0
							30
							68
					)
				)
				(rHand setCel: 1)
				(if (not (gCurRoom script:))
					(gCurRoom setScript: spScript)
				)
				(= seconds 2)
			)
			(4
				(rHand setCel: 0)
				(= seconds 1)
			)
			(5
				(= local7 2)
				(= seconds 2)
			)
			(6
				(rAnt setCel: 2)
				(lAnt setCel: 1)
				(= seconds 1)
			)
			(7
				(= local7 2)
				(rAnt setCel: 0)
				(lAnt setCel: 0)
				(rHand setCel: 1)
				(= seconds 1)
			)
			(8
				(= seconds 2)
			)
			(9
				(= local7 2)
				(= seconds 1)
			)
			(10
				(if (not (gCurRoom script:))
					(gCurRoom setScript: spScript)
				)
				(= state 3)
				(= cycles 1)
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
				(= cycles 10)
			)
			(4
				(doorSp setHeading: 180)
				(= cycles 10)
			)
			(5
				(gunSp setHeading: 90 self)
			)
			(6
				(gunSp moveSpeed: 4 setMotion: MoveTo 330 87 self)
			)
			(7
				(= seconds 3)
			)
			(8
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
				(tROGER dispose: (tROGER disposeWhenDone:))
				(= cycles 1)
			)
			(10
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
				(spHead init:)
				(gLongSong setVol: 80)
				(tSVGRUNT ; "Are you Roger Wilco?"
					init: 0 0 spHead
					say:
						1
						self
						2
						64
						95
						15
						67
						120
						25
						global136
						26
						global129
						27
						0
						30
						68
				)
			)
			(11
				(= seconds 2)
			)
			(12
				(tROGER ; "Uh, yeah."
					init: 0 0 rogMouth
					finalMouth: -1
					say:
						1
						self
						2
						64
						45
						15
						67
						160
						25
						global137
						26
						global129
						27
						0
						30
						68
				)
			)
			(13
				(tSVGRUNT ; "Please come with me."
					init: 0 0 spHead
					say:
						2
						self
						2
						64
						90
						15
						67
						125
						25
						global136
						26
						global129
						27
						-1
						30
						68
				)
			)
			(14
				(= seconds 3)
			)
			(15
				(Animate (gCast elements:) 0)
				(gLongSong fade: 80 15 10 0)
				(gLongSong2 fade:)
				(gCurRoom newRoom: 15)
			)
		)
	)
)

(instance alien1 of Sq4Prop
	(properties
		x 69
		y 74
		view 19
		priority 11
		signal 16
	)
)

(instance alien2 of Sq4Prop
	(properties
		x 187
		y 86
		view 19
		loop 1
		priority 11
		signal 16
	)
)

(instance alien3 of Sq4Prop
	(properties
		x 249
		y 82
		view 19
		loop 2
		priority 11
		signal 16
	)
)

(instance lAnt of Sq4Prop
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

(instance rAnt of Sq4Prop
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

(instance rogHead of Sq4Prop
	(properties
		x 132
		y 85
		view 16
		cel 1
		priority 13
		signal 16400
	)
)

(instance rogEyes of Sq4Prop
	(properties
		x 134
		y 58
		view 16
		loop 8
		priority 14
		signal 16400
	)
)

(instance rogMouth of Sq4Prop
	(properties
		x 132
		y 82
		view 16
		loop 1
		priority 14
		signal 16400
	)
)

(instance rHand of Sq4Prop
	(properties
		x 135
		y 154
		view 16
		loop 2
		priority 14
		signal 16
	)
)

(instance gunSp of Sq4Actor
	(properties
		x 146
		y 50
		view 7
		cel 5
		signal 16400
	)
)

(instance doorSp of Sq4Actor
	(properties
		x 121
		y 51
		view 7
		cel 5
		signal 16400
	)
)

(instance spHead of Sq4Prop
	(properties
		x 234
		y 40
		view 16
		loop 7
		priority 15
		signal 16
	)
)

(instance tSVGRUNT of FaceTalker
	(properties
		noun 5
		talkerNum 5
	)
)

(instance tROGER of FaceTalker
	(properties
		noun 7
		talkerNum 7
	)
)

