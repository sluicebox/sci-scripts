;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use Main)
(use sewer)
(use SQRoom)
(use Polygon)
(use Motion)
(use System)

(public
	rm095 0
)

(local
	local0
)

(instance rm095 of SQRoom
	(properties
		picture 95
		horizon 40
		north 80
		east 100
		south 110
		west 90
		picAngle 70
	)

	(method (init &tmp temp0)
		(sewer roomVer: 11891)
		(Load rsVIEW 80)
		(switch gPrevRoomNum
			(north
				(if (and (== (sewer status:) 3) (== (sewer location:) 80))
					(cond
						((> (sewer prevDistance:) 100)
							((ScriptID 702 2) posn: 158 -50) ; theSlime
						)
						((> (sewer prevDistance:) 50)
							((ScriptID 702 2) posn: 158 -40) ; theSlime
						)
						(else
							((ScriptID 702 2) posn: 158 -25) ; theSlime
						)
					)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						setLoop: 3
						setCycle: Fwd
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(sewer cantDie: 1 location: 95)
				)
				(gEgo x: 156)
				(= temp0 42)
			)
			(south
				(if (and (== (sewer status:) 3) (== (sewer location:) 95))
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: 158 128
						setLoop: 3
						setCycle: Fwd
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
				)
				(gEgo x: 156)
				(= temp0 43)
			)
			(east
				(= temp0 40)
				(self setScript: enterRight)
			)
			(west
				(if (OneOf (sewer location:) 105 75)
					(sewer location: 0 status: 0)
				)
				(= temp0 41)
				(self setScript: enterLeft)
			)
			(else
				(gEgo posn: 157 174)
			)
		)
		(self style: temp0)
		(gEgo init:)
		(super init:)
		((ScriptID 702 2) show:) ; theSlime
		(self
			setRegions: 702 ; sewer
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 145 0 145 83 139 88 128 93 0 93
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 100 129 100 140 102 145 106 145 116 145 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 94 179 94 170 89 165 83 165 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 167 189 167 112 172 105 178 101 319 101 319 189
					yourself:
				)
		)
		(if (not (OneOf gPrevRoomNum 100 90))
			(HandsOn)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((== (gEgo edgeHit:) EDGE_TOP)
				(HandsOff)
				(self setScript: exitNorth)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(HandsOff)
				(self setScript: exitSouth)
			)
			((or (== (gEgo edgeHit:) EDGE_RIGHT) (== (gEgo edgeHit:) EDGE_LEFT))
				(cond
					((!= (sewer location:) 95)
						(sewer location: 0 status: 0)
					)
					((> ((ScriptID 702 2) y:) 120) ; theSlime
						(sewer location: 0 status: 0)
						(gLongSong2 fade:)
					)
				)
			)
			((and (== (sewer location:) 110) (> (sewer rmTimer:) 10))
				(sewer location: 0 status: 0)
			)
		)
		(super doit: &rest)
		(if (< (gEgo y:) 50)
			(gEgo setPri: 4)
		else
			(gEgo setPri: -1)
		)
		(if
			(and
				(== (sewer status:) 3)
				(== ((ScriptID 702 2) loop:) 3) ; theSlime
				(> ((ScriptID 702 2) y:) 163) ; theSlime
				(> (gEgo y:) 199)
			)
			((ScriptID 702 2) setMotion: 0 setScript: 0) ; theSlime
		)
	)
)

(instance exitNorth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< ((ScriptID 702 2) y:) -22) ; theSlime
					(sewer status: 6)
					((ScriptID 702 2) posn: 1000 1000) ; theSlime
				)
				(gEgo setMotion: MoveTo 156 10 self)
			)
			(1
				(gEgo setMotion: MoveTo 156 -6 self)
			)
			(2
				(if (OneOf (sewer location:) 110 100)
					(sewer location: 0 status: 0)
				)
				(gCurRoom newRoom: 80)
			)
		)
	)
)

(instance enterLeft of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(if
					(and
						(== (sewer status:) 3)
						(== (sewer location:) 90)
						(< (sewer prevDistance:) 40)
					)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: -32 89
						setLoop: 2
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(sewer location: 95)
				)
				(gEgo posn: 11 98 setMotion: MoveTo 29 98 self)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance enterRight of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (== (sewer status:) 3) (== (sewer location:) 95))
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: 227 90
						setLoop: 2
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
				)
				(if
					(and
						(== (sewer status:) 3)
						(== (sewer location:) 100)
						(< (sewer prevDistance:) 50)
					)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: 352 91
						setLoop: 2
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(sewer location: 95)
				)
				(gEgo posn: 309 99 setMotion: MoveTo 292 99 self)
			)
			(1
				(HandsOn)
				(NormalEgo)
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
				(gEgo setHeading: 180 self)
			)
			(1
				(if (or (== (sewer status:) 3) (== (sewer status:) 4))
					((ScriptID 702 2) setMotion: 0 setScript: 0) ; theSlime
					(if (< ((ScriptID 702 2) y:) 90) ; theSlime
						(sewer location: 0 status: 0)
					)
				)
				(gEgo setMotion: MoveTo (gEgo x:) 239 self)
			)
			(2
				(if (== (sewer status:) 2)
					(sewer status: 3)
				)
				(if (== (sewer location:) 110)
					(gLongSong2 number: 819 loop: -1 play:)
				)
				(gCurRoom newRoom: 110)
			)
		)
	)
)

