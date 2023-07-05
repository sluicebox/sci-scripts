;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 612)
(include sci.sh)
(use Main)
(use AudioScript)
(use Sync)
(use LoadMany)
(use Game)
(use Actor)
(use System)

(public
	endingSlide 0
)

(instance endingSlide of Rm
	(properties
		picture 65
		style 9
	)

	(method (init)
		(super init: &rest)
		(HandsOff)
		(gGame setCursor: gNarrator 1)
		(= global103 1)
		(Load rsPIC 55)
		(LoadMany rsVIEW 916 2 918 922)
		(theEgo x: 152 y: 146 view: 2 loop: 1 cel: 6 priority: 10 init:)
		(theHead x: 152 y: 146 z: 26 view: 2 loop: 4 cel: 5 priority: 10 init:)
		(cedric x: 232 y: 152 view: 720 loop: 2 cel: 2 priority: 11 init:)
		(coals x: 281 y: 152 view: 933 loop: 15 cel: 0 priority: 12 init:)
		(self setScript: endingCartoon)
	)
)

(instance endingCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: slEnd_Scene_1)
			)
			(1
				(DrawPic 55 10)
				(gCast eachElementDo: #hide)
				(gCast eachElementDo: #dispose)
				(gCast release:)
				(UnLoad 129 65)
				(Load rsPIC 217)
				(LoadMany rsVIEW 932)
				(= seconds 2)
			)
			(2
				(self setScript: slEnd_Scene_2)
			)
			(3
				(DrawPic 55 10)
				(gCast eachElementDo: #hide)
				(gCast eachElementDo: #dispose)
				(gCast release:)
				(UnLoad 129 217)
				(LoadMany rsVIEW 720 918 922 2 933 935 929 925 916)
				(Load rsPIC 65)
				(= seconds 2)
			)
			(4
				(self setScript: slEnd_Scene_3)
			)
			(5
				(DrawPic 55 10)
				(gCast eachElementDo: #hide)
				(gCast eachElementDo: #dispose)
				(gCast release:)
				(UnLoad 129 65)
				(LoadMany rsVIEW 936)
				(Load rsPIC 218)
				(= seconds 2)
			)
			(6
				(self setScript: slEnd_Scene_4)
			)
			(7
				(DrawPic 55 10)
				(gCast eachElementDo: #hide)
				(gCast eachElementDo: #dispose)
				(gCast release:)
				(UnLoad 129 218)
				(LoadMany rsVIEW 720 925 929 922 2 933 918 916)
				(Load rsPIC 65)
				(= seconds 2)
			)
			(8
				(self setScript: slEnd_Scene_5)
			)
			(9
				(= seconds 1)
			)
			(10
				(gCurRoom newRoom: 673) ; cdEnding4
			)
		)
	)
)

(instance slEnd_Scene_1 of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(syncIt init: setCycle: MouthSync 10121 hide:)
				(gGlobalAudio number: 10121 play:)
				(= waitForCue 8448)
			)
			(2
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo x: 87 y: 177 view: 916 loop: 0 cel: 3 priority: 13)
				(theHead hide:)
				(eMagic
					x: 87
					y: 167
					view: 916
					loop: 1
					cel: 0
					priority: 12
					init:
				)
				(= cycles 1)
			)
			(3
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 8704)
			)
			(4
				(DrawPic 65 9)
				(theEgo x: 87 y: 177 view: 2 loop: 7 cel: 2 priority: 13)
				(eMagic hide:)
				(theHead
					x: 87
					y: 177
					z: 26
					view: 2
					loop: 4
					cel: 3
					priority: 13
					show:
				)
				(eWand x: 98 y: 176 view: 916 loop: 3 cel: 4 priority: 13 init:)
				(cassima
					x: 6
					y: 148
					view: 918
					loop: 0
					cel: 4
					priority: 11
					init:
				)
				(= cycles 1)
			)
			(5
				(DrawPic 65 9)
				(cassima x: 35 y: 161 view: 918 loop: 1 cel: 2 priority: 12)
				(theEgo x: 87 y: 177 view: 916 loop: 4 cel: 4 priority: 13)
				(theHead hide:)
				(= cycles 1)
			)
			(6
				(DrawPic 65 9)
				(theEgo x: 87 y: 177 view: 916 loop: 4 cel: 4 priority: 13)
				(theMouth
					x: 52
					y: 145
					view: 918
					loop: 5
					cel: 3
					priority: 15
					init:
				)
				(cassima x: 52 y: 169 view: 918 loop: 2 cel: 2 priority: 13)
				(= waitForCue 10752)
			)
			(7
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo x: 87 y: 177 view: 916 loop: 4 cel: 0 priority: 13)
				(theMouth x: 71 y: 140 view: 922 loop: 10 cel: 0 priority: 13)
				(cassima x: 52 y: 169 view: 918 loop: 3 cel: 0 priority: 13)
				(cassimatheHead
					x: 53
					y: 145
					view: 918
					loop: 5
					cel: 0
					priority: 15
					init:
				)
				(crispin
					x: 68
					y: 163
					view: 922
					loop: 1
					cel: 0
					priority: 12
					init:
				)
				(= cycles 1)
			)
			(8
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(9
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(10
				(= seconds 1)
			)
			(11
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance slEnd_Scene_2 of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 217 10)
				(theEyes
					x: 213
					y: 79
					view: 932
					loop: 1
					cel: 0
					priority: 5
					init:
				)
				(eyelid x: 213 y: 79 view: 932 loop: 0 cel: 0 priority: 6 init:)
				(theMouth
					x: 212
					y: 90
					view: 932
					loop: 2
					cel: 2
					priority: 5
					init:
				)
				(= seconds 1)
			)
			(1
				(syncIt init: setCycle: MouthSync 10122 hide:)
				(gGlobalAudio number: 10122 play:)
				(= cycles 1)
			)
			(2
				(= cycles 1)
			)
			(3
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(= seconds 1)
			)
			(5
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance slEnd_Scene_3 of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 65 10)
				(cedric
					x: 232
					y: 152
					view: 720
					loop: 2
					cel: 2
					priority: 11
					init:
				)
				(cassima
					x: 52
					y: 169
					view: 918
					loop: 2
					cel: 0
					priority: 13
					init:
				)
				(crispin
					x: 68
					y: 163
					view: 922
					loop: 1
					cel: 7
					priority: 12
					init:
				)
				(crispinMouth
					x: 71
					y: 140
					view: 922
					loop: 10
					cel: 0
					priority: 10
					init:
				)
				(theEgo x: 87 y: 177 view: 2 loop: 7 cel: 1 priority: 13 init:)
				(theHead
					x: 87
					y: 177
					z: 26
					view: 2
					loop: 4
					cel: 5
					priority: 13
					init:
				)
				(coals
					x: 281
					y: 152
					view: 933
					loop: 15
					cel: 2
					priority: 12
					init:
				)
				(theMouth
					x: 53
					y: 145
					view: 918
					loop: 5
					cel: 0
					priority: 15
					hide:
					init:
				)
				(= seconds 1)
			)
			(1
				(UnLoad 129 218)
				(LoadMany rsVIEW 720 925 929 922 2 933 918 916)
				(= cycles 1)
			)
			(2
				(syncIt init: setCycle: MouthSync 10123 hide:)
				(gGlobalAudio number: 10123 play:)
				(= waitForCue 13824)
			)
			(3
				(Palette palSET_INTENSITY 0 255 0)
				(crispin loop: 2 cel: 3)
				(crispinMouth hide:)
				(theMouth
					x: 71
					y: 140
					view: 922
					loop: 10
					cel: 0
					priority: 13
					hide:
				)
				(cMagic
					x: 63
					y: 180
					view: 935
					loop: 3
					cel: 4
					priority: 13
					init:
				)
				(= cycles 1)
			)
			(4
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 14336)
			)
			(5
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo cel: 0)
				(theHead cel: 1)
				(theMouth
					x: 71
					y: 140
					view: 922
					loop: 10
					cel: 0
					priority: 13
					hide:
				)
				(cMagic hide:)
				(alexander
					x: 127
					y: 138
					view: 929
					loop: 0
					cel: 12
					priority: 10
					init:
				)
				(= cycles 1)
			)
			(6
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 14848)
			)
			(7
				(Palette palSET_INTENSITY 0 255 0)
				(cassima loop: 6 cel: 0)
				(theMouth
					x: 71
					y: 140
					view: 922
					loop: 10
					cel: 0
					priority: 13
					hide:
				)
				(rosella
					x: 118
					y: 136
					view: 925
					loop: 2
					cel: 13
					priority: 9
					init:
				)
				(= cycles 1)
			)
			(8
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 15360)
			)
			(9
				(Palette palSET_INTENSITY 0 255 0)
				(crispin loop: 7 cel: 5)
				(theEgo cel: 3)
				(theHead cel: 7)
				(theMouth
					x: 71
					y: 140
					view: 922
					loop: 10
					cel: 0
					priority: 13
					hide:
				)
				(rosella loop: 3 cel: 5)
				(valanice
					x: 108
					y: 138
					view: 925
					loop: 1
					cel: 2
					priority: 10
					init:
				)
				(= cycles 1)
			)
			(10
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 15616)
			)
			(11
				(Palette palSET_INTENSITY 0 255 0)
				(theHead hide:)
				(theEgo x: 115 y: 139 view: 916 loop: 6 cel: 2 priority: 10)
				(theMouth
					x: 71
					y: 140
					view: 922
					loop: 10
					cel: 0
					priority: 13
					hide:
				)
				(alexander hide:)
				(rosella hide:)
				(valanice loop: 0 cel: 13 show:)
				(= cycles 1)
			)
			(12
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 16640)
			)
			(13
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo x: 96 y: 139 view: 916 loop: 10 cel: 0 priority: 10)
				(theMouth hide:)
				(alexander show:)
				(rosella loop: 2 cel: 13 show:)
				(= cycles 1)
			)
			(14
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(15
				(DrawPic 65 9)
				(cassima x: 92 y: 167 view: 918 loop: 6 cel: 1 priority: 12)
				(theEgo x: 96 y: 139 view: 2 loop: 7 cel: 2 priority: 10)
				(theHead
					x: 96
					y: 139
					z: 26
					view: 2
					loop: 4
					cel: 3
					priority: 10
					show:
				)
				(= cycles 1)
			)
			(16
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(17
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(18
				(= seconds 1)
			)
			(19
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance slEnd_Scene_4 of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 218 10)
				(theMouth
					x: 116
					y: 34
					view: 936
					loop: 0
					cel: 2
					priority: 0
					init:
				)
				(arm x: 90 y: 40 view: 936 loop: 1 cel: 0 priority: 0 init:)
				(casEyes x: 64 y: 28 view: 936 loop: 2 cel: 0 priority: 0 init:)
				(alBlinking
					x: 260
					y: 18
					view: 936
					loop: 4
					cel: 0
					priority: 0
					init:
				)
				(valBlinking
					x: 144
					y: 32
					view: 936
					loop: 5
					cel: 0
					priority: 0
					init:
				)
				(rosEyes
					x: 202
					y: 37
					view: 936
					loop: 6
					cel: 0
					priority: 0
					init:
				)
				(= seconds 1)
			)
			(1
				(syncIt init: setCycle: MouthSync 10124 hide:)
				(gGlobalAudio number: 10124 play:)
				(= cycles 1)
			)
			(2
				(DrawPic 218 9)
				(theMouth x: 116 y: 34 view: 936 loop: 0 cel: 1 priority: 0)
				(arm x: 90 y: 40 view: 936 loop: 1 cel: 2 priority: 0)
				(= cycles 1)
			)
			(3
				(DrawPic 218 9)
				(theMouth x: 116 y: 34 view: 936 loop: 0 cel: 3 priority: 0)
				(arm x: 90 y: 40 view: 936 loop: 1 cel: 0 priority: 0)
				(= waitForCue 17408)
			)
			(4
				(Palette palSET_INTENSITY 0 255 0)
				(theMouth x: 270 y: 32 view: 936 loop: 3 cel: 1 priority: 0)
				(= cycles 1)
			)
			(5
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(6
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(7
				(= seconds 1)
			)
			(8
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance slEnd_Scene_5 of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 65 10)
				(cedric
					x: 232
					y: 152
					view: 720
					loop: 2
					cel: 2
					priority: 11
					init:
				)
				(valanice
					x: 106
					y: 134
					view: 925
					loop: 0
					cel: 13
					priority: 9
					init:
				)
				(rosella
					x: 116
					y: 135
					view: 925
					loop: 2
					cel: 13
					priority: 9
					init:
				)
				(alexander
					x: 89
					y: 136
					view: 929
					loop: 5
					cel: 3
					priority: 15
					init:
				)
				(crispin
					x: 68
					y: 163
					view: 922
					loop: 7
					cel: 5
					priority: 12
					init:
				)
				(theEgo x: 94 y: 135 view: 2 loop: 7 cel: 2 priority: 9 init:)
				(theHead
					x: 94
					y: 135
					z: 26
					view: 2
					loop: 4
					cel: 3
					priority: 9
					init:
				)
				(coals
					x: 281
					y: 152
					view: 933
					loop: 15
					cel: 2
					priority: 12
					init:
				)
				(theMouth
					x: 53
					y: 145
					view: 918
					loop: 5
					cel: 0
					priority: 10
					init:
					hide:
				)
				(= seconds 1)
			)
			(1
				(syncIt init: setCycle: MouthSync 10125 hide:)
				(gGlobalAudio number: 10125 play:)
				(= waitForCue 5888)
			)
			(2
				(Palette palSET_INTENSITY 0 255 0)
				(valanice hide:)
				(rosella hide:)
				(alexander hide:)
				(cassima
					x: 71
					y: 135
					view: 933
					loop: 7
					cel: 0
					priority: 9
					init:
				)
				(crispin x: 68 y: 163 view: 922 loop: 1 cel: 7 priority: 10)
				(theEgo x: 98 y: 136 view: 933 loop: 0 cel: 0 priority: 9 init:)
				(theHead hide:)
				(alextheHead
					x: 81
					y: 110
					view: 933
					loop: 12
					cel: 0
					priority: 7
					init:
				)
				(= cycles 1)
			)
			(3
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 6656)
			)
			(4
				(Palette palSET_INTENSITY 0 255 0)
				(cassima x: 71 y: 135 view: 933 loop: 7 cel: 0 priority: 9)
				(crispin x: 68 y: 163 view: 922 loop: 1 cel: 7 priority: 10)
				(cMagic
					x: 63
					y: 180
					view: 935
					loop: 3
					cel: 4
					priority: 14
					init:
				)
				(= cycles 1)
			)
			(5
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(6
				(DrawPic 65 9)
				(cassima x: 71 y: 135 view: 933 loop: 7 cel: 0 priority: 9)
				(crispin x: 68 y: 163 view: 922 loop: 9 cel: 1 priority: 10)
				(theEgo x: 98 y: 136 view: 933 loop: 0 cel: 0 priority: 9)
				(cMagic hide:)
				(bottle
					x: 81
					y: 187
					view: 922
					loop: 6
					cel: 0
					priority: 15
					init:
				)
				(= waitForCue 7936)
			)
			(7
				(Palette palSET_INTENSITY 0 255 0)
				(cassima x: 71 y: 135 view: 933 loop: 7 cel: 0 priority: 9)
				(crispin x: 68 y: 163 view: 922 loop: 8 cel: 3 priority: 10)
				(theEgo x: 98 y: 136 view: 933 loop: 0 cel: 0 priority: 9)
				(theMouth
					x: 93
					y: 110
					view: 916
					loop: 9
					cel: 2
					priority: 10
					show:
				)
				(= cycles 1)
			)
			(8
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 9216)
			)
			(9
				(Palette palSET_INTENSITY 0 255 0)
				(cassima x: 71 y: 135 view: 933 loop: 7 cel: 0 priority: 9)
				(crispin x: 68 y: 163 view: 922 loop: 9 cel: 0 priority: 10)
				(theEgo x: 98 y: 136 view: 933 loop: 8 cel: 0 priority: 9)
				(theEgoTemp
					x: 93
					y: 136
					view: 916
					loop: 8
					cel: 1
					priority: 9
					init:
				)
				(= cycles 1)
			)
			(10
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 9728)
			)
			(11
				(Palette palSET_INTENSITY 0 255 0)
				(cassima x: 71 y: 135 view: 933 loop: 7 cel: 0 priority: 9)
				(crispin x: 68 y: 163 view: 922 loop: 9 cel: 1 priority: 10)
				(theEgo x: 98 y: 136 view: 933 loop: 0 cel: 0 priority: 9)
				(theEgoTemp hide:)
				(theMouth hide:)
				(= cycles 1)
			)
			(12
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 10320)
			)
			(13
				(Palette palSET_INTENSITY 0 255 0)
				(cedric x: 232 y: 152 view: 720 loop: 6 cel: 3 priority: 11)
				(cassima x: 71 y: 135 view: 933 loop: 7 cel: 0 priority: 9)
				(crispin x: 68 y: 163 view: 922 loop: 8 cel: 0 priority: 10)
				(theEgo x: 98 y: 136 view: 933 loop: 0 cel: 0 priority: 9)
				(theMouth
					x: 229
					y: 144
					view: 720
					loop: 7
					cel: 1
					priority: 10
					show:
				)
				(= cycles 1)
			)
			(14
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 11264)
			)
			(15
				(Palette palSET_INTENSITY 0 255 0)
				(cassima x: 71 y: 135 view: 933 loop: 7 cel: 0 priority: 9)
				(crispin x: 68 y: 163 view: 922 loop: 9 cel: 0 priority: 10)
				(theEgo x: 98 y: 136 view: 933 loop: 0 cel: 0 priority: 9)
				(theMouth x: 81 y: 110 view: 933 loop: 13 cel: 0 priority: 12)
				(alextheHead hide:)
				(= cycles 1)
			)
			(16
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 12800)
			)
			(17
				(Palette palSET_INTENSITY 0 255 0)
				(crispin x: 68 y: 163 view: 922 loop: 8 cel: 0 priority: 10)
				(cassima hide:)
				(theEgo x: 98 y: 136 view: 933 loop: 0 cel: 0 priority: 9)
				(theMouth x: 93 y: 110 view: 916 loop: 9 cel: 0 priority: 10)
				(alextheHead
					x: 81
					y: 110
					view: 933
					loop: 12
					cel: 0
					priority: 7
					show:
				)
				(= cycles 1)
			)
			(18
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 13056)
			)
			(19
				(Palette palSET_INTENSITY 0 255 0)
				(crispin x: 68 y: 163 view: 922 loop: 8 cel: 0 priority: 10)
				(theEgo x: 98 y: 136 view: 933 loop: 0 cel: 0 priority: 9)
				(theMouth x: 93 y: 110 view: 916 loop: 9 cel: 3 priority: 10)
				(= cycles 1)
			)
			(20
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 14416)
			)
			(21
				(Palette palSET_INTENSITY 0 255 0)
				(crispin x: 68 y: 163 view: 922 loop: 8 cel: 3 priority: 10)
				(alextheHead hide:)
				(theMouth hide:)
				(theEgo x: 98 y: 136 view: 933 loop: 1 cel: 0 priority: 9 hide:)
				(= cycles 1)
			)
			(22
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(23
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(24
				(= seconds 1)
			)
			(25
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance theEgo of View
	(properties
		x 152
		y 146
		view 2
		loop 1
		cel 6
		priority 10
		signal 16400
	)
)

(instance theHead of View
	(properties
		x 152
		y 146
		z 26
		view 2
		loop 4
		cel 5
		priority 10
		signal 16400
	)
)

(instance cedric of View
	(properties
		x 232
		y 152
		view 720
		loop 2
		cel 2
		priority 11
		signal 16400
	)
)

(instance coals of View
	(properties
		x 281
		y 152
		view 933
		loop 15
		priority 12
		signal 16400
	)
)

(instance theMouth of View
	(properties
		x 53
		y 145
		view 918
		loop 5
		priority 10
		signal 16400
	)
)

(instance eMagic of View
	(properties
		x 87
		y 167
		view 916
		loop 1
		cel 3
		priority 12
		signal 16400
	)
)

(instance eWand of View
	(properties
		x 98
		y 176
		view 916
		loop 3
		cel 4
		priority 13
		signal 16400
	)
)

(instance cassima of View
	(properties
		x 6
		y 148
		view 918
		cel 4
		priority 11
		signal 16400
	)
)

(instance crispin of View
	(properties
		x 68
		y 163
		view 922
		loop 1
		priority 12
		signal 16400
	)
)

(instance theEyes of View
	(properties
		x 213
		y 79
		view 932
		loop 1
		priority 5
		signal 16400
	)
)

(instance eyelid of View
	(properties
		x 213
		y 79
		view 932
		priority 6
		signal 16400
	)
)

(instance crispinMouth of View
	(properties
		x 71
		y 140
		view 922
		loop 10
		priority 10
		signal 16400
	)
)

(instance cMagic of View
	(properties
		x 63
		y 180
		view 935
		loop 3
		cel 4
		priority 13
	)
)

(instance alexander of View
	(properties
		x 127
		y 138
		view 929
		cel 12
		priority 10
		signal 16400
	)
)

(instance rosella of View
	(properties
		x 118
		y 136
		view 925
		loop 2
		cel 13
		priority 9
		signal 16400
	)
)

(instance valanice of View
	(properties
		x 108
		y 138
		view 925
		loop 1
		cel 2
		priority 10
		signal 16400
	)
)

(instance arm of View
	(properties
		x 90
		y 40
		view 936
		loop 1
		signal 16400
	)
)

(instance casEyes of View
	(properties
		x 64
		y 28
		view 936
		loop 2
		signal 16400
	)
)

(instance alBlinking of View
	(properties
		x 260
		y 18
		view 936
		loop 4
		signal 16400
	)
)

(instance valBlinking of View
	(properties
		x 144
		y 32
		view 936
		loop 5
		signal 16400
	)
)

(instance rosEyes of View
	(properties
		x 202
		y 37
		view 936
		loop 6
		signal 16400
	)
)

(instance alextheHead of View
	(properties
		x 81
		y 110
		view 933
		loop 12
		priority 7
		signal 16400
	)
)

(instance bottle of View
	(properties
		x 81
		y 187
		view 922
		loop 6
		priority 15
		signal 16400
	)
)

(instance family of View ; UNUSED
	(properties
		x 151
		y 183
		view 934
		loop 2
		cel 4
		priority 14
		signal 16400
	)
)

(instance eHead of View ; UNUSED
	(properties
		x 145
		y 157
		view 934
		loop 3
		priority 13
		signal 16400
	)
)

(instance valHead of View ; UNUSED
	(properties
		x 156
		y 158
		view 934
		loop 11
		priority 11
		signal 16400
	)
)

(instance cassimatheHead of View
	(properties
		x 53
		y 145
		view 918
		loop 5
		priority 15
		signal 16400
	)
)

(instance theEgoTemp of View
	(properties
		x 93
		y 136
		view 916
		loop 8
		cel 1
		priority 9
		signal 16400
	)
)

(instance syncIt of Prop
	(properties)
)

