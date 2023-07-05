;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 361)
(include sci.sh)
(use Main)
(use User)
(use System)

(public
	proc361_0 0
	proc361_1 1
)

(local
	local0
	local1
	local2
)

(procedure (proc361_0 param1 param2 &tmp [temp0 2] temp2 temp3)
	(= local0 (User controls:))
	(= local1 (User canInput:))
	(User canControl: 0 canInput: 0)
	(= local2 gAddToPics)
	(= gAddToPics 0)
	(gEgo setMotion: 0)
	(gCurRoom drawPic: param1)
	(gCast eachElementDo: #hide)
	(for ((= temp2 0)) (< temp2 (- argc 1)) ((++ temp2))
		([param2 temp2] init:)
		(extraList add: [param2 temp2])
	)
	(while (== ((= temp3 (Event new: 5)) type:) 0)
		(temp3 dispose:)
		(Wait gSpeed)
		(Animate (gCast elements:) 1)
		(gCast eachElementDo: #motionCue)
	)
	(temp3 dispose:)
	(proc361_1)
)

(procedure (proc361_1 &tmp [temp0 3])
	(gCurRoom drawPic: (gCurRoom picture:))
	(= gAddToPics local2)
	(extraList eachElementDo: #dispose eachElementDo: #delete release: dispose:)
	(gAddToPics doit:)
	(gCast eachElementDo: #show)
	(User canControl: local0 canInput: local1)
	(DisposeScript 361)
)

(instance extraList of Collect
	(properties)
)

