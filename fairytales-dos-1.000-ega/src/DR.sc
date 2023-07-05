;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 975)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Actor)

(public
	DR 0
	FakeInput 1
	FakeDir 2
	FakeKey 3
	FakeMouse 4
)

(procedure (FakeInput theTime &tmp event) ; UNUSED
	(if theTime
		(Print &rest #title LOOKUP_ERROR #time theTime)
	)
	(Format (View approachX:) &rest)
	((= event (View approachDist:)) type: 128)
	(Parse (View approachX:) event)
	(View said: event)
	(event quitGame:)
)

(procedure (FakeKey theKey &tmp event) ; UNUSED
	(View prev: ((View approachDist:) type: 4 message: theKey showStr:))
)

(procedure (FakeDir theDir &tmp event) ; UNUSED
	(View prev: ((View approachDist:) type: 64 message: theDir showStr:))
)

(procedure (FakeMouse theType theX theY theModifiers &tmp event) ; UNUSED
	((= event (View approachDist:))
		type: theType
		x: theX
		y: theY
		modifiers: (and (>= argc 3) theModifiers)
	)
	(SetCursor gTheCursor 1 (event x:) (event y:))
	(LocalToGlobal event)
	(View prev: event)
)

(instance DR of SRDialog
	(properties)

	(method (flags)
		(super flags:)
		(SetCursor gTheCursor 1 320 200)
		(self ticks: (ScriptID (+ gCurRoomNum global55)))
		(Dialog time: global60)
	)

	(method (doit)
		((View approachDist:)
			type: 0
			message: 0
			modifiers: 0
			y: 0
			x: 0
			claimed: 0
		)
		(super doit:)
	)

	(method (quitGame)
		(Dialog time: 0)
		(elements quitGame:)
		(DisposeScript (+ gCurRoomNum global55))
		(super quitGame:)
	)
)

