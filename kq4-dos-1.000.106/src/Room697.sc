;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 697)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Game)
(use User)
(use System)

(public
	Room697 0
)

(instance Room697 of Rm
	(properties
		picture 697
		style 8
	)

	(method (init)
		(super init:)
		(= global204 1)
		(self setScript: showMessage)
	)
)

(instance showMessage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(= global120 (Print 697 0 #at -1 160 #dispose)) ; "Like a heavy blanket, darkness enfolds you."
				((Sound new:) number: 67 play: self)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= gCurRoomNum gPrevRoomNum)
				(= global204 0)
				(User canControl: 1 canInput: 1)
				(gCurRoom newRoom: global188)
			)
		)
	)
)

