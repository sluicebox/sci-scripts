;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use Interface)
(use sewer)
(use SQRoom)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm085 0
)

(instance rm085 of SQRoom
	(properties
		picture 85
		south 100
		west 80
		picAngle 70
		vanishingX 0
		vanishingY -40
	)

	(method (init)
		(sewer roomVer: 11891)
		(Load rsVIEW 85)
		(Load rsVIEW 80)
		(Load rsSOUND 810)
		(Load rsSOUND 811)
		(switch gPrevRoomNum
			(west
				(HandsOn)
				(gEgo y: 100)
				(self style: 41)
			)
			(south
				(self setScript: enterScript style: 30)
			)
			(else
				(self setScript: enterDoor)
			)
		)
		(door init: setPri: 10)
		(gEgo init: setPri: -1)
		(super init:)
		(gEgo show:)
		((ScriptID 702 2) show:) ; theSlime
		(self
			setRegions: 702 ; sewer
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 100 160 100 271 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 286 189 181 102 165 92 151 89 0 89
					yourself:
				)
		)
		(sewer status: 1)
		(sewer location: 85)
		((ScriptID 702 3) init: hide: setScript: dripScript) ; theDrip
	)

	(method (doit)
		(cond
			(script 0)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(switch (sewer status:)
					(1
						(sewer status: 0 location: 0)
					)
					(2
						(sewer status: 3)
					)
				)
				(HandsOff)
				(self setScript: exitSouth)
			)
		)
		(super doit: &rest)
	)
)

(instance door of Prop
	(properties
		x 277
		y 134
		description {door}
		sightAngle 90
		lookStr {This hatch, locked from the other side, was your portal to this area.}
		view 85
		signal 26624
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 85 0) ; "*** The door's locked from the other side."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					x: 334
					y: 240
					setLoop: 7
					setMotion: MoveTo 280 186 self
				)
			)
			(1
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dripScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= seconds (Random 2 5))
			)
			(1
				(if (> (gEgo y:) 165)
					(HandsOff)
					((ScriptID 702 3) ; theDrip
						show:
						setLoop: 6
						posn: 238 91
						cel: 0
						cycleSpeed: 1
						setCycle: CT 9 1 self
					)
					(sewer status: 2)
					(gLongSong fade: 80 10 10 0)
					(gLongSong2 number: 806 loop: 1 play:)
				else
					(self init:)
				)
			)
			(2
				((ScriptID 702 3) setCycle: End) ; theDrip
				((ScriptID 702 2) ; theSlime
					init:
					setLoop: 8
					cycleSpeed: 1
					setCycle: End self
					posn: 214 124
				)
				(HandsOn)
			)
			(3
				(gLongSong2 number: 819 loop: -1 play:)
				(sewer status: 3)
				((ScriptID 702 2) ; theSlime
					setLoop: 1
					setCycle: Fwd
					cycleSpeed: 0
					setScript: (ScriptID 702 4) ; theSlimeScript
				)
				(self dispose:)
			)
		)
	)
)

(instance exitSouth of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setLoop: -1 setHeading: 130 self)
			)
			(1
				(gEgo setLoop: 4 setMotion: MoveTo 327 237 self)
			)
			(2
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(instance enterDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					init:
					hide:
					posn: 240 158
					setCycle: 0
					setLoop: -1
					setHeading: 270
				)
				(door setCel: 255 cycleSpeed: 1)
				(= cycles 1)
			)
			(1
				(gLongSong2 number: 810 vol: 127 play:)
				(= cycles 5)
			)
			(2
				(door setCycle: Beg self)
			)
			(3
				(HandsOn)
				(NormalEgo)
				(gLongSong2 number: 811 loop: 1 play: self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

