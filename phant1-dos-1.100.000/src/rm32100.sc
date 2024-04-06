;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm32100 0
)

(local
	local0
	local1
)

(instance rm32100 of ScaryRoom
	(properties
		picture 32100
		stepSound 4
	)

	(method (notify)
		(lookScrapScr cue:)
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(gGDacSound number: 32020 setLoop: -1 play:)
		(gEgo init: setScaler: Scaler 191 69 152 89 normalize: 2)
		(if (and (IsFlag 280) (not (IsFlag 285)))
			(= picture 32200)
		else
			(= picture 32300)
		)
		(door init: 3)
		(switch gPrevRoomNum
			(900
				(= picture 32200)
				(gEgo
					posn: 137 115
					normalize: 1
					setScaler: Scaler 191 69 152 89
				)
				(self setScript: fromStartup)
			)
			(else
				(if (and (IsFlag 280) (not (IsFlag 285)))
					(gCast eachElementDo: #hide)
					(gCurRoom setScript: bookHereScr)
				else
					(gEgo
						posn: 162 110
						setScaler: Scaler 191 69 152 89
						normalize: 2
					)
				)
			)
		)
		(cond
			((== gPrevRoomNum 900))
			(script)
			((not (IsFlag 272))
				(self setScript: fe0Scr)
			)
			(else
				(self setScript: enterRoom)
			)
		)
		(Load 140 32020 32021 32022 32023) ; WAVE
		(Lock 140 32020 1) ; WAVE
		(Lock 140 32021 1) ; WAVE
		(Lock 140 32022 1) ; WAVE
		(Lock 140 32023 1) ; WAVE
		(super init: &rest)
	)

	(method (doit)
		(if (and (== (Random 0 32760) 1) (not (gCurRoom script:)))
			(switch (Random 0 2)
				(0
					(sfx1 number: 32021 play:)
				)
				(1
					(sfx2 number: 32022 play:)
				)
				(2
					(sfx3 number: 32023 play:)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(Lock 140 32020 0) ; WAVE
		(Lock 140 32021 0) ; WAVE
		(Lock 140 32022 0) ; WAVE
		(Lock 140 32023 0) ; WAVE
		(KillRobot)
		(super dispose:)
	)
)

(instance fromStartup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 121)
				(lou init:)
				(= cycles 2)
			)
			(1
				(changeTo32200 doit:)
				(ClearFlag 121)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(peopleMover doit:)
					(DoRobot 2858 0 0 gEgo 200)
				)
				(1
					(if (gCast contains: people)
						(people setCycle: 0 cel: 0 dispose:)
					)
					(KillRobot)
					(lou init:)
					(changeTo32200 doit:)
					(gEgo normalize: 3)
					(self setScript: (ScriptID 0 5) self) ; takeLastStep
				)
				(2
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(if (gCast contains: people)
						(people setCycle: 0 cel: 0 dispose:)
					)
					(KillRobot)
					(lou init:)
					(changeTo32200 doit:)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance leaveRoom of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (gCast contains: scrapbook)
						(scrapbook dispose:)
					)
					(lou dispose:)
					(DoRobot 2859 0 0 gEgo 200 1)
					(gCurRoom drawPic: 32300)
				)
				(1
					(gEgo hide:)
					(gCurRoom newRoom: 34300)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(gEgo hide:)
					(if (gCast contains: scrapbook)
						(scrapbook dispose:)
					)
					(= global115 0)
					(gCurRoom newRoom: 34235)
				)
			)
		)
	)
)

(instance bookHereScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(Load rsVIEW 3801)
					(chair init: setPri: 135)
					(SetFlag 285)
					(DoRobot 3800 19 5)
				)
				(1
					(chair dispose:)
					(lou dispose:)
					(DoRobot 3801 7 -53)
					(gCurRoom drawPic: 32450)
				)
				(2
					(scrapBook init:)
				)
				(3
					(scrapBook dispose:)
					(DoRobot 2885 49 -28)
					(gCurRoom drawPic: 32100)
				)
				(4
					(scrapbook x: 80 init: setHotspot: 4 3 approachVerbs: 4 3) ; Do, Move, Do, Move
					(gEgo show: normalize: 0 posn: 162 110)
					(lou init:)
					(changeTo32200 doit:)
					(self dispose:)
					(gGame handsOn:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(gEgo
						show:
						posn: 110 100
						setScaler: Scaler 191 69 152 89
						normalize: 3
					)
					(chair dispose:)
					(scrapBook dispose:)
					(scrapbook x: 80 init: setHotspot: 4 3 approachVerbs: 4 3) ; Do, Move, Do, Move
					(if (IsFlag 273)
						(lou init: setHotspot: 4 3 16 37) ; Do, Move, invBrooch, ???
					else
						(lou init: setHotspot: 4 3) ; Do, Move
					)
					(SetFlag 285)
					(= global115 0)
					(changeTo32200 doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance fe0Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 272)
					(peopleMover doit:)
					(DoRobot 2857 0 0 gEgo 200)
				)
				(1
					(if (gCast contains: people)
						(people setCycle: 0 cel: 0 dispose:)
					)
					(chair32350 init:)
					(lou hide:)
					(DoRobot 2861 -3 5)
					(gCurRoom drawPic: 32350)
				)
				(2
					(chair32350 dispose:)
					(DoRobot 2862 23 -32)
					(gCurRoom drawPic: 32100)
					(gEgo
						setScaler: Scaler 191 69 152 89
						posn: 105 109
						normalize: 0
					)
				)
				(3
					(lou view: 32200 loop: 0 cel: 0 x: 199 y: 115 init:)
					(changeTo32200 doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(gEgo
						setScaler: Scaler 191 69 152 89
						posn: 105 109
						normalize: 0
					)
					(if (gCast contains: chair32350)
						(chair32350 dispose:)
					)
					(if (gCast contains: lou)
						(lou view: 32200 loop: 0 cel: 0 x: 199 y: 115 init:)
					else
						(lou init:)
					)
					(if (gCast contains: people)
						(people setCycle: 0 cel: 0 dispose:)
					)
					(changeTo32200 doit:)
					(= global115 0)
					(SetFlag 272)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance s2ndTalkScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 276)
					(lou hide:)
					(DoRobot 2890 32 -40)
					(changeTo32100 doit:)
				)
				(1
					(DoRobot 2891 2 7)
					(gCurRoom drawPic: 32370)
				)
				(2
					(DoRobot 2892 -12 -1)
					(phone init:)
					(gCurRoom drawPic: 32350)
				)
				(3
					(phone dispose:)
					(DoRobot 2893 -8 -9)
					(gCurRoom drawPic: 32370)
				)
				(4
					(gEgo normalize: 0 posn: 162 110)
					(lou show:)
					(changeTo32200 doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(lou show:)
					(if (gCast contains: phone)
						(phone dispose:)
					)
					(gEgo normalize: 0 posn: 162 110)
					(changeTo32200 doit:)
					(= global115 0)
					(SetFlag 276)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance s3rdTalkScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(SetFlag 277)
					(SetFlag 250)
					(lou hide:)
					(if (gCast contains: scrapBook)
						(scrapBook dispose:)
					)
					(if (gCast contains: scrapbook)
						(scrapbook dispose:)
					)
					(DoRobot 2901 8 16)
					(gCurRoom drawPic: 32370)
				)
				(1
					(DoRobot 2902 11 -44)
					(gCurRoom drawPic: 32376)
				)
				(2
					(DoRobot 2903 27 -8)
					(gCurRoom drawPic: 32370)
				)
				(3
					(DoRobot 2904 100 -24)
					(gCurRoom drawPic: 32376)
				)
				(4
					(DoRobot 2908 35 8)
					(gCurRoom drawPic: 32370)
				)
				(5
					(DoRobot 2905 0 -10)
					(gCurRoom drawPic: 32375)
				)
				(6
					(DoRobot 2906 56 -9)
					(gCurRoom drawPic: 32376)
				)
				(7
					(DoRobot 2907 17 20)
					(gCurRoom drawPic: 32370)
				)
				(8
					(if (gCast contains: lou)
						(lou show:)
					else
						(lou init:)
					)
					(changeTo32200 doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(if (gCast contains: lou)
						(lou show:)
					)
					(changeTo32200 doit:)
					(= global115 0)
					(SetFlag 277)
					(SetFlag 250)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance s4thTalkScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 278)
					(lou hide:)
					(DoRobot 2910 137 25 gEgo 200)
					(changeTo32100 doit:)
				)
				(1
					(DoRobot 2911 -9 11)
					(gCurRoom drawPic: 32370)
				)
				(2
					(DoRobot 2912 -2 -14)
					(gCurRoom drawPic: 32375)
				)
				(3
					(DoRobot 2913 49 -14)
					(gCurRoom drawPic: 32376)
				)
				(4
					(DoRobot 2914 -11 -16)
					(gCurRoom drawPic: 32375)
				)
				(5
					(DoRobot 2916 -9 11)
					(gCurRoom drawPic: 32370)
				)
				(6
					(DoRobot 2917 -10 -13)
					(gCurRoom drawPic: 32375)
				)
				(7
					(DoRobot 2918 47 -9)
					(gCurRoom drawPic: 32376)
				)
				(8
					(DoRobot 2919 45 -30 gEgo 200)
					(gCurRoom drawPic: 32100)
				)
				(9
					(gEgo normalize: 0)
					(lou show:)
					(changeTo32200 doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(gEgo normalize: 0)
					(lou show:)
					(changeTo32200 doit:)
					(= global115 0)
					(SetFlag 278)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance s5thTalkScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 279)
					(lou hide:)
					(DoRobot 2920 110 16)
					(changeTo32100 doit:)
				)
				(1
					(DoRobot 2922 36 -8)
					(gCurRoom drawPic: 32376)
				)
				(2
					(DoRobot 2923 -24 -15)
					(gCurRoom drawPic: 32375)
				)
				(3
					(DoRobot 2925 130 25 gEgo 200)
					(gCurRoom drawPic: 32100)
				)
				(4
					(lou show:)
					(changeTo32200 doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(lou show:)
					(changeTo32200 doit:)
					(SetFlag 279)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance s6thTalkScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 280)
					(lou hide:)
					(DoRobot 2930 30 -28)
					(changeTo32100 doit:)
				)
				(1
					(DoRobot 2931 5 17)
					(gCurRoom drawPic: 32370)
				)
				(2
					(DoRobot 2932 -6 -12)
					(gCurRoom drawPic: 32375)
				)
				(3
					(DoRobot 2933 80 -11)
					(gCurRoom drawPic: 32376)
				)
				(4
					(DoRobot 2934 4 17 gEgo)
					(gCurRoom drawPic: 32370)
				)
				(5
					(DoRobot 2935 4 17 gEgo)
				)
				(6
					(lou show:)
					(changeTo32200 doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(lou show:)
					(changeTo32200 doit:)
					(SetFlag 280)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance s7thTalkScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 281)
					(lou hide:)
					(DoRobot 2940 123 14)
					(changeTo32100 doit:)
				)
				(1
					(DoRobot 2941 4 17)
					(gCurRoom drawPic: 32370)
				)
				(2
					(DoRobot 2942 34 -36)
					(gCurRoom drawPic: 32100)
				)
				(3
					(lou show:)
					(changeTo32200 doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(lou show:)
					(changeTo32200 doit:)
					(= global115 0)
					(SetFlag 281)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance s8thTalkScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 282)
					(lou hide:)
					(DoRobot 2950 129 17)
					(changeTo32100 doit:)
				)
				(1
					(DoRobot 2951 -85 -22)
					(gCurRoom drawPic: 32370)
				)
				(2
					(DoRobot 2952 0 -5)
					(gCurRoom drawPic: 32375)
				)
				(3
					(DoRobot 2953 15 -8)
					(gCurRoom drawPic: 32376)
				)
				(4
					(DoRobot 2954 -48 -8)
					(gCurRoom drawPic: 32375)
				)
				(5
					(DoRobot 2955 -99 -22)
					(gCurRoom drawPic: 32370)
				)
				(6
					(DoRobot 2956 89 0 gEgo 200)
					(gCurRoom drawPic: 32100)
				)
				(7
					(lou show:)
					(changeTo32200 doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(lou show:)
					(changeTo32200 doit:)
					(= global115 0)
					(SetFlag 282)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance s10thTalkScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (gCast contains: lou)
						(lou hide:)
					)
					(SetFlag 283)
					(DoRobot 3810 116 21 gEgo 200)
					(changeTo32100 doit:)
				)
				(1
					(DoRobot 3811 10 18)
					(gCurRoom drawPic: 32370)
				)
				(2
					(DoRobot 3812 141 23)
					(gCurRoom drawPic: 32100)
				)
				(3
					(if (gCast contains: lou)
						(lou show:)
					else
						(lou init:)
					)
					(changeTo32200 doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(if (gCast contains: lou)
						(lou show:)
					else
						(lou init:)
					)
					(changeTo32200 doit:)
					(= global115 0)
					(SetFlag 283)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance s11thTalkScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(lou hide:)
					(DoRobot 3820 96 -4 gEgo 105)
					(changeTo32100 doit:)
				)
				(1
					(lou show:)
					(changeTo32200 doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(lou show:)
					(KillRobot)
					(changeTo32200 doit:)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance malcolmScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 365)
					(lou hide:)
					(DoRobot 5610 129 27)
					(changeTo32100 doit:)
				)
				(1
					(DoRobot 5611 22 18)
					(gCurRoom drawPic: 32370)
				)
				(2
					(DoRobot 5612 127 30)
					(gCurRoom drawPic: 32100)
				)
				(3
					(changeTo32200 doit:)
					(lou show:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(KillRobot)
					(lou show:)
					(changeTo32200 doit:)
					(SetFlag 365)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance broochScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(lou hide:)
					(if (gCast contains: scrapbook)
						(scrapbook dispose:)
					)
					(DoRobot 5620 129 20)
					(gCurRoom drawPic: 32100)
				)
				(1
					(DoRobot 5621 36 -18)
					(gCurRoom drawPic: 32376)
				)
				(2
					(DoRobot 5622)
					(gCurRoom drawPic: 32377)
				)
				(3
					(DoRobot 5623 0 -30)
					(gCurRoom drawPic: 32375)
				)
				(4
					(DoRobot 5624)
					(gCurRoom drawPic: 32376)
				)
				(5
					(DoRobot 5625 41 39)
					(gCurRoom drawPic: 32200)
				)
				(6
					(DoRobot 5626 60 -13)
					(gCurRoom drawPic: 32376)
				)
				(7
					(DoRobot 5627 111 5)
					(gCurRoom drawPic: 32100)
				)
				(8
					(displayCase dispose:)
					(lou show:)
					(gEgo put: 10) ; invBrooch
					(gEgo get: 14) ; invCrucifix
					(SetFlag 274)
					(changeTo32200 doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(lou show:)
					(displayCase dispose:)
					(= global115 0)
					(gEgo put: 10) ; invBrooch
					(gEgo get: 14) ; invCrucifix
					(SetFlag 274)
					(changeTo32200 doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lookScrapScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 248)
					(gCast eachElementDo: #hide)
					(bookProp loop: 0 x: 119 y: 98 init:)
					(DoRobot 3830 49 -18)
					(gCurRoom drawPic: 32400)
				)
				(1
					(bookProp dispose:)
				)
				(2
					(= local0 0)
					(gCurRoom drawPic: 32620)
					((ScriptID 0 14) init:) ; exitButt
					(gGame handsOn:)
					(door dispose:)
					(if (gFeatures contains: displayCase)
						(displayCase dispose:)
					)
					(scrapEExit init: 2)
					(scrapWExit init: 4)
				)
				(3
					((ScriptID 0 14) dispose:) ; exitButt
					(gGame handsOff:)
					(if (not (gEgo has: 14)) ; invCrucifix
						(displayCase init: setHotspot: 4 3) ; Do, Move
					)
					(scrapEExit dispose:)
					(scrapWExit dispose:)
					(door init: 3)
					(DoRobot 3831 -9 -27)
					(gCurRoom drawPic: 32400)
				)
				(4
					(bookProp loop: 1 x: 117 y: 99 init:)
				)
				(5
					(bookProp dispose:)
					(gCast eachElementDo: #show)
					(if (not (gCast contains: lou))
						(lou init:)
					)
					(changeTo32200 doit:)
					(gEgo posn: 125 115 normalize: 2)
					(ClearFlag 248)
					(ClearFlag 121)
					(self setScript: (ScriptID 0 5) self) ; takeLastStep
				)
				(6
					(gEgo normalize: 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(ClearFlag 248)
					(ClearFlag 121)
					(if (gFeatures contains: scrapEExit)
						(scrapEExit dispose:)
						(scrapWExit dispose:)
					)
					(if (not (gFeatures contains: door))
						(door init: 3)
						(if (not (gEgo has: 14)) ; invCrucifix
							(displayCase init: setHotspot: 4 3) ; Do, Move
						)
					)
					(gCast eachElementDo: #show)
					(if (not (gCast contains: lou))
						(lou init:)
					)
					(if (gCast contains: bookProp)
						(bookProp dispose:)
					)
					(changeTo32200 doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lookInCase of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCast eachElementDo: #hide)
					(if (IsFlag 285)
						(bookProp loop: 0 x: 119 y: 98 init:)
					)
					(DoRobot 2870 155 19)
					(gCurRoom drawPic: 32400)
				)
				(1
					(if (IsFlag 285)
						(bookProp dispose:)
					)
					(gCurRoom drawPic: 32500)
					(= seconds 7)
				)
				(2
					(if (IsFlag 285)
						(bookProp init:)
					)
					(DoRobot 2871 155 19)
					(gCurRoom drawPic: 32400)
				)
				(3
					(if (IsFlag 285)
						(bookProp dispose:)
					)
					(gCast eachElementDo: #show)
					(changeTo32200 doit:)
					(gEgo posn: 125 115 normalize: 2)
					(self setScript: (ScriptID 0 5) self) ; takeLastStep
					(lou approachVerbs: 4 3 approachX: 107 approachY: 200) ; Do, Move
				)
				(4
					(= global163 0)
					(gEgo normalize: 2)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gCast eachElementDo: #show)
					(if (gCast contains: bookProp)
						(bookProp dispose:)
					)
					(= global163 0)
					(changeTo32200 doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance caseScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 273)
					(gCast eachElementDo: #hide)
					(if (IsFlag 285)
						(bookProp loop: 0 x: 119 y: 98 init:)
					)
					(DoRobot 2870 155 19)
					(gCurRoom drawPic: 32400)
				)
				(1
					(if (IsFlag 285)
						(bookProp dispose:)
					)
					(gCurRoom drawPic: 32500)
					(= seconds 7)
				)
				(2
					(if (IsFlag 285)
						(bookProp init:)
					)
					(DoRobot 2871 155 19)
					(gCurRoom drawPic: 32400)
				)
				(3
					(if (IsFlag 285)
						(bookProp dispose:)
					)
					(DoRobot 2880 32 -34 gEgo 200)
					(changeTo32100 doit:)
				)
				(4
					(DoRobot 2881 68 26)
					(chair init: setPri: 135)
					(gCurRoom drawPic: 32200)
				)
				(5
					(chair dispose:)
					(DoRobot 2882 36 0)
					(gCurRoom drawPic: 32450)
				)
				(6
					(DoRobot 2885 49 -28)
					(gCurRoom drawPic: 32100)
				)
				(7
					(gEgo show: normalize: 0 posn: 162 110)
					(lou show: setHotspot: 4 3 16 37) ; Do, Move, invBrooch, ???
					(changeTo32200 doit:)
					(= global163 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(if (gCast contains: bookProp)
						(bookProp dispose:)
					)
					(KillRobot)
					(= global163 0)
					(lou setHotspot: 4 3 16 37) ; Do, Move, invBrooch, ???
					(SetFlag 273)
					(= global115 0)
					(gCast eachElementDo: #show)
					(changeTo32200 doit:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance doneScrapScr of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(ClearFlag 285)
					(scrapbook dispose:)
					(lou hide:)
					(DoRobot 3880 35 45)
				)
				(1
					(DoRobot 3881 12 15)
					(gCurRoom drawPic: 32370)
				)
				(2
					(DoRobot 3882 114 11)
					(gCurRoom drawPic: 32100)
				)
				(3
					(lou loop: 1 show:)
					(gEgo posn: 120 120)
					(gCurRoom drawPic: 32200)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(KillRobot)
					(gEgo posn: 120 120)
					(lou show:)
					(ClearFlag 285)
					(scrapbook dispose:)
					(gCurRoom drawPic: 32200)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance turnPageForward of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (not (pageSfx handle:)) (== (pageTurner cel:) 4))
			(pageSfx number: 32024 play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 121)
				((ScriptID 0 14) dispose:) ; exitButt
				(gGame handsOff:)
				(if (== local0 4)
					(= local0 0)
					(lookScrapScr cue:)
					(ClearFlag 121)
					(self dispose:)
				else
					(pageTurner loop: 0 cel: 0 init: setCycle: End self)
				)
				(gCurRoom drawPic: 32400)
			)
			(1
				(pageTurner dispose:)
				(++ local0)
				(gCurRoom
					drawPic:
						(switch local0
							(1 32600)
							(2 32630)
							(3 32640)
							(4 32610)
						)
				)
				(ClearFlag 121)
				((ScriptID 0 14) init:) ; exitButt
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance turnPageBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 121)
				((ScriptID 0 14) dispose:) ; exitButt
				(gGame handsOff:)
				(if (== local0 0)
					(lookScrapScr cue:)
					(ClearFlag 121)
					(self dispose:)
				else
					(pageTurner loop: 0 cel: 23 init: setCycle: Beg self)
					(pageSfx number: 32025 play:)
				)
				(gCurRoom drawPic: 32400)
			)
			(1
				(pageTurner dispose:)
				(-- local0)
				(gCurRoom
					drawPic:
						(switch local0
							(0 32620)
							(1 32600)
							(2 32630)
							(3 32640)
						)
				)
				(ClearFlag 121)
				((ScriptID 0 14) init:) ; exitButt
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pageSfx of Sound
	(properties)
)

(instance people of Prop
	(properties)

	(method (init param1 param2)
		(= view param1)
		(if (== param2 1)
			(= x 113)
			(= y 63)
		else
			(= x 243)
			(= y 76)
		)
		(super init:)
		(self setCycle: End self cycleSpeed: 9)
	)

	(method (cue)
		(self cel: 0 dispose:)
	)
)

(instance lou of Prop
	(properties
		x 199
		y 115
		view 32200
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 49 121 47 80 59 61 68 60 86 94 78 118 49 121
					yourself:
				)
			setHotspot: 4 3 ; Do, Move
			cycleSpeed: 7
			setCycle: Fwd
		)
		(if (IsFlag 273)
			(self setHotspot: 4 3 16 37) ; Do, Move, invBrooch, ???
		)
	)

	(method (doVerb theVerb)
		(self approachVerbs: 0)
		(switch theVerb
			(4 ; Do
				(cond
					((and (IsFlag 285) (IsFlag 282) (not (IsFlag 283)))
						(gGame handsOff:)
						(gCurRoom setScript: s10thTalkScr)
					)
					(
						(and
							(== gChapter 6)
							(IsFlag 99)
							(not (IsFlag 365))
							(not (IsFlag 206))
							(not (IsFlag 284))
						)
						(gGame handsOff:)
						(gCurRoom setScript: malcolmScr)
					)
					((not (IsFlag 276))
						(gGame handsOff:)
						(gCurRoom setScript: s2ndTalkScr 0 1)
					)
					((and (IsFlag 162) (not (IsFlag 277)))
						(gGame handsOff:)
						(gCurRoom setScript: s3rdTalkScr 0 1)
					)
					((not (IsFlag 278))
						(gGame handsOff:)
						(gCurRoom setScript: s4thTalkScr 0 1)
					)
					((not (IsFlag 279))
						(gGame handsOff:)
						(gCurRoom setScript: s5thTalkScr 0 1)
					)
					((not (IsFlag 280))
						(gGame handsOff:)
						(gCurRoom setScript: s6thTalkScr 0 1)
					)
					((not (IsFlag 281))
						(gGame handsOff:)
						(gCurRoom setScript: s7thTalkScr 0 1)
					)
					((not (IsFlag 282))
						(gGame handsOff:)
						(gCurRoom setScript: s8thTalkScr 0 1)
					)
					(else
						(gGame handsOff:)
						(gCurRoom setScript: s11thTalkScr 0 1)
					)
				)
			)
			(16 ; invBrooch
				(gGame handsOff:)
				(gCurRoom setScript: broochScr)
			)
			(37 ; ???
				(gGame handsOff:)
				(gCurRoom setScript: broochScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bookProp of Prop
	(properties
		x 117
		y 99
		view 3830
	)
)

(instance pageTurner of Prop
	(properties
		x 113
		y 131
		view 3833
	)
)

(instance chair of View
	(properties
		x 48
		y 127
		view 2881
	)
)

(instance scrapbook of View
	(properties
		approachX 125
		approachY 101
		x 80
		y 76
		view 3800
	)

	(method (handleEvent event)
		(if (== global163 displayCase)
			(= global163 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: lookScrapScr)
				(= global163 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance phone of View
	(properties
		x 189
		y 106
		view 32350
	)
)

(instance chair32350 of View
	(properties
		x 48
		y 148
		view 32350
		loop 1
	)
)

(instance scrapBook of View
	(properties
		x 94
		y 106
		view 3801
	)

	(method (init)
		(super init:)
		(self setPri: 200)
	)
)

(instance chair32100 of View
	(properties
		x 206
		y 119
		view 32101
	)
)

(instance displayCase of Feature
	(properties
		nsLeft 85
		nsTop 85
		nsRight 117
		nsBottom 93
		approachX 125
		approachY 101
		x 101
		y 10
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 87 98 87 89 105 83 104 76 121 77 120 91 88 98
					yourself:
				)
		)
	)

	(method (handleEvent event)
		(if (== global163 scrapbook)
			(= global163 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (IsFlag 266))
					(gGame handsOff:)
					(SetFlag 266)
					(gCurRoom setScript: caseScr)
				else
					(gCurRoom setScript: lookInCase)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 5
		nsTop 100
		nsRight 218
		nsBottom 130
		approachX 195
		approachY 93
		x 195
		y 90
		exitDir 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(if (IsFlag 335)
				(ClearFlag 285)
			)
			(gCurRoom setScript: leaveRoom)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance scrapEExit of ExitFeature
	(properties
		nsLeft 200
		nsTop 0
		nsRight 320
		nsBottom 120
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(lookScrapScr setScript: turnPageForward)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance scrapWExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 0
		nsRight 50
		nsBottom 130
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(lookScrapScr setScript: turnPageBack)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance scrapSExit of ExitFeature ; UNUSED
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(lookScrapScr cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance scrapNExit of ExitFeature ; UNUSED
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(lookScrapScr cue:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance changeTo32200 of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(if (gCast contains: chair)
			(chair dispose:)
		)
		(if (gCast contains: chair32100)
			(chair32100 dispose:)
		)
		(if (gCast contains: lou)
			(lou x: 95 y: 121 loop: 1 setCycle: Fwd cycleSpeed: 7)
		)
		(door
			nsLeft: 5
			nsTop: 100
			nsRight: 218
			nsBottom: 130
			approachX: 160
			approachY: 300
			exitDir: 3
		)
		(if (not (gEgo has: 14)) ; invCrucifix
			(displayCase init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(if local1
			(gEgo show:)
			(= local1 0)
		)
		(gEgo posn: 130 115 normalize: 1 setScaler: Scaler 191 69 152 89)
		(if (IsFlag 285)
			(scrapbook init: setHotspot: 4 3 approachVerbs: 4 3) ; Do, Move, Do, Move
		)
		(gCurRoom drawPic: 32200)
		(for ((= temp0 0)) (< temp0 (gCast size:)) ((++ temp0))
			(= temp1 (gCast at: temp0))
			(if (temp1 isNotHidden:)
				(UpdateScreenItem temp1)
			)
		)
		(if argc
			(param1 cue:)
		)
	)
)

(instance changeTo32100 of Code
	(properties)

	(method (doit param1)
		(if (gCast contains: lou)
			(lou x: 199 y: 115 loop: 0)
			(if (IsFlag 273)
				(lou setHotspot: 4 3 16 37) ; Do, Move, invBrooch, ???
			)
		)
		(if (IsFlag 285)
			(scrapBook dispose:)
			(scrapbook dispose:)
		)
		(if (gFeatures contains: displayCase)
			(displayCase dispose:)
		)
		(gCurRoom drawPic: 32100)
		(if argc
			(param1 cue:)
		)
	)
)

(instance peopleMover of Code
	(properties)

	(method (doit)
		(switch (Random 0 30)
			(0
				(people init: 32300 1)
			)
			(1
				(people init: 32301 1)
			)
			(2
				(people init: 32302 1)
			)
			(3
				(people init: 32303 1)
			)
			(4
				(people init: 32304 1)
			)
			(5
				(people init: 32305 1)
			)
			(6
				(people init: 32306 1)
			)
			(7
				(people init: 32307 1)
			)
			(8
				(people init: 32309 2)
			)
			(9
				(people init: 32310 2)
			)
			(10
				(people init: 32311 2)
			)
			(11
				(people init: 32312 2)
			)
			(12
				(people init: 32313 2)
			)
			(13
				(people init: 32314 2)
			)
			(14
				(people init: 32315 2)
			)
		)
	)
)

(instance sfx1 of Sound
	(properties)
)

(instance sfx2 of Sound
	(properties)
)

(instance sfx3 of Sound
	(properties)
)

