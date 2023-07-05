;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 302)
(include sci.sh)
(use Main)
(use Interface)
(use User)
(use System)

(public
	timeOut 0
)

(instance timeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global204 1)
				(gEgo setMotion: 0)
				(gCast eachElementDo: #hide)
				(User canControl: 0 canInput: 0)
				(DrawPic 991 8)
				(Timer setReal: self 5)
			)
			(1
				(= global120 (Print 302 0 #dispose)) ; "Your 24 hours are up! Unfortunately for you and Tamir, both Genesta and your father, King Graham, have died. It looks like you're destined to stay here in Tamir forever; AND evil will rule the land. What a shame!"
				(Timer setReal: self 15)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= global204 0)
				(= gDeathFlag 1)
			)
		)
	)
)

