;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 70)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
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
	[local2 26] = [5 0 45 127 5 0 53 122 5 0 61 117 5 0 69 112 5 0 77 107 5 0 85 102 -32768 0]
	local28
)

(procedure (localproc_0 param1 param2)
	(= local0 (Display param1 dsWIDTH 300 dsCOORD 6 1 dsALIGN alLEFT dsFONT 69 dsCOLOR global129 dsSAVEPIXELS))
	(Display param1 dsWIDTH 300 dsCOORD 6 1 dsALIGN alLEFT dsFONT 68 dsCOLOR global130)
	(= local1 (Display param2 dsWIDTH 300 dsCOORD 6 85 dsALIGN alLEFT dsFONT 69 dsCOLOR global129 dsSAVEPIXELS))
	(Display param2 dsWIDTH 300 dsCOORD 6 85 dsALIGN alLEFT dsFONT 68 dsCOLOR global130)
)

(procedure (localproc_1)
	(if local0
		(Display 70 14 dsRESTOREPIXELS local0)
		(Display 70 14 dsRESTOREPIXELS local1)
		(= local0 0)
	)
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
			illegalBits: -32766
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
					init: 166 126 265 126 265 160 137 160
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
					init: 166 73 144 0 319 0 272 77
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 138 0 162 74 87 127 71 127 46 144 56 144 47 151 45 160 0 160 0 0
					yourself:
				)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and local28 (StepOn gEgo 2))
				(gCurRoom setScript: enterSewer)
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
				(gEgo illegalBits: -32766 setHeading: 180)
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
				(door
					description:
						{open door}
					setCycle: MCyc @local2 self
				)
			)
			(7
				(door setPri: 3 stopUpd:)
				(= local28 1)
				(aSound number: 811 play:)
				(= seconds 1)
			)
			(8
				(HandsOn)
				(NormalEgo 1)
				(gEgo illegalBits: -32768)
				(gFeatures addToFront: doorOpening eachElementDo: #init doit:)
				(self dispose:)
			)
		)
	)
)

(instance buttonScript of Script
	(properties)

	(method (init)
		(if (not (gKeyDownHandler contains: self))
			(gKeyDownHandler addToFront: self)
		)
		(if (not (gMouseDownHandler contains: self))
			(gMouseDownHandler addToFront: self)
		)
		(if (not (gDirectionHandler contains: self))
			(gDirectionHandler addToFront: self)
		)
		(super init: &rest)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if local0
			(event claimed: 1)
			(localproc_1)
			(= seconds 0)
			(= cycles 1)
		else
			(super handleEvent: event)
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
				(if (not (IsFlag 34))
					(Print 70 0) ; "Ah! A button. Perhaps I'll give it a press."
				)
				(SetScore 54 10)
				(gEgo view: 70 setLoop: 7 setCycle: End self)
				(if (not local28)
					(gEgo illegalBits: -32766)
				else
					(gEgo illegalBits: -32768)
				)
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
				(NormalEgo 3 0)
				(gEgo y: (+ (gEgo y:) 2) setHeading: 0 self)
				(if (not local28)
					(gEgo illegalBits: -32766)
				else
					(gEgo illegalBits: -32768)
				)
			)
			(8
				(if (not (IsFlag 34))
					(SetFlag 34)
					(aSound init: number: 813 loop: 1 play:)
					(if (== ((gInventory at: 5) owner:) gCurRoomNum) ; jar
						(theJar stopUpd:)
					)
					(gEgo stopUpd:)
					(hologram init: cycleSpeed: 1 setCycle: End)
					(= seconds 3)
				else
					(Print 70 1) ; "Nothing happens."
					(HandsOn)
					(self dispose:)
				)
			)
			(9
				(hologramHead init: cycleSpeed: 1 setCycle: RandCycle)
				(hologram setLoop: 2 posn: 170 83 setCycle: RandCycle)
				(= cycles 1)
			)
			(10
				(gLongSong number: 814 loop: -1 play:)
				(localproc_0
					{"Data Entry 22795: This message is to whomever may be so fortunate as to find it. I am Professor Lloyd, lead designer of the Xenon Super Computer Project, the ultimate in artificial\nintelligence."#j\a2Data Entry 22795:\a0 \9a\e9\d2\af\be\b0\bc\de\ea\a4\a0 \9a\fa\86\f0\e2\99\e0 \eb\e4\e9\e0\f2\e9\f3\e9\e3\de\9d\a1\a0 \fc\e0\9c\ea\a4\a0 \db\b2\c4\de\97\8e\93\9c\de\8d\e3\de\9d\a1\a0 \9c\de\fd\9a\93\e1\e9\93\e9\a0 \9a\de\98\e1\e3\de\91\f9\a4\a0 \n\bd\b0\ca\df\b0\a5\n\ba\dd\cb\df\ad\b0\c0\b0\a5\cc\df\db\bc\de\aa\b8\c4\e9\a0\n\97\96\98\9e\97\e6\fd\9c\8c\e3\de\9d\a1\a3}
					{"The computer was designed to enhance our lives but, instead, ended up being the ruin of us all."#j\a2\9a\e9\ba\dd\cb\df\ad\b0\c0\b0\ea\a4\a0 \fc\fa\fc\fa\e9\a0\9e\92\96\e2\86\a0\9a\93\9c\de\8e\93\9b\9e\f9\e0\f2\e6\a0 \e2\98\f7\fa\e0\f3\e9\e3\de\9d\96\de\a4\a0 \9f\fa\e4\ea\a0 \97\de\8c\98\e6\a0\ea\96\92\86\a0 \f3\e0\f7\9c\e3\9c\ef\8f\e0\e9\e3\de\9d\a1\a3}
				)
				(= seconds 30)
			)
			(11
				(localproc_1)
				(= cycles 1)
			)
			(12
				(localproc_0
					{"We made the mistake of tying it into the most important facets of our existence here on Xenon including our weather control and defense systems."#j\a2\9f\f3\9f\f3\e9\a0\91\f4\ef\f8\ea\a4\a0 \9a\e9\ba\dd\cb\df\ad\b0\c0\b0\e6\a0\n\be\de\c9\dd\9e\92\e9\a0\97\9a\93\ba\dd\c4\db\b0\d9\f4\a0\ee\de\93\97\de\8e\ba\dd\c4\db\b0\d9\e5\e4\de\86\a0\n\f1\9d\eb\de\e2\99\e3\9c\ef\93\a0 \n\e4\92\93\9a\e4\96\f7\ea\9c\de\ef\f8\ef\9c\e0\a1\a3}
					{"It seemed like a sound idea at the time and all proceeded well for about three years."#j\a2\e4\93\9c\de\ea\a0\96\8f\97\e3\97\e5\e3\92\91\fd\e3\de\a4\a0 3\e8\fd\96\fd\ea\a0\9d\ed\de\e3 \9c\de\8d\fd\e1\8e\93\e6\a0 \f3\e9\9a\de\e4\96\de\a0 \ea\9a\eb\de\ef\9c\e0\a1\a3}
				)
				(= seconds 30)
			)
			(13
				(localproc_1)
				(= cycles 1)
			)
			(14
				(localproc_0
					{"It was around then that a deep space salvage operation recovered what appeared to be some sort of antiquated data storage unit contained in a flimsy cardboard box on which\nthe words "Leisure Suit\nLarry" were imprinted.#j\a2\e1\8e\93\e4\de\a0 \9f\e9\9a\fb\e6\a4\a0 \93\e1\8d\93\ea\8f\98\e2\e0\de\fd\96\de\a4\a0 "\da\bc\de\ac\b0\a5\bd\b0\c4\a5\d7\d8\b0"\e4\a0\92\fd\9b\e2\9b\fa\e0\a0\93\9d\92\c0\de\dd\ce\de\b0\d9\ea\9a\e6\a0\ea\92\8f\e0\a0 \ec\f9\92\c3\de\b0\c0\ee\96\fd\d5\c6\af\c4\86\a0\ea\8f\98\e2\9c\e0\e9\e3\de\9d\a1\a3}
					{"On its back was the picture of a not particularly wholesome gentleman, but that's another story."#j\a2\9f\e9\ea\9a\e9\a0\93\f7\96\de\fc\e6\ea\a4\a0 \e4\98\e6\a0\f8\8f\ea\df\e4\f3\92\94\e5\92\a0 \9c\fd\9c\e9\9c\8c\9c\fd\96\de\a0 \e9\8f\e3\ef\9c\e0\f6\a1\a0 \9c\96\9c\a4\9f\fa\ea\91\ef\f8\a0 \9c\de\8d\93\f6\93\e3\de\ea\a0\91\f8\ef\9e\fd\a1\a3}
				)
				(= seconds 30)
			)
			(15
				(localproc_1)
				(= cycles 1)
			)
			(16
				(localproc_0
					{"My counterparts exhibited shameful behavior as they tore open the box to get at its contents. I could not understand the commotion it generated. The data was uploaded into the Super\nComputer for analysis."#j\a2\fc\e0\9c\e9\a0 \e4\de\93\f8\8e\93\e0\e1\ea\a4\a0 \ea\9a\e9\a0\91\99\96\e0\96\de\fc\96\f7\9d\de\a4\a0 \ea\9a\86\f4\ec\de\8f\e3\a0 \e4\f8\e0\de\9c\ef\9c\e0\a1\a0 \ef\8f\e0\98\a4\a0 \99\de\fd\9c\e3\97\e5\a0 \ec\f9\ef\92\e3\de\9c\e0\a1\a0 \9f\e9\9a\de\a4\a0 \9f\e9\c3\de\b0\c0\ea\a0\ec\de\fd\9e\97\e9 \e0\f2\e6\a0\bd\b0\ca\df\b0\a5\ba\dd\cb\df\ad\b0\c0\b0\e6\a0\n\db\b0\c4\de\9c\e0\e9\e3\de\9d\a1\a3}
					{"As a result, a crippling virus spread through the machine like a bad social disease. All control of the computer was lost."#j\a2\e4\9a\fb\96\de\a4\a0 \e5\e6\96\a0\e4\fd\e3\de\f3\e5\92\b3\a8\d9\bd\96\de\a0 \ba\dd\cb\df\ad\b0\c0\b0\9e\de\fd\e0\92\e6\a0\eb\fb\96\de\8f\e3\9c\ef\8f\e3\a4\a0 \9d\ed\de\e3\e9\a0 \ba\dd\c4\db\b0\d9\96\de\a0 \93\9c\e5\fc\fa\e3\a0 \9c\ef\8f\e0\e9\e3\de\9d\a1\a3}
				)
				(= seconds 30)
			)
			(17
				(localproc_1)
				(= cycles 1)
			)
			(18
				(localproc_0
					{"All screens went blank, then these words were displayed by the monitors and uttered by the vocal outputs -\n"WILCO MUST PAY!""#j\a2\9d\ed\de\e3\e9\96\de\f2\fd\96\de\a0 \cc\de\d7\dd\b8\e6\e5\f8\a4\a0 \e2\97\de\e9\f6\93\e5\a0 \d2\af\be\b0\bc\de\96\de\a0 \d3\c6\c0\b0\e4\a0\bd\cb\df\b0\b6\b0\96\f7\a0 \e3\de\e3\97\e0\e9\e3\de\9d\a1\n"\b3\a8\d9\ba\ea\a0\9e\97\e6\fd\86\a0\e4\f7\e8\ea\de\e5\f7\e7\ff"\a3}
					{"From that day forth the possessed computer waged war on the inhabitants of Xenon using our own weapons against us. Some managed to escape to other planets."#j\a2\9f\e9\eb\96\f7\a4\a0 \e5\e6\f3\e9\96\e6\a0 \e4\f8\e2\96\fa\e0\ba\dd\cb\df\ad\b0\c0\b0\ea\a4\a0 \fc\fa\fc\fa\e9\ec\de\97\86\a0 \be\de\c9\dd\e9\9c\de\8d\93\f0\fd\e6\a0\e0\92\9c\e3\e2\96\92\e0\de\9c\a4\a0 \e0\e0\96\92\86\a0\e9\9f\de\fd\e3\de\97\e0\e9\e3\de\9d\a1\n\9c\de\8d\93\f0\fd\e9\a0\e5\fd\e6\fd\96\ea\a4\a0 \ee\96\e9\a0\fc\98\9e\92\ed\a0\e6\99\de\f9\9a\e4\96\de\a0 \e3\de\97\ef\9c\e0\a1\a3}
				)
				(= seconds 30)
			)
			(19
				(localproc_1)
				(= cycles 1)
			)
			(20
				(localproc_0
					{"Those of us who remained stayed to fight the machines and robots under its control. It was a bloody war. Those of us that were not killed were taken captive and 'modified.'"#j\a2\9c\96\9c\a4\a0 \fc\e0\9c\e0\e1\e9\f6\93\e6\a0\e9\9a\8f\e0\f3\e9\e0\e1\ea\a4\a0 \ba\dd\cb\df\ad\b0\c0\b0\96\de\a0 \9c\ea\92\9c\e3\92\f9\a4\a0 \db\ce\de\af\c4\e0\e1\e4\a0\e0\e0\96\92\e2\e2\de\99\ef\9c\e0\a1\n\e0\98\9b\fd\e9\a0\eb\e4\eb\de\e4\96\de\a0 \n\9a\fb\9b\fa\ef\9c\e0\a1\a0 \n\9a\fb\9b\fa\e5\96\8f\e0\f3\e9\e0\e1\ea\a4\a0 \n\ee\f8\8e\e4\e5\f8\a4\a0 "\9e\fd\e9\93"\9b\fa\e3\a0\n\9c\ef\8f\e0\e9\e3\de\9d\a1\a3}
					{"These 'cyborgs' infiltrated the loyal ranks of resistance, rooting out almost all of our hiding places and exposing us to the mechanical menace. Some of these poor souls still wander the streets."#j\a2"\bb\b2\ce\de\b0\b8\de"\e0\e1\ea\a4\a0 \da\bc\de\bd\c0\dd\bd\e9\a0\e5\96\ef\e9\e5\96\e6\a0\ef\97\de\fa\9a\f0\a4\a0 \96\98\fa\ea\de\9c\8e\e9\a0\ee\e4\fd\e4\de\86\f0\e2\99\e0\de\9c\a4\a0 \fc\fa\fc\fa\86\a0\97\8e\93\ec\e6\a0\95\e4\9c\92\fa\e0\e9\e3\de\9d\a1\a0 \bb\b2\ce\de\b0\b8\de\e0\e1\ea\a0\92\ef\e3\de\f3\a0\ef\e1\86\a0\9b\ef\f6\92\91\f9\92\e3\92\ef\9d\a1\a3}
				)
				(= seconds 30)
			)
			(21
				(localproc_1)
				(= cycles 1)
			)
			(22
				(localproc_0
					{"As of this recording, we are down to only a handful of rebels. My health is deteriorating rapidly. To make matters worse, I've just learned that the computer has unraveled the mysteries\nof time travel."#j\a2\9a\e9\da\ba\b0\c3\de\a8\dd\b8\de\86\9c\e3\92\f9\a0\99\de\fd\9b\de\92\e3\de\ea\a4\a0 \f3\93\a0 \fc\9d\de\96\e5\a0 \e5\96\ef\9c\96\a0\e9\9a\8f\e3\92\e5\92\e9\e3\de\9d\a1\a0 \n\fc\e0\9c\e9\a0 \99\fd\9a\93\9c\de\8e\93\e0\92\f3\a0\e4\de\fd\e4\de\fd\a0 \fc\f9\98\e5\8f\e3\92\ef\9d\a1\a0 \9b\f7\e6\a0\fc\f9\92\9a\e4\e6\a0 \n\ba\dd\cb\df\ad\b0\c0\b0\96\de\a0 \n\c0\b2\d1\c4\d7\cd\de\d9\e9\a0\n\97\de\9c\de\8d\e2\86\a0\ea\8f\99\fd\9c\e3\n\9c\ef\8f\e0\e9\e3\de\9d\a1\a3}
					{"I've sent my two best men to attempt to steal this new technology. If you are not a machine then perhaps they were successful. Please realize - YOU are Xenon's last hope."#j\a2\9a\e9\a0 \91\e0\f7\9c\92\97\de\9c\de\8d\e2\86\a0\e3\e6\92\fa\f9\e0\f2\e6\a4\a0 \f3\8f\e4\f3\9c\fd\f7\92\e3\de\97\f9\a0 \ec\e0\f8\e9\a0 \ec\de\96\86\a0 \95\98\f8\ef\9c\e0\a1\a0 \n\f3\9c\a4\a0 \91\e5\e0\96\de\a0 \97\96\92\e3\de\e5\99\fa\ea\de\a4\a0 \e0\ec\de\fd\a0 \9e\92\9a\93\9c\e0\e9\e3\de\9c\8e\93\a1\a0 \e4\de\93\96\a0 \fc\96\8f\e3\98\e0\de\9b\92\a1\a0 \91\e5\e0\ea\a0 \be\de\c9\dd\9e\92\e9\a0\9b\92\9a\de\e9\a0\ce\b0\cc\df\e5\e9\e3\de\9d\a1\a3}
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
				((gEgo _head:) startUpd:)
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
				(if (not local28)
					(gEgo illegalBits: -32766)
				else
					(gEgo illegalBits: -32768)
				)
				(Face gEgo theJar self)
			)
			(2
				(Print 70 2) ; "You take the jar into custody."
				(SetScore 53 5)
				(gEgo get: 5) ; jar
				(theJar dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterSewer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 63 136 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo view: 70 setLoop: 8 cel: 0 setCycle: End self)
			)
			(3
				(HandsOn)
				(gCurRoom newRoom: 85)
			)
		)
	)
)

(instance door of Actor
	(properties
		x 45
		y 127
		z -16
		description {sealed door}
		sightAngle 45
		view 70
		loop 5
		priority 9
		signal 18448
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (not local28)
					(HandsOff)
					(gCurRoom setScript: doorScript)
				else
					(Print 70 3) ; "You realize that this is the only way out, so you decide to leave it open."
				)
			)
			(2 ; Look
				(if local28
					(Print 70 4) ; "There's an open hatch set into a cylindrical structure here. You recognize it as the entrance to the sewer system."
				else
					(Print 70 5) ; "There's a hatch set into a cylindrical structure here. Your janitorial background helps you recognize it as an entrance to a sewer system. Your stomach churns just considering the wonderful things one can find in a sewer."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorOpening of Feature
	(properties
		x 49
		y 137
		z 33
		nsTop 85
		nsLeft 36
		nsBottom 123
		nsRight 63
		description {sewer entrance}
		sightAngle 45
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 0) ; Do
			(2 ; Look
				(if (not local28)
					0
				else
					(Print 70 6) ; "You peer into the darker area beyond the hatch frame and see nothing particularly revolting."
				)
			)
			(11 ; Smell
				(Print 70 7) ; "It smells mysterious. You have the urge to play 'Name That Gas'."
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
		view 70
		loop 6
		priority 12
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 70 8) ; "It's an empty jar with a lid, neither of which does anything entertaining."
			)
			(3 ; Do
				(if (== ((gInventory at: 5) owner:) 70) ; jar
					(gEgo illegalBits: 0)
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
		z -82
		nsBottom 189
		nsRight 319
		description {substation}
		sightAngle 180
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 70 9) ; "You've reached the Sewer Maintenance Office. There's a thick layer of dust on everything, leading you to believe that there's very little maintenance going on. Apparently this office has been long abandoned. Your keen janitorial instincts urge you to sweep up and do a little dusting. Somehow you manage to suppress those urges and concentrate on the task at hand."
			)
			(11 ; Smell
				(Print 70 10) ; "The smell down here isn't as bad as you thought."
			)
			(else
				(super doVerb: theVerb)
			)
		)
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
			(3 ; Do
				(HandsOff)
				(gEgo illegalBits: 0)
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
		onMeCheck 16448
		lookStr {The strange little pedestal has wires running between it and the wall.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 70 11) ; "Nothing you can do to it here will be of benefit."
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
		lookStr {The desk is not exactly executive status caliber.}
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
			(3 ; Do
				(Print 70 12) ; "They won't come loose."
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
		nsBottom 200
		nsRight 320
		description {pipes}
		sightAngle 45
		onMeCheck 16
		lookStr {A variety of pipes, coolant and otherwise, pass in, through and around the room.}
	)

	(method (doVerb theVerb)
		(self x: ((User curEvent:) x:) y: ((User curEvent:) y:))
		(switch theVerb
			(3 ; Do
				(Print 70 13) ; "They're well affixed."
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

