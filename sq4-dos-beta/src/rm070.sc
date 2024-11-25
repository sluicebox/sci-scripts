;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use RandCycle)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm070 0
)

(local
	local0
	local1
	[local2 26] = [5 0 45 143 5 0 53 138 5 0 61 133 5 0 69 128 5 0 77 123 5 0 85 118 -32768 0]
)

(procedure (localproc_0 param1 param2)
	(= local0 (Display param1 dsWIDTH 300 dsCOORD 6 1 dsALIGN alLEFT dsFONT 69 dsCOLOR global129 dsSAVEPIXELS))
	(Display param1 dsWIDTH 300 dsCOORD 6 1 dsALIGN alLEFT dsFONT 68 dsCOLOR global130)
	(= local1 (Display param2 dsWIDTH 300 dsCOORD 6 85 dsALIGN alLEFT dsFONT 69 dsCOLOR global129 dsSAVEPIXELS))
	(Display param2 dsWIDTH 300 dsCOORD 6 85 dsALIGN alLEFT dsFONT 68 dsCOLOR global130)
)

(procedure (localproc_1)
	(Display 70 4 dsRESTOREPIXELS local0)
	(Display 70 4 dsRESTOREPIXELS local1)
)

(instance rm070 of SQRoom
	(properties
		picture 70
	)

	(method (init)
		(Load rsVIEW 70)
		(super init:)
		(aSound init:)
		(if (== ((gInventory at: 5) owner:) 70) ; jar
			(theJar init:)
		)
		(blotter init:)
		(door init: stopUpd:)
		(grid init:)
		(theShadow init:)
		(theDesk init:)
		(theWires init:)
		(thePipes init:)
		(theRoom init:)
		(gEgo
			init:
			normal: 0
			view: 70
			loop: 0
			cel: 0
			illegalBits: 0
			x: 223
			y: -2
			xStep: 3
			yStep: 15
		)
		(HandsOff)
		(self setScript: fallScript)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 161 132 266 134 265 160 137 160
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 275 82 319 10 319 183 296 162
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 9 189 29 174 298 174 316 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 162 43 162 49 171 0 171
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 165 72 144 0 319 0 274 75
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 138 0 161 73 47 151 45 160 0 160 0 0
					yourself:
				)
		)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gLongSong number: 815 vol: 127 loop: -1 playBed:)
				(gEgo setLoop: 0 setCycle: 0 setMotion: MoveTo 223 89 self)
			)
			(2
				(aSound init: number: 115 loop: 1 play:)
				(gEgo cycleSpeed: 1 setCycle: End self)
			)
			(3
				(NormalEgo 0 0)
				(gEgo posn: 228 95 setHeading: 180)
				(= seconds 2)
			)
			(4
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance doorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: PolyPath 50 150 self)
			)
			(1
				(gEgo setPri: 13 setHeading: 270 self)
			)
			(2
				(aSound number: 816 play:)
				(gEgo
					view: 70
					normal: 0
					setLoop: 4
					cel: 0
					illegalBits: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(aSound play:)
				(gEgo cel: 0 setCycle: End self)
			)
			(4
				(aSound play:)
				(gEgo cel: 0 setCycle: End self)
			)
			(5
				(gEgo view: 0 setLoop: 1)
				(= cycles 1)
			)
			(6
				(aSound number: 810 loop: 1 play:)
				(door setCycle: MCyc @local2 self)
			)
			(7
				(aSound number: 811 play:)
				(= seconds 1)
			)
			(8
				(HandsOn)
				(gCurRoom newRoom: 85)
			)
		)
	)
)

(instance buttonScript of Script
	(properties)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if
			(and
				(OneOf state 10 12 14 16 18 20 22)
				(not (User canInput:))
				(not (User controls:))
			)
			(= temp1 ((= temp0 (Event new:)) type:))
			(if (OneOf temp1 1 4)
				(= seconds 0)
				(= cycles 1)
			)
			(temp0 dispose:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 195 159 self)
			)
			(1
				(gEgo
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 2) self
				)
			)
			(2
				(gEgo view: 70 normal: 0 setLoop: 7 setCycle: Beg self)
			)
			(3
				(Print 70 0) ; "Ah! A button. Perhaps I'll give it a press."
				(gEgo view: 70 setLoop: 7 setCycle: End self)
			)
			(4
				(aSound number: 812 loop: 1 play:)
				(= seconds 2)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(= seconds 1)
			)
			(7
				(gEgo
					view: 0
					normal: 1
					y: (+ (gEgo y:) 2)
					setPri: -1
					setLoop: -1
					setStep: 3 2
					cycleSpeed: 0
					setCycle: Walk
					illegalBits: $8000
					setHeading: 0 self
				)
			)
			(8
				(aSound init: number: 813 loop: 1 play:)
				(if (== ((gInventory at: 5) owner:) gCurRoomNum) ; jar
					(theJar stopUpd:)
				)
				(gEgo stopUpd:)
				(hologram init: cycleSpeed: 1 setCycle: End)
				(= seconds 3)
			)
			(9
				(hologramHead init: cycleSpeed: 1 setCycle: RandCycle)
				(hologram setLoop: 2 posn: 170 83 setCycle: RandCycle)
				(= cycles 1)
			)
			(10
				(gLongSong number: 814 loop: -1 play:)
				(localproc_0
					{"Data Entry 22795: This message is to whomever may be so fortunate as to find it. I am Professor Lloyd, lead designer of the Xenon Super Computer Project, the ultimate in artificial intelligence.}
					{The computer was designed to enhance our lives but, instead, ended up being the ruin of us all."}
				)
				(= seconds 30)
			)
			(11
				(localproc_1)
				(= cycles 1)
			)
			(12
				(localproc_0
					{"We made the mistake of tying it into the most important facets of our existence here on Xenon including our weather control and defense systems.}
					{It seemed like a sound idea at the time and all proceeded well for about three years."}
				)
				(= seconds 30)
			)
			(13
				(localproc_1)
				(= cycles 1)
			)
			(14
				(localproc_0
					{"It was around then that a deep space salvage operation recovered what appeared to be some sort of antiquated data storage unit contained in a flimsy cardboard box on which the words "Leisure Suit Larry" were imprinted.}
					{On its back was the picture of a not particularly wholesome gentleman, but that's another story."}
				)
				(= seconds 30)
			)
			(15
				(localproc_1)
				(= cycles 1)
			)
			(16
				(localproc_0
					{"My counterparts exhibited shameful behavior as they tore open the box to get at its contents. I could not understand the commotion it generated. The data was uploaded into the Super Computer for analysis.}
					{As a result, a crippling virus spread through the machine like a bad social disease. All control of the computer was lost."}
				)
				(= seconds 30)
			)
			(17
				(localproc_1)
				(= cycles 1)
			)
			(18
				(localproc_0
					{"All screens went blank, then these words were displayed by the monitors and uttered by the vocal outputs -\n"WILCO MUST PAY!"}
					{From that day forth the possessed computer waged war on the inhabitants of Xenon using our own weapons against us. Some managed to escape to other planets."}
				)
				(= seconds 30)
			)
			(19
				(localproc_1)
				(= cycles 1)
			)
			(20
				(localproc_0
					{"Those of us who remained stayed to fight the machines and robots under its control. It was a bloody war. Those of us that were not killed were taken captive and 'modified.'}
					{These 'cyborgs' infiltrated the loyal ranks of resistance rooting out almost all of our hiding places, exposing us to the mechanical menace. Some of these poor souls still wander the streets."}
				)
				(= seconds 30)
			)
			(21
				(localproc_1)
				(= cycles 1)
			)
			(22
				(localproc_0
					{"As of this recording, we are down to only a handful of rebels. My health is deteriorating rapidly. To make matters worse, I've just learned that the computer has unraveled the mysteries of time travel.}
					{I've sent my two best men to attempt to steal this new technology. If you are not a machine then perhaps they were successful. Please realize - YOU are Xenon's last hope."}
				)
				(= seconds 30)
			)
			(23
				(localproc_1)
				(= cycles 1)
			)
			(24
				(gLongSong fade:)
				(hologram setCycle: 0)
				(hologramHead setCycle: 0)
				(= seconds 2)
			)
			(25
				(aSound play:)
				(hologramHead dispose:)
				(hologram setLoop: 1 setCel: 4 posn: 160 81 setCycle: Beg self)
			)
			(26
				(gLongSong number: 815 vol: 127 play:)
				(hologram dispose:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance jarScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 197 165 self)
			)
			(1
				(Face gEgo theJar)
				(self cue:)
			)
			(2
				(gEgo get: 5) ; jar
				(theJar dispose:)
				(self cue:)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance door of Actor
	(properties
		x 45
		y 143
		description {sealed door}
		sightAngle 45
		lookStr {There's a hatch set into a cylindrical structure here. You recognize it as the entrance to the sewer system. Your mind reels and your stomach churns as you consider what must lie behind it.}
		view 70
		loop 5
		priority 9
		signal 18448
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(gCurRoom setScript: doorScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theJar of View
	(properties
		x 197
		y 150
		z 22
		description {jar}
		sightAngle 45
		lookStr {An empty jar with lid does nothing entertaining.}
		view 70
		loop 6
		priority 12
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== ((gInventory at: 5) owner:) 70) ; jar
					(gCurRoom setScript: jarScript)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hologram of Prop
	(properties
		x 160
		y 81
		description {hologram}
		view 70
		loop 1
		signal 16384
	)
)

(instance hologramHead of Prop
	(properties
		x 167
		y 45
		description {hologram}
		view 70
		loop 3
		signal 16384
	)
)

(instance theRoom of Feature
	(properties
		x 152
		y 82
		nsBottom 189
		nsRight 319
		description {substation}
		sightAngle 180
		lookStr {You've reached the Sewer Maintenance Office. There's a thick layer of dust on everything, leading you to believe that there's very little maintenance going on. Apparently this office has been long abandoned. Your keen janitorial instincts urge you to sweep up and do a little dusting. Somehow you manage to suppress those urges and concentrate on the task at hand.}
	)
)

(instance blotter of Feature
	(properties
		x 230
		y 155
		z 31
		nsTop 115
		nsLeft 211
		nsBottom 133
		nsRight 249
		description {blotter}
		sightAngle 45
		lookStr {It's just an average old-fashioned desk blotter.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(gCurRoom setScript: buttonScript)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance grid of Feature
	(properties
		x 166
		y 83
		nsTop 76
		nsLeft 145
		nsBottom 91
		nsRight 188
		description {grid}
		sightAngle 45
		onMeCheck 64
		lookStr {The strange little pedestal has wires running between it and the wall.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 70 1) ; "Nothing you can do to it here will be of benefit."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theDesk of Feature
	(properties
		x 212
		y 123
		z 30
		nsBottom 200
		nsRight 320
		description {desk}
		sightAngle 45
		onMeCheck 128
		lookStr {The desk is not exactly of executive status caliber.}
	)
)

(instance theWires of Feature
	(properties
		x 155
		y 75
		nsBottom 200
		nsRight 320
		description {wires}
		sightAngle 45
		onMeCheck 32
		lookStr {This heavy gauge wire disappears into the wall.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 70 2) ; "They won't come loose."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theShadow of Feature
	(properties
		x 227
		y 10
		nsLeft 198
		nsBottom 30
		nsRight 246
		description {grate shadow}
		sightAngle 45
		lookStr {You notice the shadow cast on the wall by the inaccessible grate above.}
	)
)

(instance thePipes of Feature
	(properties
		x 188
		y 70
		z 20
		nsBottom 200
		nsRight 320
		description {wires}
		onMeCheck 16
		lookStr {A variety of pipes, coolant and otherwise, pass in, through and around the room.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 70 3) ; "They're well affixed."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance aSound of Sound
	(properties)
)

