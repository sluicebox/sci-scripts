;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2070)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use InvInitialize)
(use SaveManager)
(use n1111)
(use VMDMovie)
(use Actor)
(use System)

(public
	encounterCloseup 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(if (not local2)
		(= local2
			(cond
				(
					(and
						(== (proc70_9 67) 2000)
						(>= (global122 numPiecesDropped:) 2)
						(not (mod (global122 numPiecesDropped:) 2))
					)
					67
				)
				((== (proc70_9 59) 2000) 59)
				((== (proc70_9 71) 2000) 71)
				(else 0)
			)
		)
	)
)

(instance encounterCloseup of CloseupLocation
	(properties
		style 0
		exitStyle 13
	)

	(method (init)
		(= local0
			(switch global411
				(1 crabPassingBy)
				(2 crabDeath)
				(3 spiderDeath)
				(4
					(localproc_0)
					centipedeWMatrix
				)
				(5 centipedeWOMatrix)
				(6 wakefieldWLense)
				(7 ottoAtIceport1)
				(8 ottoAtIceport2)
				(9 ottoWaundering)
				(10 nicoleBlabbin)
				(else 0)
			)
		)
		(= picture 61)
		(super init: picture 0 0 0 backupExit)
		(if (OneOf global411 2 3)
			(self setScript: holdAFewAndDie)
		else
			(backupExit init:)
			(self setScript: showEncounter)
		)
	)

	(method (serialize param1 &tmp [temp0 6])
		(if (and argc param1)
			(super serialize: param1)
			(= local2 (SaveManager readWord:))
			(= local1 1)
		else
			(super serialize: param1)
			(SaveManager writeWord: local2)
		)
	)
)

(instance ottoAtIceport1 of VMDMovie
	(properties
		movieName 38811
		endPic 38819
	)

	(method (play)
		(if (not local1)
			(super play: &rest)
		else
			(gCurRoom drawPic: endPic)
		)
	)
)

(instance ottoAtIceport2 of VMDMovie
	(properties
		movieName 38851
		endPic 38859
	)

	(method (play)
		(if (not local1)
			(super play: &rest)
		else
			(gCurRoom drawPic: endPic)
		)
	)
)

(instance ottoWaundering of VMDMovie
	(properties
		movieName 38821
		endPic 38829
	)

	(method (play)
		(if (not local1)
			(super play: &rest)
		else
			(gCurRoom drawPic: endPic)
		)
		(SetFlag 55)
	)
)

(instance crabPassingBy of VMDMovie
	(properties
		movieName 2002
		endPic 12000
	)

	(method (play)
		(if (not local1)
			(super play: &rest)
		else
			(gCurRoom drawPic: endPic)
		)
	)
)

(instance centipedeWOMatrix of VMDMovie
	(properties
		movieName 2000
		begPic 2350
		endPic 2350
	)

	(method (play)
		(if (not local1)
			(super play: &rest)
		else
			(gCurRoom drawPic: endPic)
		)
	)
)

(instance centipedeWMatrix of VMDMovie
	(properties
		movieName 2001
		begPic 2352
		endPic 2352
	)

	(method (play)
		(if (not local1)
			(super play: &rest)
		else
			(gCurRoom drawPic: endPic)
		)
		(centipedeMatrix init: global117)
	)
)

(instance centipedeMatrix of View
	(properties
		x 436
		y 274
		view 2001
	)

	(method (init)
		(if (!= (proc70_9 local2) 2000)
			(return)
		)
		(super init: &rest)
		(&= signal $efff)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 local2 0)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wakefieldWLense of VMDMovie
	(properties
		movieName 38331
		endPic 38339
	)

	(method (play)
		(if (not local1)
			(if (<= global188 3)
				(= cacheSize 1000)
				(= preLoadPCT 80)
			)
			(super play: &rest)
		else
			(gCurRoom drawPic: endPic)
		)
		(proc70_1 106 0)
	)
)

(instance nicoleBlabbin of VMDMovie
	(properties
		movieName 38171
		endPic 38179
	)

	(method (play)
		(if (not local1)
			(super play: &rest)
			(SetFlag 311)
		else
			(gCurRoom drawPic: endPic)
		)
	)
)

(instance spiderDeath of VMDMovie
	(properties
		movieName 2003
		endPic 12015
	)

	(method (play)
		(if (not local1)
			(super play: &rest)
		else
			(gCurRoom drawPic: endPic)
		)
	)
)

(instance crabDeath of VMDMovie
	(properties
		movieName 2004
		endPic 12002
	)

	(method (play)
		(if (not local1)
			(super play: &rest)
		else
			(gCurRoom drawPic: endPic)
		)
	)
)

(instance holdAFewAndDie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gCurRoom exitStyle: 0)
				(= ticks 60)
			)
			(1
				(local0 play: self)
				(if local1
					(= cycles 1)
				)
			)
			(2
				((gCurRoom picObj:) showBlack: 0)
				(gCurRoom setScript: (ScriptID 97 0)) ; shiftToRed
			)
		)
	)
)

(instance showEncounter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(local0 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance backupExit of ExitFeature
	(properties
		nsBottom 289
		nsLeft 89
		nsRight 461
		nsTop 280
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setDirCursor: backupCursor)
			)
			(else
				(if gVMDMovie
					(gVMDMovie mouseDownAction: 1)
				)
				(gCurRoom pitch: 1)
			)
		)
	)
)

(instance backupCursor of View
	(properties
		cel 5
		view 600
	)
)

