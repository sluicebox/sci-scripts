;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use Game)
(use Actor)
(use System)

(public
	introRoom 0
)

(local
	local0
	local1
	local2
)

(instance introRoom of Rm
	(properties)

	(method (init)
		(= style 2)
		(super init:)
		(self setScript: introDuction)
	)

	(method (handleEvent event)
		(if (and (not (event claimed:)) (event type:))
			(event claimed: 1)
			(if
				(and
					(or (== (event type:) evMOUSEBUTTON) (== (event type:) evKEYBOARD))
					(> (event y:) 10)
				)
				(if local0
					(local0 hide:)
				)
				(if local1
					(local1 hide:)
				)
				(if local2
					(local2 hide:)
				)
				(proc0_1)
				(gCurRoom newRoom: 1)
			)
		)
	)
)

(instance introDuction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 0 3)
				(gASong playBed: (gASong number:) gASong 10 -1)
				(= seconds 4)
			)
			(1
				(= local0 littlepic1)
				(= local1 littlename1)
				(DrawPic 1 2)
				(littlepic1 setLoop: 0 setCel: 0 init:)
				(littlename1 setLoop: 0 setCel: 1 init:)
				(= seconds 4)
			)
			(2
				(DrawPic 1 2)
				(littlepic1 setLoop: 1 setCel: 0)
				(littlename1 setLoop: 1 setCel: 1)
				(= seconds 3)
			)
			(3
				(DrawPic 1 2)
				(littlepic1 setLoop: 2 setCel: 0)
				(littlename1 setLoop: 2 setCel: 1)
				(= seconds 2)
			)
			(4
				(littlepic1 dispose:)
				(littlename1 dispose:)
				(= local0 littlepic2)
				(= local1 littlename2)
				(DrawPic 2 3)
				(littlepic2 setLoop: 0 setCel: 0 init:)
				(littlename1 hide:)
				(littlename2 setLoop: 0 setCel: 1 init:)
				(= seconds 4)
			)
			(5
				(DrawPic 2 3)
				(littlepic2 setLoop: 1 setCel: 0)
				(littlename2 setLoop: 1 setCel: 1)
				(= seconds 3)
			)
			(6
				(DrawPic 2 3)
				(littlepic2 setLoop: 2 setCel: 0)
				(littlename2 setLoop: 2 setCel: 1)
				(= seconds 2)
			)
			(7
				(littlepic2 dispose:)
				(littlename2 dispose:)
				(= local0 littlepic3)
				(= local1 littlename3)
				(DrawPic 3 2)
				(littlepic3 setLoop: 0 setCel: 0 init:)
				(littlename2 hide:)
				(littlename3 setLoop: 0 setCel: 1 init:)
				(= seconds 4)
			)
			(8
				(DrawPic 3 2)
				(littlepic3 setLoop: 1 setCel: 0)
				(littlename3 setLoop: 1 setCel: 1)
				(= seconds 3)
			)
			(9
				(DrawPic 3 2)
				(littlename3 setLoop: 1 setCel: 2)
				(= seconds 3)
			)
			(10
				(DrawPic 3 2)
				(littlepic3 setLoop: 2 setCel: 0)
				(littlename3 setLoop: 2 setCel: 1)
				(= seconds 3)
			)
			(11
				(DrawPic 3 2)
				(littlename3 setLoop: 2 setCel: 2)
				(= seconds 2)
			)
			(12
				(littlepic3 dispose:)
				(littlename3 dispose:)
				(= local0 littlepic4)
				(= local1 littlename4top)
				(= local2 littlename4bot)
				(DrawPic 4 3)
				(littlepic4 setLoop: 0 setCel: 0 init:)
				(littlename4top setLoop: 0 setCel: 1 init:)
				(littlename4bot setLoop: 0 setCel: 2 init:)
				(= seconds 3)
			)
			(13
				(DrawPic 4 3)
				(littlepic4 setLoop: 1 setCel: 0)
				(littlename4top setLoop: 1 setCel: 1 init:)
				(littlename4bot setLoop: 1 setCel: 2 init:)
				(= seconds 2)
			)
			(14
				(DrawPic 4 3)
				(littlepic4 setLoop: 2 setCel: 0)
				(littlename4top setLoop: 2 setCel: 1 init:)
				(littlename4bot setLoop: 2 setCel: 2 init:)
				(= seconds 2)
			)
			(15
				(littlepic4 dispose:)
				(littlename4top dispose:)
				(littlename4bot dispose:)
				(= local0 littlepic5)
				(= local1 littlename5top)
				(= local2 littlename5bot)
				(DrawPic 5 2)
				(littlepic5 setLoop: 0 setCel: 0 init:)
				(littlename5top setLoop: 0 setCel: 1 init:)
				(littlename5bot setLoop: 0 setCel: 2 init:)
				(= seconds 3)
			)
			(16
				(DrawPic 5 2)
				(littlepic5 setLoop: 1 setCel: 0)
				(littlename5top setLoop: 1 setCel: 1 init:)
				(littlename5bot setLoop: 1 setCel: 2 init:)
				(= seconds 2)
			)
			(17
				(littlename5top hide:)
				(littlename5bot hide:)
				(DrawPic 5 2)
				(littlepic5 setLoop: 2 setCel: 0)
				(= seconds 2)
			)
			(18
				(littlepic5 dispose:)
				(littlename5top dispose:)
				(littlename5bot dispose:)
				(= local0 (= local1 0))
				(proc0_1)
				(gCurRoom newRoom: 1)
			)
		)
	)
)

(instance littlepic1 of View
	(properties
		view 1
		priority 5
	)

	(method (init)
		(self posn: 162 160 stopUpd:)
		(super init:)
	)
)

(instance littlename1 of View
	(properties
		view 1
		priority 5
	)

	(method (init)
		(self posn: 160 56 stopUpd:)
		(super init:)
	)
)

(instance littlepic2 of View
	(properties
		view 2
		priority 5
	)

	(method (init)
		(self posn: 162 160 stopUpd:)
		(super init:)
	)
)

(instance littlename2 of View
	(properties
		view 2
		priority 5
	)

	(method (init)
		(self posn: 160 56 stopUpd:)
		(super init:)
	)
)

(instance littlepic3 of View
	(properties
		view 3
		priority 5
	)

	(method (init)
		(self posn: 162 160 stopUpd:)
		(super init:)
	)
)

(instance littlename3 of View
	(properties
		view 3
		priority 5
	)

	(method (init)
		(self posn: 160 56 stopUpd:)
		(super init:)
	)
)

(instance littlepic4 of View
	(properties
		view 4
		priority 5
	)

	(method (init)
		(self posn: 162 160 stopUpd:)
		(super init:)
	)
)

(instance littlename4top of View
	(properties
		view 4
		priority 5
	)

	(method (init)
		(self posn: 160 50 stopUpd:)
		(super init:)
	)
)

(instance littlename4bot of View
	(properties
		view 4
		priority 5
	)

	(method (init)
		(self posn: 165 178 stopUpd:)
		(super init:)
	)
)

(instance littlepic5 of View
	(properties
		view 5
		priority 5
	)

	(method (init)
		(self posn: 162 160 stopUpd:)
		(super init:)
	)
)

(instance littlename5top of View
	(properties
		view 5
		priority 5
	)

	(method (init)
		(self posn: 160 50 stopUpd:)
		(super init:)
	)
)

(instance littlename5bot of View
	(properties
		view 5
		priority 5
	)

	(method (init)
		(self posn: 165 178 stopUpd:)
		(super init:)
	)
)

