;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 975)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use User)

(public
	DR 0
	FakeInput 1
	FakeDir 2
	FakeKey 3
	FakeMouse 4
)

(procedure (FakeInput theTime &tmp event) ; UNUSED
	(if theTime
		(Print &rest #title {Player types:} #time theTime)
	)
	(Format (User inputLineAddr:) &rest)
	((= event (User global24:)) type: 128)
	(Parse (User inputLineAddr:) event)
	(User said: event)
	(event dispose:)
)

(procedure (FakeKey theKey &tmp event) ; UNUSED
	(User handleEvent: ((User global24:) type: 4 message: theKey yourself:))
)

(procedure (FakeDir theDir &tmp event) ; UNUSED
	(User handleEvent: ((User global24:) type: 64 message: theDir yourself:))
)

(procedure (FakeMouse theType theX theY theModifiers &tmp event) ; UNUSED
	((= event (User global24:))
		type: theType
		x: theX
		y: theY
		modifiers: (and (>= argc 3) theModifiers)
	)
	(LocalToGlobal event)
	(SetCursor gTheCursor 1 (event x:) (event y:))
	(User handleEvent: event)
)

(instance DR of Rgn
	(properties)

	(method (init)
		(super init:)
		(SetCursor gTheCursor 1 320 200)
		(self setScript: (ScriptID (+ gCurRoomNum global55)))
		(Dialog time: global60)
	)

	(method (dispose)
		(Dialog time: 0)
		(script dispose:)
		(DisposeScript (+ gCurRoomNum global55))
		(super dispose:)
	)
)

