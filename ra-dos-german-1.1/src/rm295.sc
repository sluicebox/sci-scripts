;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 295)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use LoadMany)
(use Actor)
(use System)

(public
	rm295 0
	myORiley 19
)

(instance rm295 of LBRoom
	(properties
		picture 295
		south 290
	)

	(method (init)
		(LoadMany rsVIEW 295 1295)
		(LoadMany rsSOUND 295)
		(super init:)
		(gGameMusic1 number: 295 flags: 1 loop: -1 play:)
		(gCurRoom setScript: sInsideRoom)
	)

	(method (dispose)
		(gGameMusic1 fade: 0 30 12 1)
		(super dispose: &rest)
	)
)

(instance sInsideRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(gMessager say: 13 0 0 0 self) ; "Sure and begorrah, I'm Detective O'Riley. What would you be wanting then, lass?"
			)
			(2
				(gCurRoom drawPic: 780)
				(folderInset init:)
				(= cycles 1)
			)
			(3
				(gNarrator x: 100 y: 100)
				(gMessager say: 15 0 0 0 self) ; "The file on the Leyendecker museum burglary is nothing more than a single handwritten page. It mentions only one stolen object, the Dagger of Amon Ra."
			)
			(4
				(folderInset dispose:)
				(SetFlag 43)
				(gCurRoom drawPic: 295)
				(= cycles 1)
			)
			(5
				(gMessager say: 14 0 0 0 self) ; "There's only one page to this report. Where's the rest of it?"
			)
			(6
				(gCurRoom newRoom: 290)
				(self dispose:)
			)
		)
	)
)

(instance myORiley of Talker
	(properties
		x 0
		y 0
		view 1295
		loop 3
		disposeWhenDone 0
		talkWidth 280
		back 15
		textX 10
		textY 140
	)

	(method (init)
		(= font gUserFont)
		(super init: oRileyBust 0 oRileyMouth &rest)
	)
)

(instance oRileyBust of Prop
	(properties
		view 1295
		loop 1
	)
)

(instance oRileyMouth of Prop
	(properties
		nsTop 36
		nsLeft 254
		view 1295
	)
)

(instance folderInset of View
	(properties
		x 5
		y 5
		view 295
	)
)

