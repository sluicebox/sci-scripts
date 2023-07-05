;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use RandCycle)
(use LoadMany)
(use Motion)
(use Actor)

(public
	rm300 0
)

(local
	local0
)

(instance rm300 of PQRoom
	(properties
		picture 99
		style 6
	)

	(method (init)
		(LoadMany rsVIEW 615)
		(gEgo hide:)
		(cInset init: hide:)
		(super init:)
		(HandsOff)
		(if
			(and
				(IsFlag 40)
				(IsFlag 41)
				(== ((gInventory at: 37) owner:) 36) ; locket
				(== ((gInventory at: 5) owner:) 36) ; musicBox
				(== ((gInventory at: 36) owner:) 36) ; rose
			)
			(self setScript: closingCartoon)
		else
			(self setScript: youBooBoo)
		)
	)
)

(instance youBooBoo of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(EgoDead 25) ; "With everything you've tried, it just wasn't enough to bring Marie out of her coma."
			)
		)
	)
)

(instance closingCartoon of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(= save1 1)
				(Print 300 0 #dispose) ; "But, for now, let the cleanup crew do their job and the Guilty sleep their dreamless sleep. For you, there's suddenly nothing more important than seeing Marie."
				(= seconds 8)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= seconds 2)
			)
			(3
				(cInset show:)
				(= seconds 1)
			)
			(4
				(= save1 1)
				(Say egoTalk 300 1) ; "I don't think I'll ever be able to look at you again without feeling what I feel right now - without remembering what a miracle it is just to hold you."
				(egoMouth init: setCycle: RandCycle)
				(= seconds 8)
			)
			(5
				(egoMouth dispose:)
				(= cycles 1)
			)
			(6
				(= save1 1)
				(Say marieTalk 300 2) ; "Speaking of miracles...Dr. Powers has just given me a bit of news..."
				(marieMouth init: setCycle: RandCycle)
				(= seconds 5)
			)
			(7
				(marieMouth setCycle: 0)
				(= seconds 2)
			)
			(8
				(marieMouth setCycle: RandCycle)
				(= save1 1)
				(Say marieTalk 300 3) ; "Oh Sonny..."
				(= seconds 3)
			)
			(9
				(marieMouth setCycle: 0)
				(= seconds 2)
			)
			(10
				(marieMouth setCycle: RandCycle)
				(= save1 1)
				(Say marieTalk 300 4) ; "We're going to HAVE A BABY!"
				(= local0 (Random 0 100))
				(= seconds 4)
			)
			(11
				(marieMouth dispose:)
				(if (not local0)
					(bugEyes init: setCycle: End self)
				else
					(egoSuprise init: cel: 1)
					(= cycles 1)
				)
			)
			(12
				(= seconds 2)
			)
			(13
				(if (not local0)
					(bugEyes setCycle: Beg self)
				else
					(= cycles 1)
				)
				(egoSuprise dispose:)
			)
			(14
				(bugEyes dispose:)
				(= cycles 1)
			)
			(15
				(= save1 1)
				(Say egoTalk 300 5) ; "a-abab- A BABY?"
				(egoMouth init: setCycle: RandCycle)
				(= seconds 3)
			)
			(16
				(egoMouth dispose:)
				(cInset setCycle: End self)
			)
			(17
				(= seconds 3)
			)
			(18
				(cInset setCycle: Beg self)
				(gLongSong fade:)
			)
			(19
				(cInset dispose:)
				(gCurRoom drawPic: 99 10)
				(= seconds 3)
			)
			(20
				(gLongSong number: 0)
				(gCurRoom newRoom: 310)
			)
		)
	)
)

(instance cInset of Prop
	(properties
		x 168
		y 87
		view 615
	)

	(method (init)
		(self stopUpd:)
		(marieMouth x: (- (self x:) 36) y: (+ (self y:) 16))
		(egoMouth x: (self x:) y: (self y:))
		(egoSuprise x: (self x:) y: (self y:))
		(bugEyes x: (self x:) y: (self y:))
		(egoTalk init: hide:)
		(marieTalk init: hide:)
		(super init:)
	)

	(method (dispose)
		(marieMouth dispose:)
		(egoMouth dispose:)
		(bugEyes dispose:)
		(egoTalk dispose:)
		(marieTalk dispose:)
		(super dispose:)
	)
)

(instance marieMouth of Prop
	(properties
		view 615
		loop 1
	)
)

(instance egoSuprise of Prop
	(properties
		view 615
		loop 2
		priority 7
		signal 16400
	)
)

(instance egoMouth of Prop
	(properties
		view 615
		loop 4
		priority 7
		signal 16400
	)
)

(instance bugEyes of Prop
	(properties
		view 615
		loop 3
		priority 8
		signal 16400
	)
)

(instance egoTalk of View
	(properties
		x 170
		y 78
		view 615
		loop 3
		priority 1
	)
)

(instance marieTalk of View
	(properties
		x 90
		y 79
		view 615
		loop 3
		priority 1
	)
)

