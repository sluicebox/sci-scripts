;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm530 0
)

(local
	local0
	local1
	[local2 48] = [131 40 143 42 157 41 168 36 175 30 180 23 184 16 255 15 260 24 262 50 248 63 240 64 224 79 219 79 203 80 187 80 187 79 172 79 171 80 146 80 146 78 123 78 129 52 124 37]
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(aSound number: 105 loop: 1 vol: 127 play:)
	(if (< param1 param3)
		(= temp0 (- param1 1))
		(= temp1 (+ param3 1))
	else
		(= temp0 (- param3 1))
		(= temp1 (+ param1 1))
	)
	(= temp2 (Graph grSAVE_BOX temp0 (- param2 1) temp1 (+ param4 1) 1))
	(Graph grDRAW_LINE param1 param2 param3 param4 global143 -1 -1)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1))
	(Wait 1)
	(Wait 4)
	(Graph grRESTORE_BOX temp2)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1))
)

(instance rm530 of SQRoom
	(properties
		picture 530
		east 535
		vanishingX 319
		vanishingY -60
	)

	(method (init)
		(if (== gPrevRoomNum 815) ; rmProtect
			(= gPrevRoomNum 531)
		)
		(HandsOff)
		(LoadMany rsVIEW 0 378 530 300 26)
		(LoadMany rsSOUND 124 125 131 838)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 257 172 270 152 319 152 319 172
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 31 170 0 170 0 0 319 0 319 52 267 52 254 65 246 67 230 83 133 83 117 81 71 114 77 117 111 112 144 119 158 126 181 114 205 115 228 134 216 140 180 144 143 151 128 150 119 138 85 149 69 150 60 145
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 167 165 167 189 127 189 127 166
					yourself:
				)
		)
		(timePod0 init:)
		(terminal init:)
		(switch gPrevRoomNum
			(531
				(self
					setScript:
						(if (IsFlag 2)
							egoArrives
						else
							(if (not (IsFlag 26))
								(LoadMany rsVIEW 7 13)
								(Load rsSOUND 105)
								(sp1 loop: 2 init:)
								(sp2 view: 7 loop: 2 x: 185 y: 91 init:)
							)
							(gEgo
								view: 378
								loop: 0
								cel: 0
								posn: 188 149
								setPri: 11
								ignoreActors:
								illegalBits: 0
								cycleSpeed: 1
								normal: 0
								moveHead: 0
								init:
							)
							egoExits
						)
				)
			)
			(else
				(LoadMany rsVIEW 7 13)
				(Load rsSOUND 105)
				(self style: 11)
				(if (IsFlag 1)
					(HandsOff)
					(hatch init: cel: (and (IsFlag 26) 0))
					(pod init:)
					(if (not (IsFlag 26))
						(sp1 loop: 0 init:)
						(sp2 view: 7 loop: 0 x: 185 y: 91 init:)
					)
					(gEgo
						x: 282
						y:
							(cond
								((not (IsFlag 26)) 130)
								((> (gEgo y:) 152) 152)
								(else
									(gEgo y:)
								)
							)
						init:
					)
					(AnimateEgoHead)
					(self setScript: enterScript)
				else
					(sp1 init:)
					(gEgo x: 284 y: 130 init:)
					(sp1 setScript: policeArrive)
				)
			)
		)
		(SetFlag 1)
		(gFeatures
			add: theRedBall theRailView1 theRailView2 building
			eachElementDo: #init
			doit:
		)
		(super init:)
		(self setRegions: 709) ; rgLanding
		(buildingPoly points: @local2 size: 24)
	)

	(method (doit)
		(super doit: &rest)
		(if (> (gEgo x:) 300)
			(HandsOff)
			(gCurRoom newRoom: 535)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(= cycles 1)
			)
			(1
				(gEgo
					setCycle: StopWalk 4
					setMotion:
						MoveTo
						(if (< (gEgo y:) 85) 273 else 255)
						(gEgo y:)
						self
				)
			)
			(2
				(if (IsFlag 26)
					(HandsOn)
					(client setScript: 0)
				else
					(policeArrive start: 18)
					(client setScript: policeArrive)
				)
			)
		)
	)
)

(instance egoArrives of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 8)
			)
			(1
				(sparks init: setCycle: Fwd)
				(= cycles 10)
			)
			(2
				(pod cel: 0 init: setCycle: CT 6 1 self)
			)
			(3
				(= cycles 12)
			)
			(4
				(sparks dispose:)
				(= cycles 1)
			)
			(5
				(gLongSong2 fade: 80 15 10 0)
				(gCurRoom newRoom: 531)
			)
		)
	)
)

(instance policeArrive of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= register 200)
	)

	(method (doit)
		(super doit: &rest)
		(if (> 18 state 13)
			(-- register)
		)
		(if (or (== register 0) (and (< (gEgo y:) 128) (< state 18)))
			(= register -1)
			(= state 17)
			(= cycles (= seconds 0))
			(if (not local1)
				(self cue:)
			else
				(self dispose:)
			)
		)
		(if (== (gCurRoom script:) (ScriptID 709 1)) ; fallScript
			(self dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 8)
			)
			(1
				(sp1 setHeading: 90)
				(sparks init: setCycle: Fwd)
				(= cycles 10)
			)
			(2
				(pod cel: 0 init: setCycle: CT 6 1 self)
			)
			(3
				(sp1 setHeading: 180)
				(hatch init: cel: 0 setPri: (+ (hatch priority:) 2))
				(pod setCycle: End)
				(= cycles 12)
			)
			(4
				(sp1 stopUpd:)
				(sparks dispose:)
				(pod stopUpd:)
				(= cycles 1)
			)
			(5
				(gLongSong number: 124 loop: 1 vol: 127 play: self)
			)
			(6
				(hatch setCycle: End self)
				(sp2 view: 378 loop: 2 cel: 0 x: 198 y: 148 init:)
			)
			(7
				(hatch stopUpd:)
				(sp2 cycleSpeed: 1 setCycle: End self)
			)
			(8
				(= cycles 2)
			)
			(9
				(sp2
					view: 7
					loop: 0
					x: (+ (sp2 x:) 13)
					y: (+ (sp2 y:) 5)
					cycleSpeed: 0
					setCycle: Walk
					setMotion: PolyPath 185 91 self
				)
			)
			(10
				(HandsOn)
				(gEgo setMotion: MoveTo 262 130)
				(sp1 setHeading: 90 self)
			)
			(11
				(sp1 stopUpd:)
				(sp2 setHeading: 270 self)
			)
			(12
				(sp2 stopUpd:)
				(= local0
					(proc0_12
						{"I have just completed a scan of the Labion sector of Space Quest II."}
						67
						178
						5
						28
						global136
						29
						global129
						70
						140
					)
				)
				(= seconds 4)
			)
			(13
				(proc0_12 local0)
				(= local0
					(proc0_12
						{"No sign of presence at this time."}
						67
						178
						15
						28
						global136
						29
						global129
						70
						140
					)
				)
				(= seconds 4)
			)
			(14
				(HandsOn)
				(proc0_12 local0)
				(= local0
					(proc0_12
						{"Ghraa... slooh... uuhrp."}
						67
						25
						25
						28
						global132
						29
						global129
					)
				)
				(= seconds 3)
			)
			(15
				(proc0_12 local0)
				(= local0
					(proc0_12
						{"Mrghl... pifhh... zaaft."}
						67
						178
						25
						28
						global136
						29
						global129
						70
						140
					)
				)
				(= seconds 3)
			)
			(16
				(proc0_12 local0)
				(= local0
					(proc0_12
						{"Jobhr... fhelz... klogd."}
						67
						25
						25
						28
						global132
						29
						global129
					)
				)
				(= seconds 3)
			)
			(17
				(proc0_12 local0)
			)
			(18
				(HandsOff)
				(Face sp1 gEgo)
				(= cycles 3)
			)
			(19
				(Face sp2 gEgo)
				(proc0_12 local0)
				(sp1 view: 13 cel: 0 setCycle: End self)
			)
			(20
				(if (< (sp1 x:) (gEgo x:))
					(localproc_0
						(- (sp1 y:) 27)
						(sp1 x:)
						(- (gEgo y:) 32)
						(gEgo x:)
					)
				else
					(localproc_0
						(- (gEgo y:) 32)
						(gEgo x:)
						(- (sp1 y:) 27)
						(sp1 x:)
					)
				)
				(gEgo
					view: 26
					loop:
						(switch (gEgo loop:)
							(4 0)
							(5 1)
							(6 0)
							(7 1)
							(else
								(gEgo loop:)
							)
						)
					cel: 0
					cycleSpeed: 0
					setCycle: CT 2 1 self
				)
			)
			(21
				(gEgo setCycle: CT 1 -1 self)
			)
			(22
				(gEgo setCycle: End self)
			)
			(23
				(= seconds 2)
			)
			(24
				(= local0
					(proc0_12 {"HALT."} 67 85 25 28 global132 29 global129)
				)
				(= seconds 3)
			)
			(25
				(proc0_12 local0)
				(= local0
					(proc0_12
						{"Some people just won't follow instructions."}
						67
						25
						25
						28
						global132
						29
						global129
						70
						210
					)
				)
				(= seconds 4)
			)
			(26
				(proc0_12 local0)
				(EgoDead 8)
			)
		)
	)
)

(instance egoExits of Script
	(properties)

	(method (init)
		(super init: &rest)
		(if (and (gCast contains: sp1) (== (sp1 script:) policeArrive))
			(sp1 setScript: 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong2 number: 535 loop: -1 vol: 127 changeState:)
				(pod setCel: 7 init: stopUpd:)
				(hatch
					init:
					cel: 0
					setPri: (+ (hatch priority:) 2)
					setCycle: End self
				)
			)
			(1
				(= cycles 4)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(gEgo loop: 1 normal: 1 moveHead: 1 view: 0)
				(NormalEgo)
				(= cycles 1)
			)
			(4
				(if (IsFlag 26)
					(hatch setPri: 10 setCycle: Beg self)
				else
					(policeArrive start: 18)
					(client setScript: policeArrive)
				)
			)
			(5
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance egoEntersPod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local1 1)
				(gEgo setMotion: PolyPath 188 150 self)
			)
			(1
				(if (not (hatch cel:))
					(hatch setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(= gUseObstacles 0)
				(gEgo
					view: 378
					loop: 1
					cel: 0
					setPri: 11
					posn: 191 126
					ignoreActors:
					illegalBits: 0
					cycleSpeed: 2
					normal: 0
					moveHead: 0
					setCycle: End self
				)
			)
			(3
				(= cycles 4)
			)
			(4
				(hatch cel: 5 setPri: 12 setCycle: Beg self)
			)
			(5
				(gLongSong number: 125 loop: 0 play: self)
				(SetScore 56 10)
				(= gUseObstacles 1)
			)
			(6
				(gLongSong2 fade: 80 15 10 0)
				(if (IsFlag 78)
					(gCurRoom newRoom: 531)
				else
					(gCurRoom newRoom: 815) ; rmProtect
				)
			)
		)
	)
)

(instance pod of Prop
	(properties
		x 127
		y 129
		description {time pod}
		view 530
		loop 1
		cel 7
		priority 10
		signal 16400
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (not (hatch cel:))
					(Print 530 0) ; "You give the Time Pod a long glance. It's not the most attractive vehicle you've ever seen. It resembles an overgrown titanium tennis shoe. A gold-tinted glass shield seals the top."
				else
					(Print 530 1) ; "You give the Time Pod a long glance. It's not the most attractive vehicle you've ever seen. It resembles an overgrown titanium tennis shoe."
				)
			)
			(3 ; Do
				(gCurRoom setScript: egoEntersPod)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hatch of Prop
	(properties
		x 162
		y 131
		z 18
		description {gold tinted sheild}
		view 530
		loop 2
		cel 9
		priority 10
		signal 16400
	)

	(method (setCycle)
		(super setCycle: &rest)
		(hatchSound init: play:)
	)

	(method (motionCue)
		(hatchSound stop: loop: 0)
		(super motionCue: &rest)
	)

	(method (doVerb theVerb)
		(pod doVerb: theVerb)
	)
)

(instance hatchSound of Sound
	(properties
		number 142
	)
)

(instance sparks of Prop
	(properties
		x 145
		y 108
		view 530
		priority 13
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(aSound number: 838 loop: 1 play:)
	)

	(method (dispose)
		(aSound stop:)
		(super dispose:)
	)
)

(instance sp1 of Actor
	(properties
		x 156
		y 91
		description {sequel police}
		lookStr {You look briefly, careful not to attract any attention. As you can see, they are clad in dark uniforms, wearing helmets and carrying guns.}
		view 7
		loop 3
		signal 16384
	)
)

(instance sp2 of Actor
	(properties
		description {sequel police}
		lookStr {You look briefly, careful not to attract any attention. As you can see, they are clad in dark uniforms, wearing helmets and carrying guns.}
		signal 16384
	)
)

(instance terminal of Feature
	(properties
		x 159
		y 61
		heading 180
		nsTop 43
		nsLeft 148
		nsBottom 80
		nsRight 170
		description {terminal}
		sightAngle 150
		lookStr {This is the Sequel Police dispatch monitor. At the moment nothing is being displayed.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: doTerminal)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doTerminal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath (terminal x:) (terminal y:) self)
			)
			(1
				(Print 530 2) ; "You are unable to do anything with that now."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance theRedBall of Feature
	(properties
		x 147
		y 141
		z 120
		nsBottom 200
		nsRight 320
		description {red sphere}
		onMeCheck 16
		lookStr {Much like myself, you must be curious as to the identity of, and the purpose for, the large red sphere.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRailView1 of Feature
	(properties
		x 59
		y 68
		nsBottom 200
		nsRight 320
		description {rail view}
		onMeCheck 32
		lookStr {The view beyond the railing reveals the mess of pipes and beams which this structure is composed of.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRailView2 of Feature
	(properties
		x 270
		y 33
		nsBottom 200
		nsRight 320
		description {rail view}
		sightAngle 180
		onMeCheck 64
		lookStr {The view beyond the railing reveals the mess of pipes and beams which this structure is composed of.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance timePod0 of Feature
	(properties
		description {Time Pod}
		lookStr {You give the Time Pod a long glance. It's not the most attractive vehicle you've ever seen. It resembles an overgrown titanium tennis shoe. A gold-tinted glass shield seals the top.}
	)

	(method (onMe param1)
		(return (& (OnControl CONTROL (param1 x:) (param1 y:)) $0002))
	)
)

(instance building of Feature
	(properties
		description {dispatch building}
		sightAngle 45
		lookStr {It looks to be a sealed, reinforced structure which houses dispatch communications and monitoring equipment.}
	)

	(method (init)
		(super init: &rest)
		(self onMeCheck: buildingPoly)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 530 3) ; "It feels remarkably similiar to a walled structure."
			)
			(11 ; Smell
				(Print 530 4) ; "It has no noticeable aroma."
			)
			(10 ; Taste
				(Print 530 5) ; "It tastes like nothing you'd ever want to put your tongue on again."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance buildingPoly of Polygon
	(properties)
)

(instance aSound of Sound
	(properties)
)

