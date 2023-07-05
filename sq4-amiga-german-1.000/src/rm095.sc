;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use Main)
(use sewer)
(use eRS)
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
		(sewer roomVer: 3591)
		(Load rsVIEW 80)
		(if
			(and
				(== ((ScriptID 702 2) loop:) 3) ; theSlime
				(== (sewer status:) 8)
				(== (sewer location:) 95)
			)
			((ScriptID 702 2) ; theSlime
				init:
				hide:
				posn: 158 187
				setLoop: 3
				setCycle: Fwd
				moveSpeed: 0
				setScript: slimeLeaving
			)
		)
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
						moveSpeed: 0
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(sewer cantDie: 1 location: 95)
				)
				(if (and (== (sewer status:) 6) (== (sewer location:) 95))
					(Load rsVIEW 76)
					(Load rsSOUND 818)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						posn: 158 92
						setLoop: 3
						setCycle: Fwd
						moveSpeed: 0
					)
					(sewer status: 4 location: 95)
				)
				(gEgo x: 156)
				(= temp0 13)
			)
			(south
				(self setScript: enterSouth)
				(= temp0 14)
			)
			(east
				(= temp0 11)
				(self setScript: enterRight)
			)
			(west
				(if (OneOf (sewer location:) 105 75)
					(sewer location: 0 status: 0)
				)
				(= temp0 12)
				(self setScript: enterLeft)
			)
			(else
				(gLongSong number: 805 vol: 127 loop: -1 playBed:)
				(gEgo posn: 157 174)
			)
		)
		(self style: temp0)
		((ScriptID 702 5) init: setLoop: 8 posn: 69 44 cycleSpeed: 1) ; theDrip1
		(if (>= (gGame detailLevel:) 2)
			((ScriptID 702 5) setCycle: Fwd) ; theDrip1
		else
			((ScriptID 702 5) stopUpd:) ; theDrip1
		)
		((ScriptID 702 6) init: setLoop: 9 posn: 250 79) ; theDrip2
		(if (>= (gGame detailLevel:) 2)
			((ScriptID 702 6) setScript: daDripScript) ; theDrip2
		else
			((ScriptID 702 6) stopUpd:) ; theDrip2
		)
		(gEgo init:)
		(super init:)
		((ScriptID 702 2) show:) ; theSlime
		(gEgo show:)
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
					init: 0 102 130 102 139 106 145 116 145 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 94 179 94 170 89 165 83 165 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 167 189 167 112 172 105 177 102 319 102 319 189
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
			((== (gEgo edgeHit:) 1)
				(HandsOff)
				(self setScript: exitNorth)
			)
			((== (gEgo edgeHit:) 3)
				(HandsOff)
				(self setScript: exitSouth)
			)
			((== (gEgo edgeHit:) 2)
				(if (== (sewer location:) 95)
					(if (> ((ScriptID 702 2) y:) 120) ; theSlime
						(sewer status: 8)
					)
					(if (> (sewer distance:) 35)
						(gLongSong2 vol: 0 fade: 0 10 10 0)
						(gLongSong vol: 127 playBed:)
					)
				)
			)
			((== (gEgo edgeHit:) 4)
				(if (== (sewer location:) 95)
					(if (> ((ScriptID 702 2) y:) 120) ; theSlime
						(sewer status: 8)
					)
					(if (> (sewer distance:) 35)
						(gLongSong2 vol: 0 fade: 0 10 10 0)
						(gLongSong vol: 127 playBed:)
					)
				)
				(if (OneOf (sewer location:) 110 100)
					(sewer location: 0 status: 0)
				)
			)
			(
				(and
					(== gPrevRoomNum 110)
					(== (sewer location:) 110)
					(> (sewer rmTimer:) 10)
				)
				(sewer location: 0 status: 0)
			)
			(
				(and
					(== gPrevRoomNum 100)
					(== (sewer location:) 100)
					(> (sewer rmTimer:) 10)
				)
				(sewer location: 0 status: 0)
			)
		)
		(super doit: &rest)
		(if
			(and
				(& (gEgo onControl: 1) $0002)
				(== ((ScriptID 702 2) loop:) 3) ; theSlime
			)
			(sewer cantDie: 1)
		else
			(sewer cantDie: 0)
		)
		(if
			(and
				(== (sewer status:) 3)
				(== ((ScriptID 702 2) loop:) 3) ; theSlime
				(> ((ScriptID 702 2) y:) 160) ; theSlime
				(== (gEgo heading:) 180)
				(> (gEgo y:) 160)
			)
			((ScriptID 702 2) setMotion: 0 setScript: 0) ; theSlime
		)
		(if (< (gEgo y:) 50)
			(gEgo setPri: 4)
		else
			(gEgo setPri: -1)
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
				(if (and (== (sewer location:) 95) (== (sewer status:) 3))
					(gLongSong2 vol: 0 fade: 0 10 10 0)
					(gLongSong vol: 127 playBed:)
					(if (== ((ScriptID 702 2) loop:) 2) ; theSlime
						((ScriptID 702 2) setLoop: 3) ; theSlime
						(sewer status: 6)
					)
				)
				(gCurRoom newRoom: 80)
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
				(gEgo posn: 309 99 setMotion: MoveTo 292 99 self)
				(cond
					((and (== (sewer status:) 6) (== (sewer location:) 95))
						(Load rsSOUND 818)
						(Load rsVIEW 76)
						((ScriptID 702 2) ; theSlime
							init:
							hide:
							posn: 260 89
							setLoop: 2
							moveSpeed: 0
							setScript: (ScriptID 702 4) ; theSlimeScript
						)
						(gLongSong vol: 0 fade: 0 10 10 0)
						(gLongSong2 vol: 127 playBed:)
						(sewer status: 4)
					)
					((and (== (sewer status:) 3) (== (sewer location:) 95))
						((ScriptID 702 2) ; theSlime
							init:
							hide:
							posn: 227 89
							setLoop: 2
							moveSpeed: 0
							setScript: (ScriptID 702 4) ; theSlimeScript
						)
						(gLongSong2 vol: 127 playBed:)
						(gLongSong vol: 0 fade: 0 10 10 0)
					)
					((and (== (sewer status:) 3) (== (sewer location:) 100))
						(if (< (sewer prevDistance:) 50)
							((ScriptID 702 2) ; theSlime
								init:
								hide:
								posn: 352 89
								setLoop: 2
								moveSpeed: 0
								setScript: (ScriptID 702 4) ; theSlimeScript
							)
							(sewer location: 95)
						else
							(gLongSong2 vol: 0 fade: 0 10 10 0)
							(gLongSong vol: 127 playBed:)
						)
					)
				)
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
				(if
					(and
						(== ((ScriptID 702 2) loop:) 2) ; theSlime
						(== (sewer status:) 3)
						(== (sewer location:) 95)
					)
					(sewer location: 0 status: 0)
					(gLongSong2 vol: 0 fade: 0 10 10 0)
					(gLongSong vol: 127 playBed:)
				)
				(if
					(and
						(== ((ScriptID 702 2) loop:) 3) ; theSlime
						(< ((ScriptID 702 2) y:) 100) ; theSlime
						(== (sewer status:) 3)
						(== (sewer location:) 95)
					)
					(sewer status: 6)
					(gLongSong2 vol: 0 fade: 0 10 10 0)
					(gLongSong vol: 127 playBed:)
				)
				(gEgo setMotion: MoveTo (gEgo x:) 239 self)
			)
			(2
				(if (== (sewer location:) 110)
					(gLongSong2 vol: 127 playBed:)
					(gLongSong vol: 0 fade: 0 10 10 0)
				)
				(if (== (sewer location:) 100)
					(sewer status: 0 location: 0)
				)
				(gCurRoom newRoom: 110)
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
				(cond
					(
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
							moveSpeed: 0
							setScript: (ScriptID 702 4) ; theSlimeScript
						)
						(sewer location: 95)
					)
					((and (== (sewer status:) 3) (== (sewer location:) 95))
						(if (> (sewer oldDistance:) 109)
							(sewer oldDistance: 109)
						)
						((ScriptID 702 2) ; theSlime
							init:
							hide:
							posn: (+ (sewer oldDistance:) 5) 89
							setLoop: 2
							moveSpeed: 0
							setScript: (ScriptID 702 4) ; theSlimeScript
						)
						(gLongSong2 vol: 127 playBed:)
						(gLongSong vol: 0 fade: 0 10 10 0)
					)
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

(instance enterSouth of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(sewer rmTimer: 0)
				(gEgo init: posn: 162 185)
				(if (and (== (sewer location:) 95) (< (sewer prevDistance:) 60))
					(sewer status: 6)
				)
				(cond
					((and (== (sewer status:) 3) (== (sewer location:) 95))
						((ScriptID 702 2) ; theSlime
							init:
							hide:
							posn: 158 (- 190 (sewer prevDistance:))
							setLoop: 3
							setCycle: Fwd
							setScript: (ScriptID 702 4) ; theSlimeScript
						)
						(gLongSong vol: 0 fade: 0 10 10 0)
						(gLongSong2 vol: 127 playBed:)
					)
					((and (== (sewer status:) 6) (== (sewer location:) 95))
						(Load rsSOUND 818)
						(Load rsVIEW 76)
						((ScriptID 702 2) ; theSlime
							init:
							show:
							posn: 158 144
							setLoop: 3
							setCycle: Fwd
							setScript: (ScriptID 702 4) ; theSlimeScript
						)
						(sewer status: 4)
						(gLongSong vol: 0 fade: 0 10 10 0)
						(gLongSong2 vol: 127 playBed:)
						(= register 1)
					)
				)
				(= cycles 5)
			)
			(1
				(if (== register 1)
					((ScriptID 702 2) setScript: (ScriptID 702 1)) ; theSlime, theDeathScript
				else
					(NormalEgo)
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance daDripScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				((ScriptID 702 6) setCycle: End self) ; theDrip2
			)
			(1
				(= cycles (Random 5 20))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance slimeLeaving of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				((ScriptID 702 2) setMotion: MoveTo 158 209 self) ; theSlime
			)
			(1
				(sewer status: 3 location: 110)
				((ScriptID 702 2) posn: 1000 1000 dispose:) ; theSlime
			)
		)
	)
)

