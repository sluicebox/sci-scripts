;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 756)
(include sci.sh)
(use Main)
(use Interface)
(use File)
(use System)

(public
	about 0
)

(local
	[local0 100]
)

(instance about of Code
	(properties)

	(method (doit &tmp temp0 [temp1 255])
		(switch
			(= temp0
				(Print ; "King's Quest V"
					756
					0
					#font
					1
					#button
					{About KQV}
					1
					#button
					{Help}
					2
					#button
					{Cancel}
					0
					#button
					{Italian messages}
					3
				)
			)
			(3
				(if (== (gGame printLang:) 39)
					(gGame printLang: 1)
				else
					(gGame printLang: 39)
				)
			)
			(1
				(Format @temp1 756 1 gVersion gVersion) ; "King's Quest V by Roberta Williams Version: %s (c) 1990 Sierra On-Line, Inc."
				(Print @temp1 #mode 1)
				(Print 756 2 #width 210) ; "If you enjoyed the saga of King Graham in King's Quest V - Absence Makes the Heart Go Yonder, we're sure we can entice you to try out its illustrious predecessors."
				(Print 756 3 #width 210) ; "King's Quest I - Quest for the Crown In this game, Sir Graham is introduced and you can help him become King of Daventry by finding the realm's three lost treasures."
				(Print 756 4 #width 210) ; "King's Quest II - Romancing the Throne Graham has been King of Daventry for several years now and the realm is doing well. However, King Graham is lonely and needs a wife. No one will do but a lovely girl, Valanice, locked away in a quartz tower. If he can rescue her she will become queen."
				(Print 756 5 #width 210) ; "King's Quest III - To Heir is Human Twenty years have passed and King Graham and Queen Valanice have twin, teenaged children, Alexander and Rosella. Unfortunately, Alexander, as a baby, was stolen unnoticed from his crib one night. Help the boy find his way home to Daventry again."
				(Print 756 6 #width 210) ; "King's Quest IV - Perils of Rosella Prince Alexander has returned home and all seems well again. However, as things are prone to go, King Graham suffers a major heart attack and hovers near death. It's up to his daughter, Princess Rosella, to go in search of a magical fruit that will restore her father to perfect health again."
				(Print 756 7) ; "You might be interested in learning of other Sierra games by designer Roberta Williams. They are:"
				(Print 756 8 #width 210) ; "Mixed-Up Mother Goose This is a delightful adventure game written just for young children between the ages of 4 and 9. Your child will see him or herself onscreen and can help eighteen of Mother Goose's rhymes find their missing pieces. When a rhyme is completed your child will watch the rhyme "come to life" in rich animation and delightful songs."
				(Print 756 9 #width 210) ; "The Colonel's Bequest As a seeming departure (but not really, since her first game was a murder mystery) from her perceived role as a fantasy game designer, Roberta has come up with a real gem of a "who-done-it." This is a real period piece set in the bayous of Louisiana in the "Roaring Twenties." Become Laura Bow and help her solve the secrets of the Misty Acres Plantation."
				((File new:)
					name: {HELP.TXT}
					read: @local0 100
					close:
					dispose:
				)
				(Printf 756 10 @local0 @local0) ; "If you need further information on these games simply call Leader at %s"
				(DisposeScript 993)
			)
			(2
				((ScriptID 753) doit:) ; help
			)
		)
	)
)

