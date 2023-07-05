;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 175)
(include sci.sh)
(use Main)
(use n013)
(use LoadMany)
(use Game)
(use Actor)
(use System)

(public
	muchswobat 0
)

(local
	local0
)

(instance muchswobat of Rm
	(properties
		style 8
	)

	(method (init)
		(Load rsPIC 110)
		(LoadMany rsVIEW 1 80 152 155 158 161 164)
		(LoadMany rsSOUND)
		(gCurRoom drawPic: 110 6)
		(gAddToPics add: frieze1 frieze2 eachElementDo: #init doit:)
		(robinh init:)
		(lilj init:)
		(aland init:)
		(wills init:)
		(muchm init:)
		(friart init:)
		(robinHead init:)
		(robinHead setScript: lookSee)
		(self setScript: whatNoBattle)
		(super init:)
	)
)

(instance frieze1 of PicView
	(properties
		x 31
		y 189
		sightAngle 90
		view 80
		priority 15
	)
)

(instance frieze2 of PicView
	(properties
		x 288
		y 189
		description {*** the battle frieze.}
		sightAngle 90
		lookStr {*** Robin's merrie men engage the Abbott's hoods in a fierce battle.}
		view 80
		cel 1
		priority 15
	)
)

(instance robinh of View
	(properties
		x 154
		y 156
		view 1
		loop 6
		priority 15
		signal 16
	)
)

(instance lilj of View
	(properties
		x 125
		y 205
		view 152
		loop 3
		priority 15
		signal 16
	)
)

(instance friart of View
	(properties
		x 77
		y 149
		view 155
	)
)

(instance aland of View
	(properties
		x 251
		y 179
		view 158
		loop 1
	)
)

(instance wills of View
	(properties
		x 211
		y 189
		view 161
		loop 1
	)
)

(instance muchm of View
	(properties
		x 73
		y 215
		view 164
		loop 3
	)
)

(instance robinHead of Prop
	(properties
		x 154
		y 117
		view 1
		loop 8
		priority 15
		signal 16
	)
)

(instance lookSee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(robinHead cel: 1)
				(= ticks (* (= local0 (Random 2 6)) 48))
			)
			(1
				(robinHead cel: 2)
				(= ticks (* (= local0 (Random 1 3)) 48))
			)
			(2
				(= state -1)
				(= ticks 128)
			)
		)
	)
)

(instance whatNoBattle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetMessageColor 3)
				(Say 175 0 self 80 {Friar Tuck}) ; "Well...that's that. They've gotten past us."
				(= seconds 8)
			)
			(1
				(SetMessageColor 1)
				(Say 175 1 self 80 {Little John}) ; "Aye. No need to remain here. We may as well return to camp and lick our wounds, so to speak."
				(= seconds 10)
			)
			(2
				(SetMessageColor 0)
				(gCurRoom newRoom: 160)
				(self dispose:)
			)
		)
	)
)

