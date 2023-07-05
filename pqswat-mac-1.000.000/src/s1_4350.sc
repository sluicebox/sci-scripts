;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4350)
(include sci.sh)
(use Main)
(use PQRoom)
(use Motion)
(use Actor)
(use System)

(public
	s1_4350 0
)

(instance s1_4350 of PQRoom
	(properties)

	(method (init)
		(super init: &rest)
		(if (IsFlag 76)
			(ClearFlag 76)
			(self drawPic: 4010 setScript: establishShot)
		else
			(self drawPic: 4350 setScript: enterPlot2)
		)
	)
)

(instance establishShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsAUDIO 40101)
				(Lock rsAUDIO 40101 1)
				(gBackMusic number: 40101 loop: -1 play:)
				(= cycles 2)
			)
			(1
				((gSwatInterface curSwatButn:) doVerb:)
				(= cycles 1)
			)
			(2
				(gMessager say: 1 0 1 0 self) ; "Barricaded female. North Hollywood area. 339 Westcott Avenue. Shots fired. Code 3."
			)
			(3
				(gMessager say: 0 0 2 0 self) ; "This is Sgt. Pruett with the LAPD. Lucy, if you can hear me, I want you to answer the telephone. We're here to help you. Please pick up the telephone and talk with me."
			)
			(4
				(if (IsFlag 77)
					(gCurRoom newRoom: 4051) ; s1_405
				else
					(gCurRoom setScript: watchMovie)
				)
			)
		)
	)
)

(instance watchMovie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCast contains: (ScriptID 16)) ; aniProp
					((ScriptID 16) dispose:) ; aniProp
				)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 4000 180 70 self 1)
			)
			(2
				(= cycles 2)
			)
			(3
				(gCurRoom newRoom: 4000) ; s1_4000
			)
		)
	)
)

(instance enterPlot2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Lock rsAUDIO 40102 0)
				(Load rsAUDIO 40103)
				(Lock rsAUDIO 40103 1)
				(gBackMusic number: 0 stop:)
				(gBackMusic number: 40103 loop: -1 play:)
				(UnLoad 141 40102)
				(linedUpOfficers setPri: 1 init: setCycle: CT 54 1 self)
				(gMessager say: 0 0 4 0) ; "Sierra One reporting; side one is clear of threat."
			)
			(1
				(gMessager say: 0 0 5 1) ; "Hold it"
				(= cycles 1)
			)
			(2
				(fenceJumpers setPri: 1 init: setCycle: End)
				(linedUpOfficers setCycle: CT 70 1 self)
			)
			(3
				(gMessager say: 0 0 5 2) ; "Ready to move?"
				(= cycles 1)
			)
			(4
				(linedUpOfficers setCycle: CT 111 1 self)
			)
			(5
				(gMessager say: 0 0 5 3) ; "Move!!"
				(= cycles 1)
			)
			(6
				(linedUpOfficers setCycle: CT 145 1 self)
			)
			(7
				(gCurRoom newRoom: 4050) ; s1_4050
			)
		)
	)
)

(instance linedUpOfficers of Actor
	(properties
		x 575
		y 262
		view 43500
	)
)

(instance fenceJumpers of Actor
	(properties
		y 182
		view 43501
	)
)

