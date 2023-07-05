;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 853)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	thePuzzleBox 0
	cursorPause 1
)

(local
	local0
	local1
	local2
	local3 = 1
	local4
	[local5 8]
	[local13 10] = [{FLAGRO} {LIBERO} {REGALIS} {ARDENS} {DESIGNO} {BONITAS} {MEDICOR} {NEMORALIS} {CISTERNA} {TRANSFIGO}]
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
)

(procedure (localproc_0)
	(newCast eachElementDo: #setCel (= local2 0))
	(theRing setCel: 11)
	(= local3 1)
)

(procedure (localproc_1 param1)
	(Format @local1 853 0 (StrAt local4 local2)) ; "%c"
	(clickSound play:)
	(param1 setCel: 1)
	(if (!= (StrCmp @local0 @local1) 0)
		(= local3 0)
	)
	(if (and (== (++ local2) 10) (not local3))
		(gGame setScript: endIt)
	)
)

(procedure (localproc_2 param1 param2)
	(gCast eachElementDo: #perform hideMe)
	(= local25 gCast)
	(= local26 gFeatures)
	(= local27 gAddToPics)
	(= local28 gSounds)
	(= local29 gMouseDownHandler)
	(= local30 gKeyDownHandler)
	(= local31 gDirectionHandler)
	(= gMouseDownHandler
		(= gKeyDownHandler
			(= gDirectionHandler (= gCast (= gFeatures (= gAddToPics (= gSounds 0)))))
		)
	)
	(DrawPic param1 param2)
	((= gCast newCast) add:)
	((= gFeatures newFeatures) add:)
	((= gSounds newSounds) add:)
	((= gMouseDownHandler newMH) add: gCast gFeatures)
	((= gKeyDownHandler newKH) add: gCast gFeatures)
	((= gDirectionHandler newDH) add: gCast gFeatures)
)

(procedure (localproc_3)
	(gCast eachElementDo: #dispose eachElementDo: #delete release: dispose:)
	(gFeatures eachElementDo: #dispose release: dispose:)
	(gSounds eachElementDo: #dispose release: dispose:)
	(DisposeScript 806)
	(gMouseDownHandler dispose:)
	(gKeyDownHandler dispose:)
	(gDirectionHandler dispose:)
	(gCurRoom drawPic: (gCurRoom picture:))
	(= gCast local25)
	(= gFeatures local26)
	(= gSounds local28)
	((= gAddToPics local27) doit:)
	(= gMouseDownHandler local29)
	(= gKeyDownHandler local30)
	(= gDirectionHandler local31)
	(gCast eachElementDo: #perform showMe)
)

(instance newCast of EventHandler
	(properties)
)

(instance newFeatures of EventHandler
	(properties)
)

(instance newMH of EventHandler
	(properties)
)

(instance newKH of EventHandler
	(properties)
)

(instance newDH of EventHandler
	(properties)
)

(instance newSounds of EventHandler
	(properties)

	(method (pause param1)
		(self eachElementDo: #perform mightPause (if argc param1 else 1))
	)
)

(instance mightPause of Code
	(properties)

	(method (doit param1 param2)
		(if (not (& (param1 flags:) $0001))
			(param1 pause: param2)
		)
	)
)

(instance hideMe of Code
	(properties)

	(method (doit param1)
		(param1 z: (+ (param1 z:) 1000))
	)
)

(instance showMe of Code
	(properties)

	(method (doit param1)
		(param1 z: (- (param1 z:) 1000))
	)
)

(instance thePuzzleBox of Code
	(properties)

	(method (doit &tmp temp0)
		(if ((ScriptID 854) doit:) ; puzBoxMessage
			(DisposeScript 854)
			(DisposeScript 853)
			(HandsOn)
			(return)
		)
		(DisposeScript 854)
		(= local24 gTheCursor)
		(HandsOff)
		(gTheIconBar disable: 8)
		(User canInput: 1)
		(= local23 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(if (== (gTheIconBar curIcon:) (gTheIconBar at: 0))
			((gTheIconBar curIcon:) message: 11)
		)
		(localproc_2 803 10)
		(= global201 1)
		(for ((= temp0 0)) (< temp0 10) ((++ temp0))
			(if (== global144 temp0)
				(= local4 [local13 temp0])
				(break)
			)
		)
		(theR init:)
		(theN init:)
		(theA init:)
		(theM init:)
		(theF init:)
		(theI init:)
		(theO init:)
		(theB init:)
		(theE init:)
		(theS init:)
		(theD init:)
		(theL init:)
		(theT init:)
		(theG init:)
		(theC init:)
		(theRing init:)
		(theBox init:)
		(theHand init:)
		(everything init:)
		(gGame setCursor: 5 1 180 125)
	)

	(method (dispose)
		(localproc_3)
		(= gUseSortedFeatures local23)
		(gGame setCursor: local24 1 180 125)
		(if (== (gTheIconBar curIcon:) (gTheIconBar at: 0))
			((gTheIconBar curIcon:) message: 1)
		)
		(HandsOn)
		(gTheIconBar enable: 8 enable:)
		(= global201 0)
		(= global169 1)
		(DisposeScript 853)
	)
)

(instance everything of Feature
	(properties
		nsBottom 189
		nsRight 319
	)

	(method (handleEvent event)
		(event claimed: 1)
		(if (and (self onMe: event) (not (gGame script:)))
			(thePuzzleBox dispose:)
		)
	)
)

(instance theHand of Actor
	(properties
		x 180
		y 125
		view 182
		loop 1
		priority 14
		signal 26640
		illegalBits 0
	)

	(method (doit)
		(self posn: gMouseX (- gMouseY 10))
		(super doit:)
	)
)

(instance theBox of View
	(properties
		x 159
		y 128
		view 520
		loop 15
		priority 1
		signal 16401
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance theR of View
	(properties
		x 124
		y 76
		view 520
		signal 16385
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (not (gGame script:)) (!= cel 1))
				(Format @local0 853 1) ; "R"
				(localproc_1 self event)
				(if (and (== local2 7) local3)
					(gGame setScript: showFireRing)
				)
			)
		)
	)
)

(instance theN of View
	(properties
		x 141
		y 76
		view 520
		loop 1
		signal 16385
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (not (gGame script:)) (!= cel 1))
				(Format @local0 853 2) ; "N"
				(localproc_1 self event)
			)
		)
	)
)

(instance theA of View
	(properties
		x 158
		y 76
		view 520
		loop 2
		signal 16385
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (not (gGame script:)) (!= cel 1))
				(Format @local0 853 3) ; "A"
				(localproc_1 self event)
				(if (and (== local2 8) local3)
					(gGame setScript: showFireRing)
				)
			)
		)
	)
)

(instance theM of View
	(properties
		x 175
		y 76
		view 520
		loop 3
		signal 16385
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (not (gGame script:)) (!= cel 1))
				(Format @local0 853 4) ; "M"
				(localproc_1 self event)
			)
		)
	)
)

(instance theF of View
	(properties
		x 192
		y 76
		view 520
		loop 4
		signal 16385
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (not (gGame script:)) (!= cel 1))
				(Format @local0 853 5) ; "F"
				(localproc_1 self event)
			)
		)
	)
)

(instance theI of View
	(properties
		x 124
		y 91
		view 520
		loop 5
		signal 16385
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (not (gGame script:)) (!= cel 1))
				(Format @local0 853 6) ; "I"
				(localproc_1 self event)
			)
		)
	)
)

(instance theO of View
	(properties
		x 141
		y 91
		view 520
		loop 6
		signal 16385
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (not (gGame script:)) (!= cel 1))
				(Format @local0 853 7) ; "O"
				(localproc_1 self event)
				(if
					(and
						local3
						(or
							(== local2 7)
							(== local2 9)
							(and (== local2 6) (!= global144 6))
						)
					)
					(gGame setScript: showFireRing)
				)
			)
		)
	)
)

(instance theB of View
	(properties
		x 158
		y 91
		view 520
		loop 7
		signal 16385
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (not (gGame script:)) (!= cel 1))
				(Format @local0 853 8) ; "B"
				(localproc_1 self event)
			)
		)
	)
)

(instance theE of View
	(properties
		x 175
		y 91
		view 520
		loop 8
		signal 16385
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (not (gGame script:)) (!= cel 1))
				(Format @local0 853 9) ; "E"
				(localproc_1 self event)
			)
		)
	)
)

(instance theS of View
	(properties
		x 192
		y 91
		view 520
		loop 9
		signal 16385
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (not (gGame script:)) (!= cel 1))
				(Format @local0 853 10) ; "S"
				(localproc_1 self event)
				(if (and local3 (or (== local2 6) (== local2 7) (== local2 9)))
					(gGame setScript: showFireRing)
				)
			)
		)
	)
)

(instance theD of View
	(properties
		x 124
		y 106
		view 520
		loop 10
		signal 16385
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (not (gGame script:)) (!= cel 1))
				(Format @local0 853 11) ; "D"
				(localproc_1 self event)
			)
		)
	)
)

(instance theL of View
	(properties
		x 141
		y 106
		view 520
		loop 11
		signal 16385
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (not (gGame script:)) (!= cel 1))
				(Format @local0 853 12) ; "L"
				(localproc_1 self event)
			)
		)
	)
)

(instance theT of View
	(properties
		x 158
		y 106
		view 520
		loop 12
		signal 16385
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (not (gGame script:)) (!= cel 1))
				(Format @local0 853 13) ; "T"
				(localproc_1 self event)
			)
		)
	)
)

(instance theG of View
	(properties
		x 175
		y 106
		view 520
		loop 13
		signal 16385
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (not (gGame script:)) (!= cel 1))
				(Format @local0 853 14) ; "G"
				(localproc_1 self event)
			)
		)
	)
)

(instance theC of View
	(properties
		x 192
		y 106
		view 520
		loop 14
		signal 16385
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(event claimed: 1)
			(if (and (not (gGame script:)) (!= cel 1))
				(Format @local0 853 15) ; "C"
				(localproc_1 self event)
			)
		)
	)
)

(instance theRing of Actor
	(properties
		x 159
		y 97
		view 771
		cel 11
		priority 1
		signal 26640
	)
)

(instance showFireRing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 30)
			)
			(1
				(localproc_0)
				(= ticks 30)
			)
			(2
				(Say 1853 0 self) ; "The box clicks open. And inside...."
				(theRing setMotion: MoveTo (theRing x:) 60 self)
			)
			(3)
			(4
				(Say 1853 1 self) ; "...a magnificent ring with a fiery ruby set in flames of gold."
			)
			(5
				(Say 1853 2 self) ; "I'll slip the ring into my pouch."
				(SetScore (if (IsFlag 5) 10 else 100))
				(theRing hide:)
			)
			(6
				(gEgo get: 10 put: 12) ; fireRing, puzzleBox
				(Say 1853 3 self) ; "Good, now I can dispense with carrying this clumsy box around."
			)
			(7
				(Say 1853 4 self) ; "I'll hide it for now and give it to Alan after supper tonight. He'll enjoy studying it."
			)
			(8
				(SetFlag 101)
				(self dispose:)
				(thePuzzleBox dispose:)
			)
		)
	)
)

(instance endIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 30)
			)
			(1
				(localproc_0)
				(= ticks 30)
			)
			(2
				(Say 1853 5 self) ; "The box has reset itself. I have yet to find the right word to unlock it."
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance clickSound of Sound
	(properties
		flags 1
		number 521
	)
)

(instance cursorPause of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(thePuzzleBox doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 3)
			)
			(1
				(self dispose:)
			)
		)
	)
)

