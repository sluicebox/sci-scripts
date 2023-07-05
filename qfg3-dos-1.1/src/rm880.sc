;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 880)
(include sci.sh)
(use Main)
(use RandCycle)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm880 0
)

(local
	local0
	local1
)

(instance rm880 of Rm
	(properties
		picture 880
	)

	(method (init)
		(super init:)
		(gLongSong number: 880 setLoop: -1 play:)
		(avisFangs init:)
		(avisEyes init:)
		(self setScript: theVeryLastScript)
	)
)

(instance theVeryLastScript of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 30])
		(switch (= state newState)
			(0
				(= temp0 0)
				(= seconds 2)
			)
			(1
				(Message msgGET 830 4 6 24 1 @temp1) ; "... TO BE CONTINUED IN ..."
				(= local0 (Display @temp1 dsFONT 2510 dsCOORD 60 9 dsCOLOR 25 dsSAVEPIXELS))
				(= local1 (Display @temp1 dsFONT 2510 dsCOORD 59 8 dsCOLOR 30 dsSAVEPIXELS))
				(= seconds 5)
			)
			(2
				(Display @temp0 dsRESTOREPIXELS local1)
				(Display @temp0 dsRESTOREPIXELS local0)
				(= seconds 2)
			)
			(3
				(glorySign init: setCycle: End self)
			)
			(4
				(= seconds 3)
			)
			(5
				(titleSign init:)
				(ballFx init: setCycle: Fwd)
				(egoDude init: setCycle: RandCycle)
				(DrawPic 880 9)
				(= seconds 2)
			)
			(6
				(avisFangs setCycle: End)
				(avisEyes setCycle: End self)
			)
			(7
				(= seconds 10)
			)
			(8
				(gLongSong fade: 0 6 3 1 self)
			)
			(9
				(gCurRoom newRoom: 52) ; CharSave
			)
		)
	)
)

(instance avisFangs of Prop
	(properties
		x 58
		y 123
		view 880
	)
)

(instance avisEyes of Prop
	(properties
		x 57
		y 108
		view 880
		loop 1
	)
)

(instance ballFx of Prop
	(properties
		x 154
		y 185
		view 883
	)
)

(instance egoDude of Prop
	(properties
		x 161
		y 168
		view 883
		loop 1
	)
)

(instance glorySign of Prop
	(properties
		x 55
		y 9
		view 884
	)
)

(instance titleSign of View
	(properties
		x 31
		y 42
		view 884
		loop 1
		signal 16384
	)
)

