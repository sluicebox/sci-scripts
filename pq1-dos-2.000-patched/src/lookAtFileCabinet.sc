;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 212)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(public
	lookAtFileCabinet 0
)

(instance lookAtFileCabinet of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 212)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bigFileDrawer init:)
				(= seconds 2)
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 5 0 3 4)
			)
			(2
				(HandsOff)
				(bigFileDrawer hide:)
				(= cycles 3)
			)
			(3
				(bigFileDrawer dispose: delete:)
				(self dispose:)
			)
		)
	)
)

(instance lookAtWallet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bigWallet init:)
				(= seconds 2)
			)
			(1
				(gMessager say: 29 1 0 0 self) ; "It's one of the licenses you confiscated at the stolen car bust."
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 5 0 3 4)
			)
			(3
				(HandsOff)
				(bigWallet hide:)
				(= cycles 3)
			)
			(4
				(HandsOn)
				(gTheIconBar disable: 5 0 3 4)
				(bigWallet dispose:)
				(self dispose:)
			)
		)
	)
)

(instance bigFolder of Prop
	(properties
		x 6
		y 245
		z 200
		noun 7
		view 183
		priority 15
		signal 16400
	)

	(method (handleEvent event)
		(if
			(and
				(gUser controls:)
				(gUser input:)
				(!= (event type:) evVERB)
				(!= (event message:) KEY_TAB)
				(not (self onMe: event))
				(not script)
				(not (event modifiers:))
			)
			(lookAtFolder cue:)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init:)
		(wallet init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd:)
	)

	(method (dispose)
		(wallet dispose:)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wallet of Prop
	(properties
		x 108
		y 303
		z 200
		view 149
		loop 2
		priority 15
		signal 16400
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (not (bigFolder script:))
					(bigFolder setScript: lookAtWallet)
				)
			)
			(4 ; Do
				(if (not (bigFolder script:))
					(bigFolder setScript: lookAtWallet)
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance bigWallet of Prop
	(properties
		x 147
		y 266
		z 200
		noun 29
		view 149
		loop 1
		priority 15
		signal 16400
	)

	(method (handleEvent event)
		(if
			(and
				(gUser controls:)
				(gUser input:)
				(!= (event type:) evVERB)
				(!= (event message:) KEY_TAB)
				(not (self onMe: event))
				(not script)
				(not (event modifiers:))
			)
			(lookAtWallet cue:)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance bigFileDrawer of Prop
	(properties
		x 150
		y 210
		z 200
		noun 30
		view 184
		priority 15
		signal 16400
	)

	(method (handleEvent event)
		(if
			(and
				(gUser controls:)
				(gUser input:)
				(!= (event type:) evVERB)
				(!= (event message:) KEY_TAB)
				(not (self onMe: event))
				(not script)
				(not (event modifiers:))
			)
			(lookAtFileCabinet cue:)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (init)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(self stopUpd:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not script)
					(self setScript: lookAtFolder)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lookAtFolder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (gEgo has: 13) ; Hoffman_File
					(gMessager say: 23 0 18 0 self) ; "You don't need any of the other files."
				else
					(++ state)
					(bigFolder init:)
					(= seconds 2)
				)
			)
			(1
				(HandsOn)
				(gTheIconBar disable: 5 0 3 4)
				(self dispose:)
			)
			(2
				(gMessager say: 7 4 0 0 self) ; "You look through the files until you find Hoffman, Marvin. You carefully take the file out and read it."
			)
			(3
				(if (not (gEgo has: 13)) ; Hoffman_File
					(gMessager say: 7 4 12 0 self) ; "You take Hoffman's file with you."
					(gEgo get: 13) ; Hoffman_File
					(SetScore 122 2)
				else
					(= cycles 1)
				)
			)
			(4
				(HandsOn)
				(gTheIconBar disable: 5 0 3 4)
			)
			(5
				(HandsOff)
				(bigFolder hide:)
				(= cycles 3)
			)
			(6
				(HandsOn)
				(gTheIconBar disable: 5 0 3 4)
				(bigFolder dispose:)
				(self dispose:)
			)
		)
	)
)

