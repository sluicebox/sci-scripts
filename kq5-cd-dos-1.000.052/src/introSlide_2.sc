;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 611)
(include sci.sh)
(use Main)
(use AudioScript)
(use Sync)
(use LoadMany)
(use Game)
(use Actor)
(use System)

(public
	introSlide_2 0
)

(local
	[local0 5]
)

(instance introSlide_2 of Rm
	(properties
		picture 68
	)

	(method (init)
		(super init: &rest)
		(gGame setCursor: gNarrator 1)
		(= global103 1)
		(Load rsPIC 55)
		(LoadMany rsVIEW 750 760)
		(theEgo init:)
		(owl init:)
		(self setScript: openingCartoon)
	)
)

(instance openingCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom setRegions: 769) ; introtoonRegion
				(= cycles 1)
			)
			(1
				(self setScript: scene9Script)
			)
			(2
				(DrawPic 55 10)
				(gCast eachElementDo: #hide)
				(gCast eachElementDo: #dispose)
				(gCast release:)
				(UnLoad 129 68)
				(Load rsPIC 73)
				(LoadMany rsVIEW 750 751 760)
				(Load rsPIC 74)
				(= seconds 2)
			)
			(3
				(self setScript: scene11Script)
			)
			(4
				(DrawPic 55 10)
				(gCast eachElementDo: #hide)
				(gCast eachElementDo: #dispose)
				(gCast release:)
				(UnLoad 129 73)
				(UnLoad 129 74)
				(Load rsPIC 1)
				(LoadMany rsVIEW 139 752 136 770 762 1073 2)
				(Load rsPIC 75)
				(= seconds 2)
			)
			(5
				(self setScript: scene12Script)
			)
			(6
				(DrawPic 55 10)
				(gCast eachElementDo: #hide)
				(gCast eachElementDo: #dispose)
				(gCast release:)
				(UnLoad 129 73)
				(UnLoad 129 74)
				(Load rsPIC 76)
				(LoadMany
					rsVIEW
					1101
					777
					768
					764
					779
					783
					766
					767
					771
					1102
					1100
					775
					765
					1103
					769
					0
				)
				(= seconds 2)
			)
			(7
				(self setScript: scene13Script)
			)
			(8
				(= seconds 1)
			)
			(9
				(HandsOn)
				(gCurRoom newRoom: 1)
			)
		)
	)
)

(instance scene9Script of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(syncIt init: setCycle: MouthSync 10109 hide:)
				(gGlobalAudio number: 10109 play:)
				(= waitForCue 14340)
			)
			(2
				(DrawPic 68 9)
				(theEgo x: 106 y: 144 loop: 0 cel: 5 priority: 5)
				(owl x: 147 y: 82 loop: 2 cel: 0 priority: 4)
				(= cycles 5)
			)
			(3
				(DrawPic 68 9)
				(theEgo x: 169 y: 120 loop: 0 cel: 2 priority: 5)
				(owl x: 210 y: 70 loop: 2 cel: 1 priority: 3)
				(= waitForCue 16388)
			)
			(4
				(DrawPic 68 9)
				(owl x: 224 y: 46 loop: 5 cel: 14 priority: 3)
				(theEgo x: 233 y: 72 z: 0 view: 750 loop: 2 cel: 3 priority: 5)
				(= cycles 1)
			)
			(5
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(6
				(= seconds 1)
			)
			(7
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance scene11Script of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 73 10)
				(theEgo
					x: 254
					y: 140
					view: 750
					loop: 4
					cel: 3
					priority: 5
					init:
				)
				(water init:)
				(owl x: 192 y: 128 view: 760 loop: 6 cel: 0 priority: 7 init:)
				(= seconds 4)
			)
			(1
				(syncIt init: setCycle: MouthSync 10111 hide:)
				(gGlobalAudio number: 10111 play:)
				(= seconds 1)
			)
			(2
				(DrawPic 73 9)
				(theEgo x: 232 y: 110 loop: 4 cel: 3)
				(owl x: 182 y: 70 z: 0 view: 760 loop: 7 cel: 4 priority: 3)
				(= seconds 4)
			)
			(3
				(DrawPic 73 9)
				(owl x: 151 y: 70 loop: 7 cel: 14 priority: 3)
				(theEgo x: 180 y: 74 loop: 5 cel: 9)
				(= seconds 6)
			)
			(4
				(DrawPic 74 10)
				(theEgo x: 163 y: 224 loop: 6 cel: 2)
				(water hide:)
				(owl x: 251 y: 177 loop: 8 cel: 3 priority: 13)
				(= seconds 4)
			)
			(5
				(DrawPic 74 9)
				(theEgo x: 159 y: 196 view: 750 loop: 6 cel: 2)
				(owl x: 251 y: 160 loop: 8 cel: 3 priority: 13)
				(= seconds 5)
			)
			(6
				(DrawPic 74 9)
				(theEgo x: 159 y: 180 loop: 6 cel: 2)
				(owl x: 251 y: 140 loop: 8 cel: 3)
				(= waitForCue 16900)
			)
			(7
				(DrawPic 74 9)
				(theEgo x: 159 y: 150 loop: 6 cel: 3)
				(owl x: 254 y: 120 loop: 10 cel: 0 priority: 9)
				(= cycles 1)
			)
			(8
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 17412)
			)
			(9
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 230 y: 100 loop: 13 cel: 2)
				(theEgo x: 149 y: 138 loop: 6 cel: 4)
				(= cycles 1)
			)
			(10
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(11
				(DrawPic 74 100)
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 215 y: 90 loop: 13 cel: 6)
				(theEgo x: 138 y: 118 loop: 8 cel: 6)
				(= cycles 1)
			)
			(12
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(13
				(DrawPic 74 100)
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 170 y: 100 loop: 13 cel: 8)
				(theEgo x: 139 y: 100 loop: 8 cel: 8)
				(= cycles 1)
			)
			(14
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(15
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(16
				(= seconds 1)
			)
			(17
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance scene12Script of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 1 100)
				(owl x: 161 y: 34 view: 139 loop: 7 cel: 1 priority: 0 init:)
				(door init:)
				(smoke init:)
				(water x: 256 y: 154 view: 770 loop: 0 cel: 0 priority: 1 init:)
				(rippling init:)
				(rippling2 init:)
				(rail init:)
				(= cycles 1)
			)
			(1
				(syncIt init: setCycle: MouthSync 10112 hide:)
				(gGlobalAudio number: 10112 play:)
				(= cycles 1)
			)
			(2
				(DrawPic 1 9)
				(owl x: 108 y: 94 view: 136 loop: 0 cel: 1 priority: 5)
				(lWing init:)
				(rWing init:)
				(owlHead init:)
				(= waitForCue 18004)
			)
			(3
				(= seconds 1)
			)
			(4
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo
					x: 205
					y: 60
					view: 752
					loop: 0
					cel: 2
					priority: 11
					init:
				)
				(= cycles 1)
			)
			(5
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 18180)
			)
			(6
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo x: 205 y: 157 view: 752 loop: 1 cel: 2 priority: 11)
				(= cycles 1)
			)
			(7
				(Palette palSET_INTENSITY 0 255 100)
				(= cycles 1)
			)
			(8
				(DrawPic 1 9)
				(theEgo x: 205 y: 157 view: 752 loop: 1 cel: 4 priority: 11)
				(= cycles 1)
			)
			(9
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 18688)
			)
			(10
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo x: 205 y: 157 view: 752 loop: 2 cel: 3 priority: 11)
				(door x: 170 y: 96 view: 770 loop: 5 cel: 3 priority: 1)
				(crispin init:)
				(= cycles 1)
			)
			(11
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 21248)
			)
			(12
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo x: 205 y: 157 view: 752 loop: 2 cel: 4 priority: 11)
				(theMouth hide:)
				(crispin x: 180 y: 138 view: 762 loop: 10 cel: 0 priority: 9)
				(= cycles 1)
			)
			(13
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 21504)
			)
			(14
				(DrawPic 75 10)
				(gCast eachElementDo: #hide)
				(theMouth
					x: 158
					y: 83
					view: 1073
					loop: 0
					cel: 6
					priority: 9
					show:
				)
				(cEyes init:)
				(cEyeBrows init:)
				(= waitForCue 22020)
			)
			(15
				(DrawPic 1 10)
				(cEyes hide:)
				(cEyeBrows hide:)
				(theEgo
					x: 205
					y: 157
					view: 752
					loop: 4
					cel: 10
					priority: 11
					show:
				)
				(rail show:)
				(owl x: 108 y: 94 view: 136 loop: 0 cel: 1 priority: 5 show:)
				(door show:)
				(smoke show:)
				(water show:)
				(lWing show:)
				(rWing show:)
				(owlHead show:)
				(theMouth x: 176 y: 117 view: 762 loop: 11 cel: 2 priority: 10)
				(crispin
					x: 180
					y: 138
					view: 762
					loop: 9
					cel: 0
					priority: 9
					show:
				)
				(= cycles 1)
			)
			(16
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 24576)
			)
			(17
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo x: 193 y: 145 view: 2 loop: 1 cel: 0 priority: 10)
				(theHead init:)
				(owl x: 141 y: 91 view: 139 loop: 9 cel: 1 priority: 5)
				(theMouth hide:)
				(crispin x: 180 y: 138 view: 762 loop: 9 cel: 0 priority: 9)
				(owlHead hide:)
				(rWing hide:)
				(lWing hide:)
				(= cycles 1)
			)
			(18
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 24656)
			)
			(19
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo x: 181 y: 142 view: 2 loop: 1 cel: 7 priority: 9)
				(theHead x: 181 y: 142 z: 25 view: 2 loop: 4 cel: 5 priority: 9)
				(owl hide:)
				(crispin x: 142 y: 127 view: 762 loop: 1 cel: 3 priority: 8)
				(= cycles 1)
			)
			(20
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 4)
			)
			(21
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo x: 149 y: 121 view: 2 loop: 3 cel: 1 priority: 8)
				(crispin hide:)
				(theHead x: 149 y: 121 z: 27 view: 2 loop: 4 cel: 7 priority: 8)
				(= cycles 1)
			)
			(22
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 2)
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

(instance scene13Script of AudioScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 76 10)
				(owl x: 90 y: 109 view: 768 loop: 2 cel: 1 priority: 7 init:)
				(crispin
					x: 140
					y: 124
					view: 764
					loop: 0
					cel: 0
					priority: 9
					init:
				)
				(trunk
					x: 219
					y: 118
					view: 1101
					loop: 0
					cel: 0
					priority: 8
					init:
				)
				(theEgo
					x: 173
					y: 125
					view: 779
					loop: 1
					cel: 6
					priority: 8
					init:
				)
				(theMouth
					x: 133
					y: 88
					view: 783
					loop: 1
					cel: 0
					priority: 15
					init:
				)
				(= seconds 1)
			)
			(1
				(syncIt init: setCycle: MouthSync 10113 hide:)
				(gGlobalAudio number: 10113 play:)
				(= waitForCue 4608)
			)
			(2
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 90 y: 109 view: 768 loop: 2 cel: 2 priority: 7)
				(theEgo
					x: 173
					y: 125
					view: 767
					loop: 2
					cel: 7
					priority: 8
					hide:
				)
				(theMouth x: 173 y: 125 view: 767 loop: 7 cel: 1 priority: 15)
				(eCup x: 155 y: 103 view: 777 loop: 0 cel: 1 priority: 6 init:)
				(= cycles 1)
			)
			(3
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 5378)
			)
			(4
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 90 y: 109 view: 768 loop: 2 cel: 2 priority: 7)
				(crispin hide:)
				(theEgo
					x: 173
					y: 125
					view: 779
					loop: 1
					cel: 0
					priority: 8
					show:
				)
				(theMouth x: 135 y: 87 view: 783 loop: 1 cel: 0 priority: 15)
				(cTop x: 135 y: 107 view: 764 loop: 2 cel: 3 priority: 9 init:)
				(eCup hide:)
				(cBottom
					x: 140
					y: 124
					view: 764
					loop: 0
					cel: 1
					priority: 8
					init:
				)
				(= cycles 1)
			)
			(5
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 5888)
			)
			(6
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 90 y: 109 view: 768 loop: 0 cel: 0 priority: 7)
				(owlHead
					x: 92
					y: 102
					view: 768
					loop: 1
					cel: 2
					priority: 8
					init:
				)
				(owlMouth
					x: 94
					y: 94
					view: 768
					loop: 3
					cel: 0
					priority: 8
					init:
				)
				(rWing x: 86 y: 100 view: 768 loop: 4 cel: 3 priority: 8 init:)
				(theEgo x: 173 y: 125 view: 779 loop: 1 cel: 5 priority: 8)
				(theMouth x: 94 y: 94 view: 768 loop: 3 cel: 0 priority: 8)
				(cTop x: 135 y: 107 view: 764 loop: 2 cel: 0 priority: 9)
				(cBottom x: 140 y: 124 view: 764 loop: 0 cel: 1 priority: 8)
				(= cycles 1)
			)
			(7
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 6400)
			)
			(8
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 90 y: 109 view: 768 loop: 0 cel: 0 priority: 7)
				(rWing x: 86 y: 100 view: 768 loop: 4 cel: 0 priority: 8)
				(theEgo x: 173 y: 125 view: 766 loop: 0 cel: 0 priority: 8)
				(theMouth x: 135 y: 107 view: 764 loop: 6 cel: 0 priority: 8)
				(cTop hide:)
				(eCup show:)
				(cBottom x: 140 y: 124 view: 764 loop: 0 cel: 1 priority: 8)
				(= cycles 1)
			)
			(9
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 8960)
			)
			(10
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 90 y: 109 view: 768 loop: 6 cel: 2 priority: 7)
				(owlHead hide:)
				(owlMouth hide:)
				(rWing hide:)
				(theEgo x: 173 y: 125 view: 779 loop: 0 cel: 1 priority: 8)
				(theMouth x: 96 y: 94 view: 768 loop: 3 cel: 1 priority: 8)
				(cTop x: 135 y: 107 view: 764 loop: 6 cel: 0 priority: 9 show:)
				(cBottom x: 140 y: 124 view: 764 loop: 0 cel: 1 priority: 8)
				(= cycles 1)
			)
			(11
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 9728)
			)
			(12
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 90 y: 109 view: 768 loop: 0 cel: 0 priority: 7)
				(owlHead show:)
				(owlMouth show:)
				(rWing x: 86 y: 100 view: 768 loop: 4 cel: 1 priority: 8 show:)
				(theEgo x: 173 y: 125 view: 779 loop: 1 cel: 5 priority: 8)
				(theMouth x: 119 y: 88 view: 783 loop: 8 cel: 2 priority: 15)
				(cTop hide:)
				(eCup hide:)
				(cBottom x: 140 y: 124 view: 764 loop: 7 cel: 5 priority: 9)
				(= cycles 1)
			)
			(13
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 10240)
			)
			(14
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 90 y: 109 view: 768 loop: 0 cel: 0 priority: 7)
				(rWing x: 86 y: 100 view: 768 loop: 4 cel: 0 priority: 8)
				(theMouth x: 135 y: 107 view: 764 loop: 6 cel: 3 priority: 8)
				(cBottom x: 140 y: 124 view: 764 loop: 0 cel: 1 priority: 9)
				(= cycles 1)
			)
			(15
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 12288)
			)
			(16
				(DrawPic 76 9)
				(owl x: 90 y: 109 view: 768 loop: 0 cel: 0 priority: 7)
				(cBottom hide:)
				(cTop hide:)
				(theMouth hide:)
				(crispin
					x: 140
					y: 124
					view: 771
					loop: 0
					cel: 2
					priority: 14
					show:
				)
				(= cycles 1)
			)
			(17
				(DrawPic 76 9)
				(owl x: 90 y: 109 view: 768 loop: 0 cel: 0 priority: 7)
				(crispin x: 140 y: 124 view: 771 loop: 10 cel: 1 priority: 14)
				(= cycles 1)
			)
			(18
				(DrawPic 76 9)
				(owl x: 90 y: 109 view: 768 loop: 0 cel: 0 priority: 7)
				(crispin x: 157 y: 126 view: 1102 loop: 1 cel: 5 priority: 14)
				(= cycles 1)
			)
			(19
				(DrawPic 76 9)
				(owl x: 90 y: 109 view: 768 loop: 0 cel: 0 priority: 7)
				(crispin x: 207 y: 126 view: 1102 loop: 3 cel: 1 priority: 14)
				(eCup show:)
				(theEgo x: 173 y: 125 view: 1100 loop: 4 cel: 0 priority: 8)
				(= waitForCue 12544)
			)
			(20
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 90 y: 109 view: 768 loop: 0 cel: 0 priority: 7)
				(crispin x: 219 y: 118 view: 775 loop: 4 cel: 10 priority: 14)
				(trunk cel: 6)
				(= cycles 1)
			)
			(21
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 14336)
			)
			(22
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 90 y: 109 view: 768 loop: 0 cel: 0 priority: 7)
				(crispin x: 217 y: 114 view: 765 loop: 2 cel: 2 priority: 14)
				(theEgo x: 173 y: 125 view: 1100 loop: 4 cel: 2 priority: 8)
				(= cycles 1)
			)
			(23
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 17232)
			)
			(24
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 90 y: 109 view: 768 loop: 0 cel: 0 priority: 7)
				(crispin hide:)
				(theEgo x: 173 y: 125 view: 1100 loop: 5 cel: 1 priority: 8)
				(cTop x: 206 y: 100 view: 765 loop: 5 cel: 6 priority: 10 show:)
				(cBottom
					x: 211
					y: 114
					view: 765
					loop: 4
					cel: 0
					priority: 9
					show:
				)
				(= cycles 1)
			)
			(25
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 17664)
			)
			(26
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 90 y: 109 view: 768 loop: 0 cel: 0 priority: 7)
				(cTop hide:)
				(cBottom hide:)
				(crispin
					x: 217
					y: 114
					view: 1103
					loop: 0
					cel: 3
					priority: 14
					show:
				)
				(theEgo x: 173 y: 125 view: 769 loop: 3 cel: 1 priority: 8)
				(= cycles 1)
			)
			(27
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 18688)
			)
			(28
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 90 y: 109 view: 768 loop: 0 cel: 0 priority: 7)
				(cTop hide:)
				(cBottom hide:)
				(rWing x: 86 y: 100 view: 768 loop: 4 cel: 3 priority: 8)
				(crispin
					x: 217
					y: 114
					view: 1103
					loop: 1
					cel: 3
					priority: 14
					show:
				)
				(theEgo x: 173 y: 125 view: 766 loop: 0 cel: 0 priority: 8)
				(theMouth
					x: 94
					y: 94
					view: 768
					loop: 3
					cel: 1
					priority: 8
					show:
				)
				(= cycles 1)
			)
			(29
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 20736)
			)
			(30
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 90 y: 109 view: 768 loop: 0 cel: 0 priority: 7)
				(rWing x: 86 y: 100 view: 768 loop: 4 cel: 0 priority: 8)
				(theEgo x: 173 y: 125 view: 1100 loop: 4 cel: 0 priority: 8)
				(theMouth
					x: 172
					y: 125
					z: 36
					view: 766
					loop: 3
					cel: 2
					priority: 15
				)
				(= cycles 1)
			)
			(31
				(Palette palSET_INTENSITY 0 255 100)
				(= waitForCue 20992)
			)
			(32
				(Palette palSET_INTENSITY 0 255 0)
				(owl x: 117 y: 117 view: 768 loop: 9 cel: 2 priority: 8)
				(owlHead hide:)
				(owlMouth hide:)
				(rWing hide:)
				(crispin x: 217 y: 114 view: 771 loop: 11 cel: 2 priority: 14)
				(theMouth hide:)
				(= cycles 1)
			)
			(33
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 4)
			)
			(34
				(Palette palSET_INTENSITY 0 255 0)
				(theEgo x: 169 y: 135 view: 0 loop: 2 cel: 5 priority: 9)
				(owl hide:)
				(theHead
					x: 169
					y: 135
					z: 39
					view: 0
					loop: 4
					cel: 3
					priority: 9
					init:
				)
				(= cycles 1)
			)
			(35
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 3)
			)
			(36
				(if (!= (DoAudio audPOSITION) -1)
					(-- state)
				)
				(= cycles 1)
			)
			(37
				(= seconds 1)
			)
			(38
				(client cue:)
				(self dispose:)
			)
		)
	)
)

(instance theEgo of View
	(properties
		x 46
		y 166
		view 750
		cel 1
		priority 5
		signal 16400
	)
)

(instance owl of View
	(properties
		x 66
		y 96
		view 760
		loop 2
		cel 1
		priority 5
		signal 16400
	)
)

(instance water of View
	(properties
		x 157
		y 148
		view 751
		cel 2
		priority 11
		signal 16400
	)
)

(instance rippling of View
	(properties
		x 158
		y 168
		view 770
		loop 1
		priority 1
		signal 16400
	)
)

(instance rippling2 of View
	(properties
		x 79
		y 154
		view 770
		loop 2
		priority 1
		signal 16400
	)
)

(instance rail of View
	(properties
		x 123
		y 161
		view 770
		loop 4
		cel 1
		priority 15
		signal 16400
	)
)

(instance smoke of View
	(properties
		x 188
		y 8
		view 770
		loop 6
		signal 16400
	)
)

(instance cEyes of View
	(properties
		x 175
		y 47
		view 1073
		loop 2
		priority 10
		signal 16400
	)
)

(instance cEyeBrows of View
	(properties
		x 175
		y 47
		view 1073
		loop 1
		priority 9
		signal 16400
	)
)

(instance door of View
	(properties
		x 170
		y 96
		view 770
		loop 5
		priority 1
		signal 16400
	)
)

(instance theMouth of View
	(properties
		x 144
		y 105
		view 762
		loop 2
		cel 1
		priority 9
		signal 16400
	)
)

(instance lWing of View
	(properties
		x 107
		y 87
		view 136
		loop 4
		priority 6
		signal 16400
	)
)

(instance rWing of View
	(properties
		x 114
		y 87
		view 136
		loop 6
		priority 6
		signal 16400
	)
)

(instance owlHead of View
	(properties
		x 108
		y 87
		view 136
		loop 1
		cel 2
		priority 6
		signal 16400
	)
)

(instance theHead of View
	(properties
		x 193
		y 145
		z 25
		view 2
		loop 4
		cel 5
		priority 10
		signal 16400
	)
)

(instance crispin of View
	(properties
		x 159
		y 109
		view 762
		priority 7
		signal 16400
	)
)

(instance trunk of View
	(properties
		x 219
		y 118
		view 1101
		priority 8
		signal 16400
	)
)

(instance cCup of View ; UNUSED
	(properties
		x 144
		y 105
		view 777
		priority 6
		signal 16400
	)
)

(instance owlMouth of View
	(properties
		x 94
		y 94
		view 768
		loop 3
		priority 8
		signal 16400
	)
)

(instance eCup of View
	(properties
		x 155
		y 103
		view 777
		cel 1
		priority 6
		signal 16400
	)
)

(instance cTop of View
	(properties
		x 135
		y 107
		view 764
		loop 2
		cel 3
		priority 9
		signal 16400
	)
)

(instance cBottom of View
	(properties
		x 140
		y 124
		view 764
		cel 1
		priority 8
		signal 16400
	)
)

(instance syncIt of Prop
	(properties)
)

