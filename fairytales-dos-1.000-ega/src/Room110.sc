;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use n010)
(use Tactor)
(use goGet)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	Room110 0
)

(local
	local0
	[local1 200]
)

(procedure (localproc_0)
	(lion init:)
	(door init:)
	(clock init:)
	(stairs init:)
	(castle init:)
	(wall init:)
	(road init:)
	(flowers init:)
)

(instance Room110 of FRoom
	(properties
		lookStr {Here is the castle of Prince Charming.}
		picture 110
		style 0
		east 120
		south 160
		southX 99
		southY 180
		eastX 312
		eastY 142
	)

	(method (init)
		(if (> global225 0)
			(Load rsSOUND global225)
		)
		(switch (gCindStory state:)
			(2
				(LoadMany rsSOUND 32 36)
				(self defeatEntrance: 1)
			)
			(3
				(LoadMany rsSOUND 30 114)
			)
		)
		(gCurRoom picture: 110)
		(super init:)
		(proc10_29)
		(switch (gCindStory state:)
			(2
				(if (gGame script:)
					(gGame setScript: 0)
					(gGlobalMusic2 stop:)
				)
				(gGlobalMusic number: 32 priority: 15 setLoop: -1 play:)
			)
			(3
				(Load rsSOUND 30)
			)
		)
		(gTheIconBar enable: show:)
		(gCindStory selection: 0)
		(clockHand cel: 0 stopUpd: init:)
		(switch (gCindStory state:)
			(2
				(LoadMany rsVIEW 758 761 602)
				(gCurRoom picture: 115)
				(gCurRoom drawPic: 115 0)
				(clockHand cel: 4)
				(gEgo doCode: egoDo110)
				(prince
					view: 600
					loop: 1
					cel: 0
					posn: 154 154
					ignoreActors: 0
					init:
				)
				(slipper init:)
				(gBookEnd
					view: 762
					setPri: -1
					setLoop: 4
					setCel: 1
					posn: 302 170
					init:
				)
			)
			(3
				(Load rsVIEW 602)
				(clockHand cel: 2)
				(gEgo doCode: egoDo110)
				(prince
					view: 600
					loop: 2
					cel: 0
					posn: 108 144
					ignoreActors: 0
					init:
				)
			)
		)
		(waterWest setCycle: Fwd init: ignoreActors: 1)
		(waterEast setCycle: Fwd setPri: 8 init: ignoreActors: 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 67 173 0 173 0 0 319 0 319 103 267 126 255 130 239 136 227 142 177 145 150 148 141 139 119 123 112 114 83 114 73 131 82 138 83 143 82 154 30 150 36 159
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 173 283 173 254 173 243 164 250 158 272 146 273 139 319 133
					yourself:
				)
		)
		(localproc_0)
	)

	(method (cue)
		(super cue:)
		(switch (gCindStory state:)
			(2
				(self setScript: enterMidnight)
			)
			(3
				(self setScript: enterSlipperGone)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((>= (gEgo x:) 280)
				(gCurRoom setScript: moveEgoEast)
			)
		)
		(cond
			(script 0)
			((not local0) 0)
			((not (gEgo mover:)) 0)
			((<= (Abs (- (gEgo heading:) 180)) 80)
				(self setScript: bookChase)
			)
			((and (< (gEgo x:) 128) (< (gEgo y:) 129))
				(gCurRoom setScript: princeWarns)
			)
		)
	)

	(method (enterSpecial)
		(gCurRoom setScript: cindRun self)
	)

	(method (dispose)
		(switch (gCindStory state:)
			(3
				(if (gGlobalMusic handle:)
					(gGlobalMusic fade: 0 15 12 1)
					(= global225 33)
				)
			)
			(4
				(if (gGlobalMusic handle:)
					(gGlobalMusic fade: 0 15 12 1)
				)
			)
		)
		(super dispose: &rest)
	)
)

(instance moveEgoEast of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: PolyPath (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 120)
			)
		)
	)
)

(instance princeWarns of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo prince)
				(proc10_13 3 prince gEgo -1 0 110 0)
				(proc10_13 3 prince gEgo self 1 110 1)
			)
			(1
				(gEgo
					setMotion: PolyPath (gEgo x:) (+ (gEgo y:) 20) self
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance cindRun of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cinderella
					setLoop: 4
					setStep: 4 2
					setCycle: Fwd
					init:
					setMotion: PolyPath 306 125 self
				)
			)
			(1
				(cinderella dispose:)
				(prince setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gEgo posn: 312 142 init: hide:)
				(gCast delete: gEgo addToFront: gEgo)
				(proc10_13 2 prince prince self 1 110 2)
			)
			(3
				(proc10_13 2 prince prince self 1 110 3)
			)
			(4
				(prince setCycle: Beg self)
			)
			(5
				(proc10_13 2 prince gEgo -1 0 110 4)
				(proc10_13 2 prince gEgo self 1 110 5)
			)
			(6
				(prince setCycle: End)
				(NormalEgo 5 global139)
				(if (== gPrevRoomNum 120)
					(gEgo show: setMotion: PolyPath 244 147 self)
				else
					(gEgo
						show:
						posn: 212 180
						setMotion: PolyPath 244 147 self
					)
				)
			)
			(7
				(Face gEgo prince)
				(self dispose:)
			)
		)
	)
)

(instance bookChase of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 5)
				(gEgo setMotion: PolyPath 208 180 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance enterSlipperGone of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(prince setCycle: End self)
			)
			(1
				(proc10_13 0 prince gEgo self 1 110 6)
			)
			(2
				(if (gEgo has: 1)
					(self changeState: 7)
				else
					(proc10_13 0 gEgo prince self 1 110 7)
				)
			)
			(3
				(proc10_13 3 prince gEgo -1 0 110 8)
				(proc10_13 3 prince gEgo self 1 110 9)
			)
			(4
				(prince setCycle: Beg self)
			)
			(5
				(Wait 0)
				(Wait 30)
				(proc10_13 3 prince gEgo self 1 110 10)
			)
			(6
				(self dispose:)
			)
			(7
				(self setScript: returnSlipper self)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance giveSlipperSound of Sound
	(properties
		flags 1
		number 114
	)
)

(instance returnSlipper of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalMusic2 stop:)
				(= global225 0)
				(gGlobalMusic number: 34 priority: 15 setLoop: -1 play:)
				(gCindStory incState:)
				(proc10_13 0 gEgo prince self 1 110 11)
			)
			(1
				(gEgo setMotion: PolyPath 108 148 self)
			)
			(2
				(Face gEgo prince self)
			)
			(3
				(giveSlipperSound play:)
				(gTheIconBar curInvIcon: 0 show:)
				(proc10_13 0 prince gEgo self 1 110 12)
			)
			(4
				(gEgo setMotion: NPFollow prince 30)
				(prince view: 601 loop: 1 cel: 0)
				(= ticks 1)
			)
			(5
				(prince
					setLoop: 0
					setCycle: Walk
					setMotion: PolyPath (gCurRoom eastX:) (gCurRoom eastY:) self
				)
			)
			(6
				(prince dispose:)
				((gInventory at: 1) owner: 0)
				(gCurRoom newRoom: 120)
			)
		)
	)
)

(instance enterMidnight of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalMusic number: 36 priority: 15 setLoop: -1 play:)
				(= local0 1)
				(gCindStory incState:)
				(= ticks 1)
			)
			(1
				(gBookEnd
					setLoop: -1
					illegalBits: 0
					setCycle: Walk
					setStep: 7 3
					setMotion: MoveTo 240 168 self
				)
			)
			(2
				(gBookEnd ignoreActors: 1 setMotion: MoveTo 195 155 self)
			)
			(3
				(prince setLoop: 1 cel: 0 setCycle: CT 1 1 self)
			)
			(4
				(prince setCycle: End)
				(gBookEnd
					view: 758
					posn: 200 155
					setLoop: 0
					cel: 0
					setCycle: CT 4 1 self
				)
			)
			(5
				(slipper dispose:)
				(gBookEnd setCycle: End)
				(prince setLoop: 2 cel: 0 setCycle: End self)
			)
			(6
				(proc10_13 0 gBookEnd prince -1 0 110 13)
				(proc10_13 0 gBookEnd prince -1 0 110 14)
				(proc10_13 0 gBookEnd gBookEnd self 1 110 15)
			)
			(7
				(gBookEnd
					view: 762
					setLoop: -1
					cel: 0
					setCycle: Walk
					setMotion: PolyPath 180 220 self
				)
			)
			(8
				(gBookEnd dispose:)
				(= ticks 1)
			)
			(9
				(proc10_13 1 prince prince self 0 110 16)
			)
			(10
				(proc10_13
					3
					prince
					gEgo
					self
					1
					(Format @local1 110 17 @global110) ; "%s, will you find that slipper for me?"
				)
				((gInventory at: 1) owner: 270)
			)
			(11
				(self dispose:)
			)
		)
	)
)

(instance egoDo110 of Code
	(properties)

	(method (doit param1)
		(if (and (== param1 5) (== (gCindStory state:) 3))
			(if local0
				(gEgo setScript: do110Script 0 (gEgo selection:))
			else
				(gEgo setScript: do110Script 0 1000)
			)
			(gEgo incSel:)
		)
	)
)

(instance do110Script of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(0
						(proc10_13 0 gEgo prince self 1 110 18)
					)
					(1
						(proc10_13 0 gEgo prince self 1 110 19)
					)
					(2
						(proc10_13 0 gEgo prince self 1 110 20)
					)
					(1000
						(proc10_13 0 gEgo prince self 1 110 21)
					)
					(else
						(proc10_13 0 gEgo prince self 1 110 22)
					)
				)
			)
			(1
				(switch register
					(0
						(proc10_13 3 prince gEgo self 1 110 23)
					)
					(1
						(proc10_13 3 prince gEgo self 1 110 24)
					)
					(2
						(proc10_13 0 prince gEgo -1 0 110 25)
						(proc10_13 0 prince gEgo -1 0 110 26)
						(proc10_13 0 prince gEgo self 1 110 27)
					)
					(1000
						(proc10_13 0 prince gEgo self 1 110 28)
					)
					(else
						(proc10_13 0 prince gEgo self 1 110 29)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance cinderella of Actor
	(properties
		x 240
		y 150
		view 600
		loop 4
	)
)

(instance prince of Tactor
	(properties
		description {Prince Charming}
		lookStr {Prince Charming is a very handsome man.}
		talkerID 4
	)

	(method (setUp)
		((= talkerObj princeTalkObj) setUp: princeBust princeEyes princeMouth)
	)

	(method (doVerb theVerb invItem)
		(if (== theVerb 5) ; Do
			(if (== (gCindStory state:) 3)
				(if local0
					(gEgo setScript: princeTalkScript 0 (self selection:))
				else
					(gEgo setScript: princeTalkScript 0 1000)
				)
			)
			(self incSel:)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance princeTalkScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(0
						(proc10_13 3 prince gEgo self 1 110 30)
					)
					(1
						(proc10_13 3 prince gEgo -1 0 110 31)
						(proc10_13 3 prince gEgo self 1 110 32)
					)
					(2
						(proc10_13 3 prince gEgo -1 0 110 33)
						(proc10_13 3 prince gEgo self 1 110 34)
					)
					(1000
						(proc10_13 0 prince gEgo self 1 110 35)
					)
					(else
						(proc10_13 3 prince gEgo self 1 110 36)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance princeTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 602
	)
)

(instance princeBust of View
	(properties
		nsTop 25
		nsLeft 42
		view 602
		loop 6
	)
)

(instance princeEyes of Prop
	(properties
		nsTop 31
		nsLeft 44
		view 602
		loop 4
		cycleSpeed 50
	)
)

(instance princeMouth of Prop
	(properties
		nsTop 41
		nsLeft 41
		view 602
		loop 2
		cycleSpeed 12
	)
)

(instance slipper of Prop
	(properties
		x 173
		y 156
		view 800
		loop 1
		cel 1
	)
)

(instance waterWest of Prop
	(properties
		x 34
		y 140
		description {Stream}
		sightAngle 90
		lookStr {The stream flows past the castle.}
		view 110
		loop 1
		cel 3
	)
)

(instance waterEast of Prop
	(properties
		x 205
		y 137
		sightAngle 90
		view 110
		loop 2
	)

	(method (doVerb theVerb)
		(waterWest doVerb: theVerb)
	)
)

(instance clockHand of View
	(properties
		x 97
		y 12
		view 110
	)

	(method (doVerb theVerb)
		(clock doVerb: theVerb)
	)
)

(instance lion of Feature
	(properties
		x 55
		y 150
		description {Lion}
		sightAngle 90
		onMeCheck 2
		lookStr {This lion is made of stone.}
	)
)

(instance door of Feature
	(properties
		x 99
		y 110
		description {Door}
		sightAngle 90
		onMeCheck 4
		lookStr {The doors to the castle are locked.}
	)

	(method (doVerb)
		(proc10_23 110 37)
	)
)

(instance clock of Feature
	(properties
		x 95
		y 35
		description {Clock}
		sightAngle 90
		onMeCheck 8
		lookStr {The clock shows the time of day.}
	)
)

(instance stairs of Feature
	(properties
		x 96
		y 135
		description {Stairs}
		sightAngle 90
		onMeCheck 16
		lookStr {The stairs lead up to the door.}
	)
)

(instance castle of Feature
	(properties
		x 93
		y 66
		description {Castle}
		sightAngle 90
		onMeCheck 32
		lookStr {This is a large castle.}
	)
)

(instance wall of Feature
	(properties
		x 241
		y 94
		description {Wall}
		sightAngle 90
		onMeCheck 128
		lookStr {The wall is goes around the town.}
	)
)

(instance road of Feature
	(properties
		x 211
		y 150
		description {Road}
		sightAngle 90
		onMeCheck 256
		lookStr {The road leads east and south.}
	)
)

(instance flowers of Feature
	(properties
		x 19
		y 152
		description {Flowers}
		sightAngle 90
		onMeCheck 512
		lookStr {The flowers are pretty.}
	)
)

