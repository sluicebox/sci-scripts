;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 97)
(include sci.sh)
(use Main)
(use LoadMany)
(use Game)
(use Actor)
(use System)

(public
	theEnd 0
)

(local
	local0
)

(instance theEnd of Rm
	(properties
		picture 905
		style 15
	)

	(method (init)
		(HandsOff)
		(LoadMany rsPIC 905 803)
		(LoadMany rsVIEW 861)
		(gMouseDownHandler add: giveEmTheWorks)
		(gKeyDownHandler add: giveEmTheWorks)
		(DrawStatus {} 0 0)
		(if (IsFlag 0)
			(= local0 10)
		else
			(= local0 -32762)
		)
		(super init:)
		(gRgnMusic number: (if (== (DoSound sndGET_POLYPHONY) 32) 27 else 28) loop: 1 play:)
		(title1 init:)
		(name1 init:)
		(name2 init:)
		(name3 init:)
		(name4 init:)
		(name5 init:)
		(name6 init:)
		(name7 init:)
		(name8 init:)
		(name9 init:)
		(name10 init: hide:)
		(name11 init: hide:)
		(name12 init: hide:)
		(name13 init: hide:)
		(name14 init: hide:)
		(name15 init: hide:)
		(gGame setCursor: 5 1)
		(self setScript: giveEmTheWorks)
	)

	(method (dispose)
		(gRgnMusic fade: 0 12 12 1)
		(gMouseDownHandler delete: giveEmTheWorks)
		(gKeyDownHandler delete: giveEmTheWorks)
		(super dispose: &rest)
	)
)

(instance title1 of View
	(properties
		x 4
		y 10
		view 861
	)
)

(instance name1 of View
	(properties
		x 140
		y 10
		view 861
		loop 2
		cel 1
	)
)

(instance name2 of View
	(properties
		x 140
		y 30
		view 861
		cel 1
	)
)

(instance name3 of View
	(properties
		x 140
		y 50
		view 861
		cel 2
	)
)

(instance name4 of View
	(properties
		x 140
		y 70
		view 861
		cel 3
	)
)

(instance name5 of View
	(properties
		x 140
		y 110
		view 861
		loop 2
		cel 2
	)
)

(instance name6 of View
	(properties
		x 140
		y 130
		view 861
		loop 1
		cel 1
	)
)

(instance name7 of View
	(properties
		x 140
		y 170
		view 861
		loop 1
		cel 2
	)
)

(instance name8 of View
	(properties
		x 140
		y 150
		view 861
		loop 3
	)
)

(instance name9 of View
	(properties
		x 140
		y 90
		view 861
		loop 1
	)
)

(instance name10 of View
	(properties
		x 170
		y 110
		view 861
		loop 9
		cel 2
	)
)

(instance name11 of View
	(properties
		x 40
		y 130
		view 861
		loop 9
		cel 3
	)
)

(instance name12 of View
	(properties
		x 170
		y 130
		view 861
		loop 8
		cel 3
	)
)

(instance name13 of View
	(properties
		x 40
		y 150
		view 861
		loop 9
		cel 4
	)
)

(instance name14 of View
	(properties
		x 170
		y 150
		view 861
		loop 9
		cel 5
	)
)

(instance name15 of View
	(properties
		x 107
		y 170
		view 861
		loop 9
		cel 6
	)
)

(instance giveEmTheWorks of Script
	(properties)

	(method (handleEvent event)
		(cond
			(
				(or
					(and (& (event modifiers:) emSHIFT) (& (event type:) evMOUSEBUTTON))
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
				)
				(super handleEvent: event)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				)
				(event claimed: 1)
				(self cue:)
				(super handleEvent: event)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(HandsOff)
				(= ticks 600)
			)
			(1
				1
				(gTheIconBar disable:)
				(gCurRoom drawPic: 803 local0)
				(title1 hide:)
				(name1 hide:)
				(name2 hide:)
				(name3 hide:)
				(name4 hide:)
				(name5 hide:)
				(name6 hide:)
				(name7 hide:)
				(name8 hide:)
				(name9 hide:)
				(= ticks 6)
			)
			(2
				2
				(gCurRoom drawPic: 905 local0)
				(title1 loop: 2 cel: 0 x: 4 y: 50 show:)
				(name1 loop: 2 cel: 1 x: 140 y: 70 show:)
				(name2 loop: 2 cel: 2 x: 140 y: 90 show:)
				(name3 loop: 2 cel: 3 x: 140 y: 110 show:)
				(name4 loop: 3 cel: 1 x: 140 y: 130 show:)
				(name5 loop: 0 cel: 1 x: 140 y: 150 show:)
				(= ticks 6)
			)
			(3
				3
				(gTheIconBar enable:)
				(= ticks 600)
			)
			(4
				4
				(gTheIconBar disable:)
				(gCurRoom drawPic: 803 local0)
				(title1 hide:)
				(name1 hide:)
				(name2 hide:)
				(name3 hide:)
				(name4 hide:)
				(name5 hide:)
				(= ticks 6)
			)
			(5
				5
				(gCurRoom drawPic: 905 local0)
				(title1 loop: 4 cel: 0 x: 107 y: 30 show:)
				(name1 loop: 4 cel: 2 x: 40 y: 50 show:)
				(name2 loop: 4 cel: 1 x: 170 y: 50 show:)
				(name3 loop: 4 cel: 3 x: 40 y: 70 show:)
				(name4 loop: 5 cel: 1 x: 170 y: 70 show:)
				(name5 loop: 5 cel: 2 x: 40 y: 90 show:)
				(name6 loop: 5 cel: 0 x: 170 y: 90 show:)
				(name7 loop: 6 cel: 2 x: 40 y: 110 show:)
				(name8 loop: 6 cel: 1 x: 170 y: 110 show:)
				(name9 loop: 10 cel: 5 x: 170 y: 130 show:)
				(name10 loop: 10 cel: 4 x: 40 y: 130 show:)
				(= ticks 6)
			)
			(6
				6
				(gTheIconBar enable:)
				(= ticks 600)
			)
			(7
				7
				(gTheIconBar disable:)
				(gCurRoom drawPic: 803 local0)
				(title1 hide:)
				(name1 hide:)
				(name2 hide:)
				(name3 hide:)
				(name4 hide:)
				(name5 hide:)
				(name6 hide:)
				(name7 hide:)
				(name8 hide:)
				(name9 hide:)
				(name10 hide:)
				(= ticks 6)
			)
			(8
				8
				(gCurRoom drawPic: 905 local0)
				(title1 loop: 7 cel: 0 x: 50 y: 10 show:)
				(name1 loop: 7 cel: 1 x: 40 y: 30 show:)
				(name2 loop: 7 cel: 2 x: 170 y: 30 show:)
				(name3 loop: 8 cel: 2 x: 40 y: 50 show:)
				(name4 loop: 7 cel: 4 x: 170 y: 50 show:)
				(name5 loop: 6 cel: 2 x: 40 y: 70 show:)
				(name6 loop: 7 cel: 5 x: 170 y: 70 show:)
				(name7 loop: 7 cel: 6 x: 40 y: 90 show:)
				(name8 loop: 9 cel: 0 x: 170 y: 90 show:)
				(name9 loop: 9 cel: 1 x: 40 y: 110 show:)
				(name10 loop: 9 cel: 2 x: 170 y: 110 show:)
				(name11 view: 861 loop: 9 cel: 3 x: 40 y: 130 show:)
				(name12 show:)
				(name13 show:)
				(name14 show:)
				(name15 show:)
				(= ticks 6)
			)
			(9
				9
				(gTheIconBar enable:)
				(= ticks 900)
			)
			(10
				10
				(gTheIconBar disable:)
				(gCurRoom drawPic: 803 local0)
				(title1 hide:)
				(name1 hide:)
				(name2 hide:)
				(name3 hide:)
				(name4 hide:)
				(name5 hide:)
				(name6 hide:)
				(name7 hide:)
				(name8 hide:)
				(name9 hide:)
				(name10 hide:)
				(name11 hide:)
				(name12 hide:)
				(name13 hide:)
				(name14 hide:)
				(name15 hide:)
				(= ticks 6)
			)
			(11
				11
				(gCurRoom drawPic: 905 local0)
				(title1 loop: 12 cel: 0 x: 217 y: 50 show:)
				(name1 loop: 10 cel: 2 x: 150 y: 70 show:)
				(name2 loop: 12 cel: 2 x: 150 y: 90 show:)
				(name3 loop: 12 cel: 1 x: 150 y: 110 show:)
				(name4 loop: 10 cel: 3 x: 150 y: 130 show:)
				(= ticks 6)
			)
			(12
				12
				(gTheIconBar enable:)
				(= ticks 900)
			)
			(13
				13
				(gTheIconBar disable:)
				(gCurRoom drawPic: 803 local0)
				(title1 hide:)
				(name1 hide:)
				(name2 hide:)
				(name3 hide:)
				(name4 hide:)
				(= ticks 6)
			)
			(14
				14
				(gCurRoom drawPic: 905 local0)
				(title1 loop: 11 cel: 0 x: 4 y: 60 show:)
				(name1 loop: 11 cel: 1 x: 140 y: 80 show:)
				(= ticks 6)
			)
			(15
				15
				(gTheIconBar enable:)
				(= ticks 300)
			)
			(16
				16
				(gTheIconBar disable:)
				(gCurRoom drawPic: 803 local0)
				(title1 hide:)
				(name1 hide:)
				(= ticks 1)
			)
			(17
				17
				(gCurRoom drawPic: 905 local0)
				(title1 view: 861 loop: 0 cel: 0 x: 4 y: 10 show:)
				(name1 view: 861 loop: 2 cel: 1 x: 140 y: 10 show:)
				(name2 loop: 0 cel: 1 x: 140 y: 30 show:)
				(name3 loop: 0 cel: 2 x: 140 y: 50 show:)
				(name4 loop: 0 cel: 3 x: 140 y: 70 show:)
				(name5 loop: 2 cel: 2 x: 140 y: 110 show:)
				(name6 loop: 1 cel: 1 x: 140 y: 130 show:)
				(name7 loop: 1 cel: 2 x: 140 y: 170 show:)
				(name8 loop: 3 cel: 0 x: 140 y: 150 show:)
				(name9 loop: 1 cel: 0 x: 140 y: 90 show:)
				(= ticks 6)
			)
			(18
				18
				(gTheIconBar enable:)
				(= ticks 300)
			)
			(19
				19
				(= state -1)
				(self cue:)
			)
		)
	)
)

