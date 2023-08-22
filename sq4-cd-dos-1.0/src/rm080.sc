;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Main)
(use sewer)
(use eRS)
(use Polygon)
(use Motion)
(use System)

(public
	rm080 0
)

(instance rm080 of SQRoom
	(properties
		picture 80
		east 85
		south 95
		west 75
		picAngle 70
	)

	(method (init &tmp temp0)
		(sewer roomVer: 3591)
		(HandsOn)
		(Load rsVIEW 80)
		(switch gPrevRoomNum
			(west
				(gEgo y: 100)
				(= temp0 12)
			)
			(south
				(if (< (gEgo x:) 145)
					(gEgo x: 146)
				)
				(if (> (gEgo x:) 172)
					(gEgo x: 171)
				)
				(= temp0 14)
				(if (and (== (sewer location:) 80) (== (sewer status:) 6))
					(HandsOff)
					(Load rsSOUND 818)
					(Load rsVIEW 76)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						setCycle: Fwd
						cycleSpeed: 6
						moveSpeed: (- gGameSpeed 2)
						posn: 157 160
					)
					(sewer status: 4)
				)
			)
			(east
				(if (and (== (sewer location:) 80) (== (sewer status:) 6))
					(Load rsSOUND 818)
					(Load rsVIEW 76)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						setCycle: Fwd
						setLoop: 2
						posn: 255 91
						setScript: (ScriptID 702 4) ; theSlimeScript
					)
					(sewer status: 4)
				else
					(sewer status: 0 location: 0)
				)
				(self setScript: enterRight)
				(= temp0 11)
			)
			(else
				(gLongSong number: 805 vol: 127 loop: -1 playBed:)
				(gEgo posn: 27 94)
			)
		)
		(self style: temp0)
		((ScriptID 702 5) init: setLoop: 2 posn: 113 62 setScript: daDripScript) ; theDrip1
		((ScriptID 702 6) ; theDrip2
			init:
			setLoop: 3
			posn: 250 45
			cycleSpeed: 12
			setCycle: Fwd
		)
		(gEgo init: setPri: -1)
		(super init:)
		((ScriptID 702 2) show:) ; theSlime
		(self
			setRegions: 702 ; sewer
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 101 132 101 152 123 151 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 166 189 166 123 187 101 319 102 319 189
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 0 0 319 0 319 94 0 94 yourself:)
		)
		(if (and (!= gPrevRoomNum 95) (!= (sewer location:) 80))
			(sewer status: 1)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(HandsOff)
				(self setScript: exitSouth)
			)
			((or (== (gEgo edgeHit:) EDGE_RIGHT) (== (gEgo edgeHit:) EDGE_LEFT))
				(sewer location: 0 status: 0)
			)
		)
		(super doit: &rest)
		(if
			(and
				(== (dripScript state:) -1)
				(> (gEgo y:) 170)
				(== (sewer status:) 1)
			)
			((ScriptID 702 3) init: hide: setScript: dripScript) ; theDrip
		)
		(if
			(and
				(== (sewer status:) 3)
				(== ((ScriptID 702 2) loop:) 3) ; theSlime
				(> ((ScriptID 702 2) y:) 163) ; theSlime
			)
			(if (< (gEgo y:) ((ScriptID 702 2) y:)) ; theSlime
				((ScriptID 702 2) setScript: slimeLeaving) ; theSlime
				(sewer status: 8)
			else
				((ScriptID 702 2) setMotion: 0 setScript: 0) ; theSlime
			)
		)
	)

	(method (doVerb)
		(sewer doVerb: &rest)
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
						(or (== (sewer status:) 3) (== (sewer status:) 4))
						(> ((ScriptID 702 2) y:) 160) ; theSlime
					)
					((ScriptID 702 2) setMotion: 0 setScript: 0) ; theSlime
				)
				(gEgo setMotion: MoveTo (gEgo x:) 239 self)
			)
			(2
				(if (== (sewer status:) 2)
					(sewer status: 3)
					(gLongSong2 vol: 127 number: 819 loop: -1 playBed:)
				)
				(if
					(and
						(== (sewer location:) 95)
						(== (sewer status:) 6)
						(> (sewer rmTimer:) 7)
					)
					(sewer status: 8)
				)
				(gCurRoom newRoom: 95)
			)
		)
	)
)

(instance dripScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gLongSong fade: 0 10 10 0)
				(gLongSong2 vol: 127 number: 806 loop: 1 play:)
				(sewer location: 80)
				((ScriptID 702 3) ; theDrip
					show:
					setPri: 5
					setLoop: 4
					posn: 159 38
					cel: 0
					cycleSpeed: 12
					setCycle: CT 10 1 self
				)
				((ScriptID 702 2) ; theSlime
					init:
					hide:
					setLoop: 3
					setPri: 3
					setCycle: 0
					posn: 159 60
					cycleSpeed: 6
					moveSpeed: (- gGameSpeed 2)
				)
			)
			(2
				((ScriptID 702 3) setCel: 11) ; theDrip
				((ScriptID 702 2) show: posn: 159 65) ; theSlime
				(= cycles 3)
			)
			(3
				((ScriptID 702 3) setCel: 12) ; theDrip
				((ScriptID 702 2) posn: 159 70) ; theSlime
				(= cycles 3)
			)
			(4
				((ScriptID 702 3) setCel: 13) ; theDrip
				((ScriptID 702 2) posn: 159 75) ; theSlime
				(= cycles 3)
			)
			(5
				((ScriptID 702 3) setCel: 14) ; theDrip
				((ScriptID 702 2) posn: 159 80) ; theSlime
				(= cycles 3)
			)
			(6
				(gLongSong2 vol: 127 number: 819 loop: -1 playBed:)
				((ScriptID 702 3) hide:) ; theDrip
				((ScriptID 702 2) posn: 159 85) ; theSlime
				(sewer status: 3)
				((ScriptID 702 2) ; theSlime
					setScript: (ScriptID 702 4) ; theSlimeScript
					moveSpeed: (- gGameSpeed 2)
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
				((ScriptID 702 5) setCycle: End self) ; theDrip1
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
				((ScriptID 702 2) setMotion: MoveTo 158 210 self) ; theSlime
			)
			(1
				((ScriptID 702 2) posn: 1000 1000 dispose:) ; theSlime
				(sewer location: 95 status: 6 rmTimer: 0)
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
				(gEgo posn: 303 99 setMotion: MoveTo 294 99 self)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

