;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 55)
(include sci.sh)
(use Main)
(use Interface)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm55 0
)

(local
	[local0 14] = [319 189 0 189 0 0 314 0 171 51 177 56 319 8]
	[local14 16] = [0 189 0 0 319 0 319 189 43 189 163 146 155 142 26 181]
	[local30 14] = [319 106 319 189 161 189 161 111 236 145 247 140 176 106]
	[local44 5] = [56 55 55 56 56]
	local49
)

(instance rm55 of Rm
	(properties
		picture 55
		style -32761
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(if (OneOf local49 1 2)
				(Print 55 0) ; "This is the ventilation system for the Deltaur. Around you, you can see ventilation shafts running in three different directions. A ladder provides access to all three directions. At the end of the shaft in the middle, you see a ventilation grill."
			else
				(Print 55 1) ; "This is the ventilation system for the Deltaur. Around you, you see the ventilation shafts running in two directions with a ladder leading from one shaft to the other."
			)
		else
			(super doVerb: &rest)
		)
	)

	(method (init)
		(self setRegions: 703) ; DeltaurRegion
		(upperPoly points: @local0 size: 7)
		(lowerPoly points: @local14 size: 8)
		(midPoly points: @local30 size: 7)
		(= local49 (if (== gPrevRoomNum 57) 2 else 1))
		(gFeatures add: ladder eachElementDo: #init doit:)
		(ladder approachVerbs: 3) ; Do
		(self addObstacle: midPoly)
		(gEgo
			normal: 0
			init:
			observeControl: -32768
			moveSpeed: (gGame egoMoveSpeed:)
			cycleSpeed: (gGame egoMoveSpeed:)
		)
		(if (OneOf local49 1 2)
			(vent init:)
			(if
				(or
					(and (== local49 1) (IsFlag 36))
					(and (== local49 2) (IsFlag 37))
				)
				(vent cel: 4 ignoreActors: 1 stopUpd:)
			else
				(vent cel: 0 ignoreActors: 0 stopUpd:)
			)
		else
			(vent dispose:)
		)
		(super init:)
		(self setScript: fromGrate)
		(if (!= (gLongSong number:) 509)
			(gLongSong number: 509 loop: -1 play:)
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script 0)
			((gEgo isBlocked:)
				(Print 55 2) ; "Ouch! That grill is stuck tight. Its going to take more than that impervious head of yours to knock it open."
				(gEgo setMotion: 0)
			)
		)
	)

	(method (dispose)
		(gLongSong fade:)
		(super dispose:)
	)
)

(instance fromGrate of Script
	(properties)

	(method (doit &tmp temp0)
		(cond
			((not (User canControl:)) 0)
			(
				(and
					(& (= temp0 (gEgo onControl: 1)) $0008)
					(vent cel:)
					(== state 2)
				)
				(client setScript: toGrate2)
			)
			((& temp0 $0010)
				(client setScript: ontoLadderFromMid)
			)
			((gEgo isStopped:)
				(gEgo setCycle: 0)
			)
			(
				(and
					(< 30 (gEgo heading:) 130)
					(not
						(and
							(gEgo cycler:)
							(== ((gEgo cycler:) cycleDir:) -1)
						)
					)
				)
				(gEgo setCycle: Rev)
			)
			(
				(and
					(not (< 30 (gEgo heading:) 130))
					(not
						(and
							(gEgo cycler:)
							(== ((gEgo cycler:) cycleDir:) 1)
						)
					)
				)
				(gEgo setCycle: Fwd)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(vent startUpd: ignoreActors: 1)
				(gEgo view: 38 setLoop: 3 posn: 257 148 setStep: 2 2)
				(if (> (gGame detailLevel:) 1)
					(self setScript: scurryRats1)
				else
					(= ticks 18)
				)
			)
			(1
				(gEgo setCycle: Fwd setMotion: PolyPath 223 133 self)
			)
			(2
				(vent ignoreActors: 0 stopUpd:)
				(HandsOn)
			)
		)
	)
)

(instance scurryRats1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rat1
					init:
					cel: 0
					setLoop: 14
					cycleSpeed: 3
					x: 202
					y: 38
					setCycle: End
				)
				(rat2
					init:
					cel: 0
					x: 116
					y: 162
					setLoop: 14
					cycleSpeed: 3
					setCycle: End
				)
				(rat3
					init:
					cel: 0
					setLoop: 15
					cycleSpeed: 3
					x: 105
					y: 161
					setCycle: End
				)
				(= seconds 3)
			)
			(1
				(rat1 setCycle: Beg)
				(rat2 setCycle: Beg)
				(rat3 setCycle: Beg self)
			)
			(2
				(rat1 setCycle: Walk setLoop: 12 setMotion: MoveTo 240 27)
				(rat2 setCycle: Walk setLoop: 12 setMotion: MoveTo 155 151)
				(rat3 setCycle: Walk setLoop: 13 setMotion: MoveTo 51 183 self)
			)
			(3
				(rat1 dispose:)
				(rat3 dispose:)
				(rat2 setLoop: 13 setMotion: MoveTo 51 183 self)
			)
			(4
				(rat2 dispose:)
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance scurryRats2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rat2
					init:
					cel: 0
					setLoop: 14
					x: 116
					y: 162
					cycleSpeed: 3
					setCycle: End
				)
				(rat3
					init:
					cel: 0
					setLoop: 15
					x: 105
					y: 161
					cycleSpeed: 3
					setCycle: End
				)
				(= seconds 2)
			)
			(1
				(rat2 setCycle: Beg)
				(rat3 setCycle: Beg self)
			)
			(2
				(rat2 setCycle: Walk setLoop: 12 setMotion: MoveTo 155 151)
				(rat3 setCycle: Walk setLoop: 13 setMotion: MoveTo 51 183 self)
			)
			(3
				(rat3 dispose:)
				(rat2 setLoop: 13 setMotion: MoveTo 51 183 self)
			)
			(4
				(rat2 dispose:)
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance scurryRats3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rat1
					init:
					cel: 0
					setLoop: 14
					cycleSpeed: 3
					x: 202
					y: 38
					setCycle: End
				)
				(= seconds 2)
			)
			(1
				(rat1 setCycle: Beg self)
			)
			(2
				(rat1 setCycle: Walk setLoop: 12 setMotion: MoveTo 240 27 self)
			)
			(3
				(rat1 dispose:)
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance randomRatLow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rat2 init: hide:)
				(= seconds (Random 10 20))
			)
			(1
				(rat2
					show:
					cel: 0
					setLoop: 12
					cycleSpeed: 3
					x: 47
					y: 185
					setCycle: Walk
					setMotion: MoveTo 131 155 self
				)
			)
			(2
				(rat2 setLoop: 14 cel: 0 setCycle: End)
				(= seconds 2)
			)
			(3
				(rat2 setCycle: Beg self)
			)
			(4
				(rat2 setCycle: Walk setLoop: 13 setMotion: MoveTo 47 185 self)
			)
			(5
				(rat2 dispose:)
				(self changeState: 0)
			)
		)
	)
)

(instance randomRatHi of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rat1 init: hide:)
				(= seconds (Random 10 20))
			)
			(1
				(rat1
					show:
					cel: 0
					setLoop: 13
					cycleSpeed: 3
					x: 236
					y: 30
					setCycle: Walk
					setMotion: MoveTo 180 44 self
				)
			)
			(2
				(rat1 setLoop: 15 cel: 0 setCycle: End)
				(= seconds 2)
			)
			(3
				(rat1 setCycle: Beg self)
			)
			(4
				(rat1 setLoop: 12 setCycle: Walk setMotion: MoveTo 236 30 self)
			)
			(5
				(rat1 dispose:)
				(self changeState: 0)
			)
		)
	)
)

(instance toGrate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(LoadMany rsSOUND 529 509)
				(Print 55 3) ; "With a mighty (wimpy) kick you manage to hurt your foot. However, the vent grill opens."
				(SetScore 3 163)
				(gEgo setLoop: 11 posn: 244 149 cel: 0 setCycle: End self)
			)
			(1
				(gSoundEffects number: 529 loop: 1 play:)
				(gEgo setPri: 14)
				(vent startUpd: setCycle: End self)
			)
			(2
				(if (== local49 1)
					(SetFlag 36)
					(gCurRoom newRoom: 54)
				else
					(SetFlag 37)
					(gCurRoom newRoom: 57)
				)
			)
		)
	)
)

(instance toGrate2 of Script
	(properties)

	(method (doit &tmp temp0)
		(cond
			((not (User canControl:)) 0)
			((gEgo isStopped:)
				(gEgo setCycle: 0)
			)
			(
				(and
					(< 30 (gEgo heading:) 130)
					(not
						(and
							(gEgo cycler:)
							(== ((gEgo cycler:) cycleDir:) -1)
						)
					)
				)
				(gEgo setCycle: Rev)
			)
			(
				(and
					(not (< 30 (gEgo heading:) 130))
					(not
						(and
							(gEgo cycler:)
							(== ((gEgo cycler:) cycleDir:) 1)
						)
					)
				)
				(gEgo setCycle: Fwd)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(vent startUpd: ignoreActors: 1)
				(gEgo setPri: 14 setMotion: MoveTo 255 151 self)
			)
			(1
				(if (== local49 1)
					(gCurRoom newRoom: 54)
				else
					(gCurRoom newRoom: 57)
				)
			)
		)
	)
)

(instance toLowVent of Script
	(properties)

	(method (doit &tmp temp0)
		(cond
			((not (User canControl:)) 0)
			((gEgo isStopped:)
				(gEgo setCycle: 0)
			)
			(
				(and
					(< 190 (gEgo heading:) 290)
					(not
						(and
							(gEgo cycler:)
							(== ((gEgo cycler:) cycleDir:) -1)
						)
					)
				)
				(gEgo setCycle: Rev)
			)
			(
				(and
					(not (< 190 (gEgo heading:) 290))
					(not
						(and
							(gEgo cycler:)
							(== ((gEgo cycler:) cycleDir:) 1)
						)
					)
				)
				(gEgo setCycle: Fwd)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local49 (mod (++ local49) 4))
				(HandsOff)
				(gCurRoom drawPic: [local44 local49])
				(if (OneOf local49 1 2)
					(vent init:)
					(if
						(or
							(and (== local49 1) (IsFlag 36))
							(and (== local49 2) (IsFlag 37))
						)
						(vent cel: 4 ignoreActors: 1 stopUpd:)
					else
						(vent cel: 0 ignoreActors: 0 stopUpd:)
					)
				else
					(vent dispose:)
				)
				((gCurRoom obstacles:) delete: upperPoly add: lowerPoly)
				(gEgo setCycle: 0 posn: 64 180)
				(if (> (gGame detailLevel:) 1)
					(self setScript: scurryRats3)
				else
					(= ticks 18)
				)
			)
			(1
				(gEgo
					setCycle: (if (== (gEgo loop:) 1) Rev else Fwd)
					setMotion: MoveTo 104 167 self
				)
			)
			(2
				(crawlLow start: 3)
				(client setScript: crawlLow)
			)
		)
	)
)

(instance toHiVent of Script
	(properties)

	(method (doit &tmp temp0)
		(cond
			((not (User canControl:)) 0)
			((gEgo isStopped:)
				(gEgo setCycle: 0)
			)
			(
				(and
					(< 30 (gEgo heading:) 130)
					(not
						(and
							(gEgo cycler:)
							(== ((gEgo cycler:) cycleDir:) -1)
						)
					)
				)
				(gEgo setCycle: Rev)
			)
			(
				(and
					(not (< 30 (gEgo heading:) 130))
					(not
						(and
							(gEgo cycler:)
							(== ((gEgo cycler:) cycleDir:) 1)
						)
					)
				)
				(gEgo setCycle: Fwd)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local49
					(-- local49)
				else
					(= local49 4)
				)
				(gCurRoom drawPic: [local44 local49])
				(if (OneOf local49 1 2)
					(vent init:)
					(if
						(or
							(and (== local49 1) (IsFlag 36))
							(and (== local49 2) (IsFlag 37))
						)
						(vent cel: 4 ignoreActors: 1 stopUpd:)
					else
						(vent cel: 0 ignoreActors: 0 stopUpd:)
					)
				else
					(vent dispose:)
				)
				((gCurRoom obstacles:) delete: lowerPoly add: upperPoly)
				(gEgo setCycle: 0 posn: 238 34)
				(if (> (gGame detailLevel:) 1)
					(self setScript: scurryRats2)
				else
					(= ticks 18)
				)
			)
			(1
				(if (== (gEgo loop:) 2)
					(gEgo setCycle: Rev)
				else
					(gEgo setCycle: Fwd)
				)
				(gEgo setMotion: MoveTo 212 39 self)
			)
			(2
				(crawlHigh start: 4)
				(client setScript: crawlHigh)
			)
		)
	)
)

(instance onLadder of Script
	(properties)

	(method (doit)
		(cond
			((not (User canControl:)) 0)
			((and (== (gCurRoom curPic:) 55) (< 60 (gEgo heading:) 120))
				(client setScript: crawlMid)
			)
			((> (gEgo y:) 121)
				(client setScript: crawlLow)
			)
			((< (gEgo y:) 121)
				(client setScript: crawlHigh)
			)
		)
		(super doit:)
	)
)

(instance ontoLadderFromMid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((gCurRoom obstacles:) delete: midPoly)
				(gEgo setStep: 1 4)
				(if (gEgo loop:)
					(gEgo setCycle: Fwd setMotion: MoveTo 172 109 self)
				else
					(gEgo setCycle: Rev setMotion: MoveTo 160 106 self)
				)
			)
			(1
				(if (gEgo loop:)
					(gEgo setLoop: 10 cel: 0 setCycle: End self)
				else
					(gEgo setLoop: 9 cel: 6 setCycle: Beg self)
				)
			)
			(2
				(gEgo setLoop: 4 cel: 0 posn: 158 121)
				(HandsOn)
				(client setScript: onLadder)
			)
		)
	)
)

(instance ontoLadderFromBottom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((gCurRoom obstacles:) delete: lowerPoly)
				(if (== (gEgo loop:) 2)
					(gEgo setMotion: MoveTo 138 149 self)
				else
					(gEgo setMotion: MoveTo 155 149 self)
				)
			)
			(1
				(gEgo
					posn: 155 147
					setLoop: 5
					cel:
						(if (== (gEgo loop:) 2)
							4
						else
							(gEgo lastCel:)
						)
					setCycle: Beg self
				)
			)
			(2
				(gEgo posn: 159 141 setLoop: 4 cel: 0 setCycle: End self)
			)
			(3
				(gEgo setLoop: 4 cel: 0 posn: 158 121)
				(HandsOn)
				(client setScript: onLadder)
			)
		)
	)
)

(instance ontoLadderFromTopBackwards of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((gCurRoom obstacles:) delete: upperPoly)
				(gEgo setLoop: 2 setMotion: MoveTo 164 52 self)
			)
			(1
				(gEgo
					setLoop: 7
					cel: (gEgo lastCel:)
					posn: 164 52
					setCycle: Beg self
				)
			)
			(2
				(gEgo setLoop: 4 cel: 1 posn: 160 104 setCycle: Beg self)
			)
			(3
				(gEgo
					posn: 158 121
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(4
				(HandsOn)
				(client setScript: onLadder)
			)
		)
	)
)

(instance ontoLadderFromTopForwards of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((gCurRoom obstacles:) delete: upperPoly)
				(gEgo setCycle: Fwd setMotion: MoveTo 164 52 self)
			)
			(1
				(gEgo setLoop: 5 cel: 8 posn: 164 52 setCycle: CT 4 1 self)
			)
			(2
				(gEgo setLoop: 7 cel: 7 posn: 168 57 setCycle: Beg self)
			)
			(3
				(gEgo setLoop: 4 cel: 1 posn: 160 104 setCycle: Beg self)
			)
			(4
				(gEgo
					posn: 158 121
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(5
				(HandsOn)
				(client setScript: onLadder)
			)
		)
	)
)

(instance crawlHigh of Script
	(properties)

	(method (doit &tmp temp0)
		(cond
			((not (User canControl:)) 0)
			((& (= temp0 (gEgo onControl: 1)) $0200)
				(rat2 setScript: 0)
				(rat2 dispose: 0)
				(client setScript: toLowVent)
			)
			((& temp0 $0400)
				(rat2 setScript: 0)
				(rat2 dispose: 0)
				(client
					setScript:
						(if (gEgo loop:)
							ontoLadderFromTopBackwards
						else
							ontoLadderFromTopForwards
						)
				)
			)
			((gEgo isStopped:)
				(gEgo setCycle: 0)
			)
			((< 160 (gEgo heading:) 340)
				(cond
					((== (gEgo loop:) 1)
						(if
							(not
								(and
									(gEgo cycler:)
									(== ((gEgo cycler:) cycleDir:) 1)
								)
							)
							(gEgo setCycle: Fwd)
						)
					)
					(
						(not
							(and
								(gEgo cycler:)
								(== ((gEgo cycler:) cycleDir:) -1)
							)
						)
						(gEgo setCycle: Rev)
					)
				)
			)
			((not (< 160 (gEgo heading:) 340))
				(cond
					((== (gEgo loop:) 1)
						(if
							(not
								(and
									(gEgo cycler:)
									(== ((gEgo cycler:) cycleDir:) -1)
								)
							)
							(gEgo setCycle: Rev)
						)
					)
					(
						(not
							(and
								(gEgo cycler:)
								(== ((gEgo cycler:) cycleDir:) 1)
							)
						)
						(gEgo setCycle: Fwd)
					)
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((gCurRoom obstacles:) add: upperPoly)
				(gEgo setLoop: 4 cel: 0 setCycle: End self)
			)
			(1
				(gEgo cel: 0 posn: 160 104 setCycle: CT 1 1 self)
			)
			(2
				(gEgo setLoop: 7 cel: 0 posn: 170 56 setCycle: End self)
			)
			(3
				(gEgo
					setLoop: 2
					setStep: 2 2
					setCycle: Fwd
					setMotion: MoveTo 190 46 self
				)
			)
			(4
				(if (> (gGame detailLevel:) 1)
					(rat2 setScript: randomRatLow)
				)
				(= start 0)
				(HandsOn)
			)
		)
	)
)

(instance crawlLow of Script
	(properties)

	(method (doit &tmp temp0)
		(cond
			((not (User canControl:)) 0)
			((& (= temp0 (gEgo onControl: 1)) $0002)
				(rat1 setScript: 0)
				(rat1 dispose: 0)
				(client setScript: toHiVent)
			)
			((& temp0 $0004)
				(rat1 setScript: 0)
				(rat1 dispose: 0)
				(client setScript: ontoLadderFromBottom)
			)
			((gEgo isStopped:)
				(gEgo setCycle: 0)
			)
			((< 160 (gEgo heading:) 340)
				(cond
					((== (gEgo loop:) 1)
						(if
							(not
								(and
									(gEgo cycler:)
									(== ((gEgo cycler:) cycleDir:) 1)
								)
							)
							(gEgo setCycle: Fwd)
						)
					)
					(
						(not
							(and
								(gEgo cycler:)
								(== ((gEgo cycler:) cycleDir:) -1)
							)
						)
						(gEgo setCycle: Rev)
					)
				)
			)
			((not (< 160 (gEgo heading:) 340))
				(cond
					((== (gEgo loop:) 1)
						(if
							(not
								(and
									(gEgo cycler:)
									(== ((gEgo cycler:) cycleDir:) -1)
								)
							)
							(gEgo setCycle: Rev)
						)
					)
					(
						(not
							(and
								(gEgo cycler:)
								(== ((gEgo cycler:) cycleDir:) 1)
							)
						)
						(gEgo setCycle: Fwd)
					)
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((gCurRoom obstacles:) add: lowerPoly)
				(gEgo posn: 159 141 setLoop: 4 cel: 4 setCycle: Beg self)
			)
			(1
				(gEgo posn: 155 147 setLoop: 5 cel: 0 setCycle: End self)
			)
			(2
				(gEgo
					setLoop: 1
					cel: 6
					posn: 155 149
					setCycle: Fwd
					setStep: 2 2
					setMotion: MoveTo 128 158 self
				)
			)
			(3
				(if (> (gGame detailLevel:) 1)
					(rat1 setScript: randomRatHi)
				)
				(= start 0)
				(HandsOn)
			)
		)
	)
)

(instance crawlMid of Script
	(properties)

	(method (doit &tmp temp0)
		(cond
			((not (User canControl:)) 0)
			((and (& (= temp0 (gEgo onControl: 1)) $0008) (vent cel:))
				(rat1 setScript: 0)
				(rat1 dispose: 0)
				(rat2 setScript: 0)
				(rat2 dispose: 0)
				(client setScript: toGrate2)
			)
			((& temp0 $0010)
				(rat1 setScript: 0)
				(rat2 setScript: 0)
				(rat1 dispose: 0)
				(rat2 dispose: 0)
				(client setScript: ontoLadderFromMid)
			)
			((gEgo isStopped:)
				(gEgo setCycle: 0)
			)
			(
				(and
					(< 30 (gEgo heading:) 130)
					(not
						(and
							(gEgo cycler:)
							(== ((gEgo cycler:) cycleDir:) 1)
						)
					)
				)
				(gEgo setCycle: Fwd)
			)
			(
				(and
					(not (< 30 (gEgo heading:) 130))
					(not
						(and
							(gEgo cycler:)
							(== ((gEgo cycler:) cycleDir:) -1)
						)
					)
				)
				(gEgo setCycle: Rev)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((gCurRoom obstacles:) add: midPoly)
				(gEgo posn: 161 108 setLoop: 9 cel: 0 setCycle: End self)
			)
			(1
				(gEgo
					setLoop: 0
					cel: 0
					posn: 162 108
					setCycle: Fwd
					setStep: 2 2
					setMotion: MoveTo 183 117 self
				)
			)
			(2
				(if (> (gGame detailLevel:) 1)
					(rat2 setScript: randomRatLow)
					(rat1 setScript: randomRatHi)
				)
				(HandsOn)
			)
		)
	)
)

(instance upperPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance lowerPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance midPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance vent of Prop
	(properties
		x 278
		y 144
		description {vent grill}
		view 154
		loop 11
		priority 13
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (and (== cel 0) (& (gEgo onControl: 1) $0008))
					(gCurRoom setScript: toGrate)
				else
					(Print 55 4) ; "You are not close enough to the vent grill to open it."
				)
			)
			(2 ; Look
				(if (not cel)
					(Print 55 5) ; "This is a vent grill which appears to lead to another room on the Deltaur. It appears to be closed."
				else
					(Print 55 6) ; "This is the vent grill you pried open to get in here."
				)
			)
			(11 ; Taste
				(Print 55 7) ; "Nothing like a nice tongue load of dust."
			)
			(12 ; Smell
				(Print 55 8) ; "It smells dusty."
			)
			(4 ; Inventory
				(Print 55 9) ; "That doesn't help."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rat1 of Actor
	(properties
		x 202
		y 38
		description {rat}
		lookStr {No ship would be complete without official ship rats.}
		view 38
		loop 2
		signal 16384
		cycleSpeed 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 55 10) ; "The little buggers are too fast."
			)
			(2 ; Look
				(Print 55 10) ; "The little buggers are too fast."
			)
			(11 ; Taste
				(Print 55 10) ; "The little buggers are too fast."
			)
			(12 ; Smell
				(Print 55 10) ; "The little buggers are too fast."
			)
			(4 ; Inventory
				(Print 55 10) ; "The little buggers are too fast."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rat2 of Actor
	(properties
		x 116
		y 162
		description {rat}
		lookStr {No ship would be complete without official ship rats.}
		view 38
		loop 2
		signal 16384
		cycleSpeed 3
	)

	(method (doVerb theVerb)
		(rat1 doVerb: theVerb &rest)
	)
)

(instance rat3 of Actor
	(properties
		x 105
		y 161
		description {rat}
		lookStr {No ship would be complete without official ship rats.}
		view 38
		loop 3
		signal 16384
		cycleSpeed 3
	)

	(method (doVerb theVerb)
		(rat1 doVerb: theVerb &rest)
	)
)

(instance ladder of Feature
	(properties
		x 72
		y 42
		description {ladder}
		sightAngle 0
		onMeCheck 16384
		approachX 160
		approachY 90
		lookStr {The ladder seems to provide access to vent shafts above and below this one.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 55 11) ; "It's just a ladder. Go crazy."
			)
			(2 ; Look
				(Print 55 12) ; "It's an interesting device. Two upright parallel tubes connect many shorter rungs spaced at regular intervals allowing one to change their elevation in a positive or negative direction."
			)
			(12 ; Smell
				(Print 55 13) ; "It smells like boot bottoms."
			)
			(11 ; Taste
				(Print 55 14) ; "It tastes like smoething that might have been stuck to boot bottoms."
			)
			(4 ; Inventory
				(Print 55 15) ; "That's not effective here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

