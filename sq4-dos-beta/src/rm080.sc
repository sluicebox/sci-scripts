;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Main)
(use sewer)
(use SQRoom)
(use Polygon)
(use Feature)
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
		(sewer roomVer: 11491)
		(HandsOn)
		(Load rsVIEW 80)
		(switch gPrevRoomNum
			(west
				(sewer status: 0 location: 0)
				(gEgo y: 100)
				(= temp0 41)
			)
			(south
				(if (< (gEgo x:) 145)
					(gEgo x: 146)
				)
				(if (> (gEgo x:) 172)
					(gEgo x: 171)
				)
				(= temp0 43)
				(if (== (sewer status:) 6)
					(HandsOff)
					((ScriptID 702 2) ; theSlime
						init:
						hide:
						setCycle: Fwd
						cycleSpeed: 0
						posn: 157 160
					)
					(sewer status: 4)
				)
			)
			(east
				(sewer status: 0 location: 0)
				(gEgo y: 100)
				(= temp0 40)
			)
			(else
				(gEgo posn: 27 94)
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
		(if (!= gPrevRoomNum 95)
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
		)
		(super doit: &rest)
		(if (and (> (gEgo y:) 180) (== (sewer status:) 1))
			(sewer status: 2)
			((ScriptID 702 3) init: setScript: dripScript) ; theDrip
		)
		(if
			(and
				(== (sewer status:) 3)
				(== ((ScriptID 702 2) loop:) 3) ; theSlime
				(> ((ScriptID 702 2) y:) 163) ; theSlime
			)
			((ScriptID 702 2) setMotion: 0 setScript: 0) ; theSlime
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
				)
				(gCurRoom newRoom: 95)
			)
		)
	)
)

(instance theVent of Feature ; UNUSED
	(properties
		nsBottom 200
		nsRight 320
		description {vent}
		onMeCheck 64
		lookStr {There's a small vent set into the side of the sewer tunnel. Unfortunately, it looks way too narrow for a space janitor, even a wiry, skinny one, to squeeze inside.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(5) ; Talk
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dripScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gLongSong2 play:)
				(sewer location: 80)
				((ScriptID 702 3) ; theDrip
					setPri: 5
					setLoop: 4
					posn: 159 38
					cel: 0
					cycleSpeed: 1
					setCycle: CT 10 1 self
				)
				((ScriptID 702 2) ; theSlime
					init:
					hide:
					setLoop: 3
					setPri: 3
					setCycle: 0
					posn: 159 60
					moveSpeed: 0
					cycleSpeed: 0
				)
				(gLongSong fade: 80 10 10 0)
				(gLongSong2 number: 806 loop: 1 play:)
			)
			(1
				((ScriptID 702 3) setCel: 11) ; theDrip
				((ScriptID 702 2) show: posn: 159 65) ; theSlime
				(= cycles 3)
			)
			(2
				((ScriptID 702 3) setCel: 12) ; theDrip
				((ScriptID 702 2) posn: 159 70) ; theSlime
				(= cycles 3)
			)
			(3
				((ScriptID 702 3) setCel: 13) ; theDrip
				((ScriptID 702 2) posn: 159 75) ; theSlime
				(= cycles 3)
			)
			(4
				((ScriptID 702 3) setCel: 14) ; theDrip
				((ScriptID 702 2) posn: 159 80) ; theSlime
				(= cycles 3)
			)
			(5
				(gLongSong2 number: 819 loop: -1 play:)
				((ScriptID 702 3) hide:) ; theDrip
				((ScriptID 702 2) posn: 159 85) ; theSlime
				(sewer status: 3)
				((ScriptID 702 2) setScript: (ScriptID 702 4)) ; theSlime, theSlimeScript
				(self dispose:)
			)
		)
	)
)

