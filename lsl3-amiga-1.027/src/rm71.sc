;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 71)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm71 0
	React 1
	PrintL 2
	PrintP 3
)

(local
	takeCycles
	[titleStr 30]
	[nameStr 5]
	[responseBuffer 300]
)

(procedure (React how howLong txt)
	(if (< argc 1)
		(= how 0)
	)
	(if (> argc 1)
		(= takeCycles howLong)
	else
		(= takeCycles 22)
	)
	(if (> argc 2)
		(Print @txt)
	)
	(if (== (RegionScript state:) 0)
		(RegionScript changeState: 1)
	)
	(EyeScript
		changeState:
			(switch how
				(4 5)
				(7 2)
				(else 3)
			)
	)
	(EyelidScript
		changeState:
			(switch how
				(1 6)
				(2 6)
				(3 8)
				(6 6)
				(7 6)
				(else 0)
			)
	)
	(NoseScript
		changeState:
			(switch how
				(2 4)
				(3 4)
				(5 4)
				(6 5)
				(7 5)
				(else 0)
			)
	)
	(MouthScript
		changeState:
			(switch how
				(2 2)
				(4 5)
				(5 2)
				(3 2)
				(6 1)
				(7 8)
				(else 0)
			)
	)
)

(procedure (PrintL)
	(Print &rest #at -1 20 #title {You say...} #width 222 #mode 1)
)

(procedure (PrintP)
	(Format @responseBuffer &rest)
	(if (== (RegionScript state:) 0)
		(RegionScript changeState: 1)
	)
)

(instance rm71 of Rgn
	(properties)

	(method (init)
		(Load rsSCRIPT 969)
		(super init:)
		(HandsOff)
		(User canInput: 1)
		(= responseBuffer 0)
		(Format
			@titleStr
			(switch gCurRoomNum
				(455 {Patti says...})
				(265 {Tawni says...})
				(395 {Bambi says...})
				(325 {Suzi says...})
				(335 {Dale says...})
				(435 {Cherri says...})
				(else {Carlos says...})
			)
		)
		(Format
			@nameStr
			(switch gCurRoomNum
				(455 {Patti})
				(265 {Tawni})
				(395 {Bambi})
				(325 {Suzi})
				(335 {Dale})
				(435 {Cherri})
				(else {Carlos})
			)
		)
		(= gOldGameSpeed (gGame setSpeed: 6))
		(if (!= gCurRoomNum 325)
			(gMusic number: gCurRoomNum loop: gBgMusicLoops play:)
		)
		(self setScript: RegionScript)
		(aEyeWest init:)
		(aEyeEast init:)
		(aEyelidWest init:)
		(aEyelidEast init:)
		(aNose init:)
		(aMouth init:)
	)

	(method (notify whom x1 y1)
		(switch whom
			(1
				(aEyeWest posn: x1 y1)
			)
			(2
				(aEyeEast posn: x1 y1)
			)
			(3
				(aEyelidWest posn: x1 y1)
			)
			(4
				(aEyelidEast posn: x1 y1)
			)
			(5
				(aNose posn: x1 y1)
			)
			(6
				(aMouth posn: x1 y1)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(gGame setSpeed: gOldGameSpeed)
		(if (!= gCurRoomNum 325)
			(gMusic fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance RegionScript of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event &tmp theObj)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'embrace')
				(Print 71 0) ; "How you'd love to sneak a little peck onto that gorgeous cheek!"
			)
			((Said 'eat')
				(Printf 71 1 gEgoName) ; "%s! Just think where that tongue of yours has been!"
			)
			((Said 'drain/cloth,skirt,dress')
				(Print 71 2) ; "That may be possible if you'd play the game better!"
			)
			(
				(or
					(Said 'eat,fuck/me')
					(Said 'clit,shit,leak,fuck,fart,boob,ass,asshole')
				)
				(Printf 71 3 gEgoName) ; "My, %s! You certainly have a charming way with the opposite sex."
			)
			((Said '/casino')
				(PrintL 71 4) ; "Do you enjoy gambling at the casino?"
				(PrintP 71 5) ; "Are you crazy? Nobody ever wins there!"
			)
			((Said '/entertainer,maller,bambi,attorney,dale,cheri')
				(Printf 71 6 @nameStr) ; "Where? You're talking to %s, remember?"
			)
			((Said 'talk')
				(Printf 71 7 gEgoName) ; "Just say what you wish to say, %s."
			)
			((Said '/name')
				(PrintL 71 8) ; "What's your name, baby?"
				(PrintP 71 9) ; "You said your name, then I said my name. Don't you remember?"
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(= cycles 22)
			)
			(2
				(if responseBuffer
					(Print @responseBuffer #at -1 111 #title @titleStr #width 222 #mode 1)
					(= responseBuffer 0)
				)
				(= state 0)
			)
			(3
				; COMPILER BUG: GAME WILL CRASH
			)
		)
	)
)

(instance EyeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 9))
				(if (Random 0 5)
					(= state 2)
				)
			)
			(1
				(aEyeWest setCycle: End)
				(aEyeEast setCycle: End self)
				(= cycles 0)
				(= state 3)
			)
			(2
				(aEyeWest setCycle: End)
				(aEyeEast setCycle: Beg self)
				(= cycles 0)
				(= state 3)
			)
			(3
				(= cycles 0)
				(aEyeWest
					setCycle:
						CT
						2
						(cond
							((> 2 (aEyeWest cel:)) 1)
							((< 2 (aEyeWest cel:)) -1)
						)
				)
				(aEyeEast
					setCycle:
						CT
						2
						(cond
							((> 2 (aEyeEast cel:)) 1)
							((< 2 (aEyeEast cel:)) -1)
						)
						self
				)
			)
			(4
				(= cycles takeCycles)
			)
			(5
				(aEyeWest setCycle: Beg)
				(aEyeEast setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance EyelidScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 11 33))
			)
			(1
				(aEyelidWest setCycle: End)
				(aEyelidEast setCycle: End self)
			)
			(2
				(aEyelidWest setCycle: Beg)
				(aEyelidEast setCycle: Beg self)
				(= state -1)
			)
			(3
				(= cycles 0)
				(aEyelidWest setCycle: End self)
				(aEyelidEast setCel: 1)
			)
			(4
				(= cycles takeCycles)
			)
			(5
				(aEyelidWest setCycle: Beg self)
				(= state -1)
			)
			(6
				(aEyelidWest setCel: 0)
				(aEyelidEast setCel: 0)
				(= cycles takeCycles)
				(= state 0)
			)
			(7
				(aEyelidWest setCel: 1)
				(aEyelidEast setCel: 1)
				(= cycles takeCycles)
				(= state 0)
			)
			(8
				(aEyelidWest setCel: 2)
				(aEyelidEast setCel: 2)
				(= cycles takeCycles)
				(= state 0)
			)
		)
	)
)

(instance NoseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 22 66))
			)
			(1
				(aNose setCycle: End self)
				(= cycles 0)
			)
			(2
				(= cycles (Random 10 20))
			)
			(3
				(aNose setCycle: Beg self)
				(= cycles 0)
				(= state -1)
			)
			(4
				(aNose setCycle: End)
				(= cycles takeCycles)
				(= state 2)
			)
			(5
				(aNose setCycle: Beg)
				(= cycles takeCycles)
				(= state 0)
			)
		)
	)
)

(instance MouthScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aMouth setLoop: 6 setCel: 0)
				(= cycles 0)
			)
			(1
				(aMouth setLoop: 5 cel: 0 setCycle: End self)
				(= cycles 0)
				(= state -1)
			)
			(2
				(aMouth setLoop: 6 cel: 0 setCycle: End self)
				(= cycles 0)
			)
			(3
				(= cycles takeCycles)
			)
			(4
				(aMouth setCycle: Beg self)
				(= state -1)
			)
			(5
				(aMouth setLoop: 7 cel: 0 setCycle: End self)
				(= cycles 0)
			)
			(6
				(= cycles 10)
			)
			(7
				(aMouth setCycle: Beg self)
				(= state -1)
			)
			(8
				(aMouth setLoop: 8 cel: 0 setCycle: End self)
				(= cycles 0)
				(= state -1)
			)
		)
	)
)

(instance aEyeWest of Prop
	(properties)

	(method (init)
		(self view: gCurRoomNum setPri: 2 setScript: EyeScript)
		(super init:)
	)
)

(instance aEyeEast of Prop
	(properties
		loop 1
	)

	(method (init)
		(self view: gCurRoomNum setPri: 3)
		(super init:)
	)
)

(instance aEyelidWest of Prop
	(properties
		loop 2
	)

	(method (init)
		(self view: gCurRoomNum ignoreActors: setPri: 5 setScript: EyelidScript)
		(super init:)
	)
)

(instance aEyelidEast of Prop
	(properties
		loop 3
	)

	(method (init)
		(self view: gCurRoomNum ignoreActors: setPri: 6)
		(super init:)
	)
)

(instance aNose of Prop
	(properties
		loop 4
	)

	(method (init)
		(self view: gCurRoomNum cycleSpeed: 2 setPri: 9 setScript: NoseScript)
		(super init:)
	)
)

(instance aMouth of Prop
	(properties
		loop 6
	)

	(method (init)
		(self view: gCurRoomNum cycleSpeed: 1 setPri: 10 setScript: MouthScript)
		(super init:)
	)
)

