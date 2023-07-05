;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 810)
(include sci.sh)
(use Main)
(use rgCastle)
(use Scaler)
(use Polygon)
(use Feature)
(use MoveFwd)
(use Motion)
(use Actor)
(use System)

(public
	rm810 0
	proc810_1 1
	beam 3
)

(local
	local0
	[local1 20] = [0 189 0 -10 319 -10 319 189 254 189 222 132 126 132 126 137 179 137 142 189]
	[local21 16] = [0 189 0 -10 319 -10 319 189 256 189 207 106 199 106 142 189]
	[local37 16] = [0 189 0 -10 319 -10 319 189 254 189 222 132 183 132 142 189]
	local53
	local54
	local55
)

(procedure (localproc_0)
	(if (gCurRoom obstacles:)
		((gCurRoom obstacles:) dispose:)
	)
	(switch local0
		(1
			(gCurRoom addObstacle: (mainPoly points: @local37 size: 8 yourself:))
		)
		(2
			(gCurRoom addObstacle: (mainPoly points: @local21 size: 8 yourself:))
		)
		(else
			(gCurRoom addObstacle: (mainPoly points: @local1 size: 10 yourself:))
		)
	)
)

(procedure (proc810_1)
	(gCurRoom drawPic: (gCurRoom picture:))
	(endHallway init: addToPic:)
	(gEgo init: show:)
	(beam cel: 0 show:)
	(chink show:)
	(localproc_0)
)

(instance rm810 of CastleRoom
	(properties
		noun 3
		picture 810
		style 10
		horizon 129
		walkOffEdge 1
	)

	(method (init)
		(switch gPrevRoomNum
			(781
				(= local0 1)
				(= local53 1)
				(gGlobalSound fadeTo: 810 -1)
			)
			(else
				(gEgo posn: 200 186)
				(= local0 3)
			)
		)
		(localproc_0)
		(super init: &rest)
		(walls init:)
		(gEgo init: reset:)
		(if (== gPrevRoomNum 800)
			(gEgo loop: 9 cel: 3)
		)
		(gEgo setScale: Scaler 100 70 190 129)
		((gEgo scaler:) doit:)
		(secretDoor init: hide:)
		(switch gPrevRoomNum
			(781
				(secretDoor cel: 3 show: stopUpd:)
				(gEgo
					normal: 0
					view: 781
					setScale: 0
					scaleX: 128
					scaleY: 128
					loop: 3
					cel: 9
					posn: 193 134
				)
				(self setScript: enterBedroom)
			)
			(else
				(gEgo posn: 200 186)
			)
		)
		(chink init: hide:)
		(beam init: hide:)
		(endHallway addToPic:)
		(if (not script)
			(gGame handsOn:)
		)
	)

	(method (doit &tmp temp0 temp1)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script 0)
			((& temp0 $4000)
				(if (!= local0 1)
					(self setScript: changeHallways 0 270)
				)
			)
			((= temp1 (gEgo edgeHit:))
				(switch temp1
					(3
						(if (== local0 3)
							(gCurRoom newRoom: 800)
						else
							(self setScript: changeHallways 0 180)
						)
					)
					(1
						(self setScript: changeHallways 0 0)
					)
				)
			)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 951)
		(DisposeScript 969)
	)
)

(instance changeHallways of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: register self)
			)
			(1
				(secretDoor startUpd:)
				(if register
					(gEgo setMotion: MoveFwd 15 self)
				else
					(= cycles 1)
				)
			)
			(2
				(beam setScript: 0)
				(if (== (gEgo heading:) 180)
					(gEgo posn: 200 133)
					(++ local0)
				else
					(gEgo posn: 200 188 setHeading: 0)
					(-- local0)
				)
				(++ state)
				(if (= register (== local0 3))
					(-- state)
					(gEgo posn: 156 135 hide: normal: 0)
				)
				(localproc_0)
				(chink hide:)
				(beam hide:)
				(secretDoor startUpd: hide:)
				(gCurRoom drawPic: 810 10)
				(endHallway addToPic:)
				(switch local0
					(2
						(chink show:)
						(beam show:)
					)
					(1
						(secretDoor show: stopUpd:)
					)
				)
				((gEgo scaler:) doit:)
				(= cycles 10)
			)
			(3
				(gEgo show: normal: 1 setMotion: MoveTo 184 135 self)
			)
			(4
				(= ticks 30)
			)
			(5
				(if (and (== local0 2) (not ((ScriptID 80 0) tstFlag: #rFlag3 16))) ; rgCastle
					(gMessager say: 1 0 4 0 self) ; "Alexander hears the sound of scratching coming from the other side of the wall."
				else
					(= cycles 2)
				)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterBedroom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local53
					(secretDoor cel: 3)
					(= cycles 1)
				else
					(secretDoor setCycle: End self)
				)
			)
			(1
				(gEgo
					normal: 0
					view: 781
					setScale: 0
					scaleX: 128
					scaleY: 128
					loop: 3
					cycleSpeed: 8
					posn: 193 134
				)
				(if local53
					(++ state)
					(gEgo cel: 9 setCycle: Beg self)
				else
					(gEgo cel: 0 setCycle: End self)
				)
			)
			(2
				(if (not ((ScriptID 80 0) tstFlag: #rFlag3 1024)) ; rgCastle
					((ScriptID 80 0) setFlag: #rFlag3 1024) ; rgCastle
					(gMessager say: 6 5 13 0 self) ; "Alexander sees...lots of black cloaks?"
				else
					(= cycles 1)
				)
			)
			(3
				(if local53
					(gEgo
						posn: (secretDoor approachX:) (secretDoor approachY:)
						oldScaleSignal: 0
						setScale: Scaler 100 70 190 129
						reset: 1
					)
					((gEgo scaler:) doit:)
					(= local53 0)
					(secretDoor setCycle: Beg self)
				else
					(gCurRoom newRoom: 781)
				)
			)
			(4
				(secretDoor stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance walls of Feature
	(properties
		noun 5
	)

	(method (onMe param1)
		(= local54 (and (InRect 142 64 157 156 param1) (== local0 2)))
		(return (not (& $0002 (OnControl CONTROL (param1 x:) (param1 y:)))))
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(if local54
					(= temp0 11)
				else
					(= temp0 12)
				)
				(gMessager say: noun theVerb temp0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance endHallway of View
	(properties
		onMeCheck 0
		view 810
	)

	(method (init)
		(= cel (if (== local0 3) 0 else local0))
		(switch cel
			(1
				(= x 203)
				(= y 101)
			)
			(2
				(= x 200)
				(= y 106)
			)
		)
		(= priority 0)
		(|= signal $6010)
		(super init: &rest)
	)
)

(instance chink of View
	(properties
		x 148
		y 167
		z 42
		noun 4
		approachX 164
		approachY 169
		view 810
		loop 1
		priority 10
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 1 5) ; Look, Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gCurRoom setScript: (ScriptID 811)) ; studyInset
			)
			(5 ; Do
				(gCurRoom setScript: (ScriptID 811)) ; studyInset
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beam of Prop
	(properties
		x 148
		y 167
		z 42
		onMeCheck 0
		view 810
		loop 2
		cel 8
		signal 16400
	)

	(method (doit)
		(if (not (& signal $0008))
			(if (and (<= (gEgo x:) 216) (>= 169 (gEgo y:) 165))
				(= cel (- (/ (- (gEgo x:) x) 7) 1))
				(= priority (- (gEgo priority:) 1))
			else
				(= priority (CoordPri y))
				(= cel 8)
			)
		)
		(super doit:)
	)

	(method (setScript param1)
		(super setScript: param1 &rest)
	)
)

(instance secretDoor of Prop
	(properties
		x 175
		y 127
		noun 6
		approachX 192
		approachY 134
		view 781
		loop 2
		signal 24592
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: enterBedroom)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mainPoly of Polygon
	(properties
		type PBarredAccess
	)
)

