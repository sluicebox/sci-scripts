;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 60)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use RandCycle)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm060 0
)

(local
	[local0 16] = [0 163 44 163 62 180 247 180 251 184 319 184 319 189 0 189]
)

(instance rm060 of SQRoom
	(properties
		picture 60
		style 30
		horizon 130
		north 45
		east 65
		west 55
	)

	(method (init)
		(LoadMany rsVIEW 0 61)
		(LoadMany rsSOUND 802 807)
		(switch gPrevRoomNum
			(40
				(HandsOn)
				(gEgo x: 20 y: (+ horizon (gEgo yStep:)))
			)
			(50
				(HandsOn)
				(gEgo x: 300 y: (+ horizon (gEgo yStep:)))
			)
			(59
				(Load rsVIEW 62)
				(LoadMany rsSOUND 821 822 115)
				(gLongSong2
					priority: 15
					vol: 127
					number: 115
					loop: 1
					init:
					changeState:
				)
				(HandsOff)
				(self setScript: ripScript style: 42)
			)
			(55
				(HandsOff)
				(self setScript: enterScript)
				(gEgo
					y:
						(cond
							((> (gEgo y:) 175) 172)
							((< (gEgo y:) (+ horizon (gEgo yStep:)))
								(+ horizon (gEgo yStep:))
							)
							(else
								(gEgo y:)
							)
						)
				)
				(self setScript: enterScript)
			)
			(65
				(HandsOff)
				(gEgo
					y:
						(cond
							((> (gEgo y:) 175) 172)
							((< (gEgo y:) (+ horizon (gEgo yStep:)))
								(+ horizon (gEgo yStep:))
							)
							(else
								(gEgo y:)
							)
						)
				)
				(self setScript: enterScript)
			)
			(72
				(gEgo x: 160 y: (+ horizon (gEgo yStep:)) setHeading: 180)
			)
			(45
				(HandsOn)
				(gEgo
					x:
						(cond
							((> (gEgo x:) 290) 290)
							((< (gEgo x:) 30) 30)
							(else
								(gEgo x:)
							)
						)
					y: (+ horizon (gEgo yStep:))
				)
			)
			(else
				(HandsOn)
				(gEgo x: 160 y: (+ horizon (gEgo yStep:)))
			)
		)
		(if (> (gEgo y:) 175)
			(gEgo y: 172)
		)
		(if (!= gPrevRoomNum 59)
			(lightning1 init: setScript: lightningScript)
			(thunder init:)
		)
		(theBuildings init:)
		(theFrontRubble init:)
		(theBackRubble init:)
		(theArea init:)
		(thunder init:)
		(poly1 points: @local0 size: 8)
		(if (not (IsFlag 0))
			(self setRegions: 701) ; street
		)
		(super init:)
		(self setRegions: 705 addObstacle: poly1) ; bunny
		(if (!= gPrevRoomNum 59)
			(gEgo init:)
		)
		(if (== gPrevRoomNum 72)
			(Print 60 0 #at 50 150) ; "*** Well... here we are, Roger, what are you going to do this time?"
			(gLongSong number: 802 loop: -1 playBed:)
			(HandsOn)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= script ripScript)
			(super newRoom: newRoomNumber)
		)
	)

	(method (doit)
		(if
			(and
				(!= curPic 31)
				(not (lightning1 script:))
				(!= script ripScript)
			)
			(lightning1 init: setScript: lightningScript)
		)
		(super doit: &rest)
	)
)

(instance lightningScript of Script
	(properties)

	(method (doit)
		(if (== (gCurRoom curPic:) 31)
			(self dispose:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 15 30))
			)
			(1
				(self changeState: (+ (* (Random 0 1) 2) 2))
			)
			(2
				(lightning1 setCycle: RandCycle (Random 1 3) self)
			)
			(3
				(lightning1 setCel: 0)
				(= cycles 1)
			)
			(4
				(lightning2 init: setCycle: RandCycle (Random 3 5) self)
			)
			(5
				(lightning1 setCel: 0 setCycle: Beg self)
			)
			(6
				(lightning1 setCel: 0)
				(lightning2 dispose:)
				(= seconds 2)
			)
			(7
				(thunder play:)
				(Animate (gCast elements:) 0)
				(lightning1 dispose:)
				(self init:)
			)
		)
	)
)

(instance ripScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gLongSong2 number: 821 loop: -1 vol: 127 play:)
				(rip setLoop: 0 init:)
				(rip setCycle: ForwardCounter 7 self)
			)
			(2
				(gLongSong2 number: 822 play:)
				(rip y: 66 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(rip setLoop: 2 setCel: 0)
				(rip setCycle: ForwardCounter 4 self)
			)
			(4
				(gEgo
					init:
					normal: 0
					x: 155
					y: 75
					yStep: 10
					view: 62
					setLoop: 3
					setCel: 0
					setCycle: 0
					setPri: 3
					ignoreActors: 1
					ignoreHorizon: 1
					setMotion: MoveTo 155 110 self
				)
			)
			(5
				(gEgo
					setStep: 3 20
					setCel: 0
					setCycle: 0
					setMotion: MoveTo 155 160 self
				)
			)
			(6
				(gLongSong2 priority: 15 vol: 127 number: 115 loop: 1 play:)
				(rip setLoop: 1 setCel: 15 setCycle: Beg)
				(gEgo cycleSpeed: 0 setCycle: CT 2 1 self)
			)
			(7
				(rip dispose:)
				(= seconds 2)
			)
			(8
				(gEgo cycleSpeed: 1 setCycle: End self)
			)
			(9
				(= seconds 2)
			)
			(10
				(gEgo setCycle: CT 5 -1 self)
			)
			(11
				(gLongSong2 number: 0)
				(gEgo setLoop: 4 setCel: 0 setCycle: End self)
			)
			(12
				(gLongSong number: 802 loop: -1 playBed:)
				(NormalEgo 2 0)
				(AnimateEgoHead)
				(= cycles 2)
			)
			(13
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch gPrevRoomNum
					(55
						(gEgo x: -8 setMotion: MoveTo 10 (gEgo y:) self)
					)
					(else
						(gEgo x: 328 setMotion: MoveTo 310 (gEgo y:) self)
					)
				)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance rip of Prop
	(properties
		x 154
		y 82
		view 62
		loop 2
		cel 1
		priority 2
		signal 16
	)
)

(instance lightning1 of Prop
	(properties
		x 124
		y 15
		view 61
	)
)

(instance lightning2 of Prop
	(properties
		x 152
		y 24
		view 61
		loop 1
		priority 6
		signal 16
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance theFrontRubble of Feature
	(properties
		x 160
		y 189
		nsBottom 200
		nsRight 320
		description {rubble}
		onMeCheck 64
		lookStr {A twisted and broken expanse of cityscape stretches south from here negating possible travel plans in that direction.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 60 1) ; "The rubble is rough and jagged. No sense in risking injury this early in the adventure. We'll get to that in due time."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theBackRubble of Feature
	(properties
		x 155
		y 78
		nsBottom 200
		nsRight 320
		description {rubble}
		onMeCheck 16
		lookStr {More rubble can be seen to the north.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theBuildings of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {building}
		onMeCheck 8832
		lookStr {Decaying and destroyed buildings now house the apparently non-existent population of Xenon.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theArea of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {area}
		lookStr {You are in the southern area of a rare clearing in this destroyed cityscape. All around you inanimate victims of war litter the streets. Your home as you remembered it does not exist in this period of Xenon's time. A huge boil of a structure clogs the horizon.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4) ; Do
			(6 ; Inventory
				((ScriptID 705 4) doVerb: theVerb invItem) ; theRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thunder of Sound
	(properties
		number 807
		priority 15
	)
)

