;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 905)
(include sci.sh)
(use Main)
(use Print)
(use LoadMany)
(use Sound)
(use System)

(public
	aboutCode 0
)

(local
	local0
	local1
	local2
)

(instance aboutCode of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 20])
		(switch (= state newState)
			(0
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (== gMsgType 2)
					(= local2 1)
					(= gMsgType 1)
				)
				(Format @temp1 905 0) ; "CD.AD"
				(if (FileIO fiEXISTS @temp1)
					(= local0 1)
				)
				(switch
					(= temp0
						(if local0
							(Print
								posn: 75 60
								font: 4
								addButton: 1 0 0 1 0 24 0 908 ; "About King's Quest I-V"
								addButton: 2 0 0 2 0 24 18 908 ; "About King's Quest VI"
								addButton: 3 0 0 4 0 0 36 908 ; "Tips for playing King's Quest VI"
								addButton: 4 0 0 3 0 32 54 908 ; "Beginner Walk-Thru"
								addButton: 5 0 0 19 0 0 72 908 ; ""Girl in the Tower" theme song."
								init:
							)
						else
							(Print
								posn: 75 75
								font: 4
								addButton: 1 0 0 1 0 24 0 908 ; "About King's Quest I-V"
								addButton: 2 0 0 2 0 24 18 908 ; "About King's Quest VI"
								addButton: 3 0 0 4 0 0 36 908 ; "Tips for playing King's Quest VI"
								addButton: 4 0 0 3 0 32 54 908 ; "Beginner Walk-Thru"
								init:
							)
						)
					)
					(1
						(gCurRoom setScript: oneThroughFive)
					)
					(2
						(gCurRoom setScript: sixScript)
					)
					(3
						(gCurRoom setScript: tips)
					)
					(4
						(gCurRoom setScript: walkThrough)
					)
					(5
						(gCurRoom setScript: damnedAd)
					)
					(else
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance oneThroughFive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 5 0 self 908) ; "King's Quest I: Quest for the Crown  Long ago, in the kingdom of Daventry, there were three magical treasures that kept the kingdom strong and prosperous: A magic mirror that foretold the future, an enchanted shield with the power to protect from any invaders, and a treasure chest that was never empty."
			)
			(1
				(gMessager say: 0 0 11 0 self 908) ; "King's Quest II: Romancing the Throne  King Graham was a wise and kindly monarch. With his great wisdom, and the return of the three treasures, Daventry prospered once more. But Graham knew that he must soon marry and establish his own royal line with an heir to the throne."
			)
			(2
				(gMessager say: 0 0 12 0 self 908) ; "King's Quest III: To Heir is Human  Queen Valanice and King Graham soon became the parents of twins, a son and a daughter named Alexander and Rosella. Life in Daventry was peaceful and good--for a time. But the young prince was stolen from his cradle, and the kingdom went into years of deep mourning."
			)
			(3
				(gMessager say: 0 0 13 0 self 908) ; "King's Quest IV: The Perils of Rosella  Shortly after Prince Alexander's return, King Graham's health began to fail. The royal physicians were powerless to help him. Only a magical fruit from the faraway land of Tamir could bring about a cure and restore the health of Daventry's beloved monarch."
			)
			(4
				(gMessager say: 0 0 14 0 self 908) ; "King's Quest V: Absence Makes the Heart Go Yonder  But Daventry's fortune was not to continue unchallenged. An evil wizard called Mordack, brother of the ill-fated Manannan, was plotting revenge on the royal family."
			)
			(5
				(self dispose:)
				(if local2
					(= gMsgType 2)
				)
				(LoadMany 0 905)
			)
		)
	)
)

(instance sixScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Printf
					{King's Quest VI\nVersion: 1.000.00G\nThis entire work is Copyright 1992-93\nSierra On-Line, Inc. All rights reserved.}
				)
				(= cycles 1)
			)
			(1
				(gMessager say: 0 0 15 0 self 908) ; "King's Quest VI: Heir Today, Gone Tomorrow  King's Quest VI is the story of Prince Alexander's quest to woo Princess Cassima of the Land of the Green Isles. This tale of true love and brave challenge is proudly presented for your enjoyment by Roberta Williams and the King's Quest team."
			)
			(2
				(self dispose:)
				(if local2
					(= gMsgType 2)
				)
				(LoadMany 0 905)
			)
		)
	)
)

(instance tips of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 16 0 self 908) ; "King's Quest VI is a little different from any other King's Quest you might have played--and perhaps even from ANY adventure game you've ever played!"
			)
			(1
				(self dispose:)
				(if local2
					(= gMsgType 2)
				)
				(LoadMany 0 905)
			)
		)
	)
)

(instance walkThrough of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 18 0 self 908) ; "King's Quest VI Beginner's Walk-thru:"
			)
			(1
				(self dispose:)
				(if local2
					(= gMsgType 2)
				)
				(LoadMany 0 905)
			)
		)
	)
)

(instance damnedAd of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gGame isHandsOn:)
					(= local1 1)
				)
				(gGame handsOff: killSound: 1)
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(= cycles 1)
				else
					(gMessager say: 0 0 21 1 self 908) ; "You are unable to hear a sampling of the love ballad from King's Quest VI because your computer does not have voice capabilities. If you'd like to hear this song, please contact any of the radio stations listed on the station directory provided in your game box and request "Girl in the Tower" from Sierra On-Line. (This promotion ends January 31, 1993.) Look for the CD-ROM version of King's Quest VI available in Spring 1993. Thank you for playing King's Quest VI."
				)
			)
			(1
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(localMusic number: 11 init: play: self)
				else
					(= cycles 1)
				)
			)
			(2
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(gMessager say: 0 0 20 1 self 908) ; "You just heard a sampling of the love ballad, "Girl in the Tower," written for King's Quest VI. If you'd like to hear the entire song, please contact your local radio station and request it. Refer to the station directory included in your game box for call letters and phone numbers of participating stations. (This promotion ends January 31, 1993.) Look for the CD-ROM version of King's Quest VI available in Spring 1993. Thank you for playing King's Quest VI."
				else
					(= cycles 1)
				)
			)
			(3
				(if local1
					(gGame handsOn: killSound: 0)
				)
				(localMusic dispose:)
				(self dispose:)
				(if local2
					(= gMsgType 2)
				)
				(LoadMany 0 905)
			)
		)
	)
)

(instance localMusic of Sound
	(properties)
)

